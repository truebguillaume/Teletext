package ch.heigvd.NewsServer;

import ch.heigvd.Shared.*;

import java.io.IOException;
import java.net.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewsServer {

    private final List<News> newsList = new ArrayList<>();

    public void start() {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // The number of threads in the pool must be the same as the number of tasks you want to run in parallel

        try {
            executorService.submit(new NewsReceiver()); // Start the first task
            executorService.submit(new ClientServer()); // Start the second task

            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for termination
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public class NewsReceiver implements Runnable{
        @Override
        public void run() {
            try {
                // Création du socket multicast
                MulticastSocket socket = new MulticastSocket(5000);

                // Joindre chaque groupe multicast
                for (String type : TypeNews.mapTypeIP.keySet()) {
                    InetAddress group = InetAddress.getByName(TypeNews.mapTypeIP.get(type));
                    socket.joinGroup(group);
                }

                byte[] buffer = new byte[1024];

                while (true) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    // Traitement des données reçues
                    String received = new String(packet.getData(), 0, packet.getLength());
                    String[] splitted = received.split(" ");

                    News newsToAdd = new News(splitted[1], splitted, splitted[0].contains("BK"));
                    newsList.add(newsToAdd);
                    System.out.println("Received: " + newsToAdd);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ClientServer implements Runnable{

        private final static String TXTCODE = "TXT ", ERRCODE = "ERR ";

        @Override
        public void run() {
            final int serverPort = 5001;

            try {
                DatagramSocket socket = new DatagramSocket(serverPort);

                while (true) {

                    // Attente du message du client
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);

                    String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Message du client : " + clientMessage);

                    // Réponse au client
                    String responseMessage = handleMessage(clientMessage.split(" "));
                    byte[] sendData = responseMessage.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                    socket.send(sendPacket);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String handleMessage(String[] clientMessages) {
            switch (clientMessages[0]) {
                case "welcome":
                    return printCommandMenu();
                case "help":
                    return TXTCODE + printHelpMenu();
                case "menu":
                    return printNewsMenu();
                case "list":
                    return clientMessages.length > 1 ? listNews(clientMessages[1]) : ERRCODE + "201";
                case "count":
                    return clientMessages.length > 1 ? countNews(clientMessages[1]) : ERRCODE + "201";
                default:
                    return ERRCODE + "100";
            }
        }

        private String printCommandMenu() {
            return TXTCODE + "TELETEXT - The only way to inform you!\n" +
                    "Here you will have different canals in which you will find the latest news.\n" +
                    printHelpMenu();
        }

        private String printHelpMenu() {
            return "A summary of availables commands : \n" +
                    "- help : print a menu with all available commands\n" +
                    "- menu : list all existing categories\n" +
                    "- list <category> : list the news for the selected category\n" +
                    "- count <category> : print the number of the news for the selected category\n" +
                    "- exit : quit the application";
        }

        private String printNewsMenu() {
            StringBuilder output = new StringBuilder();
            output.append(TXTCODE + "Please choose a news category to list with command list <category>. \n");
            for (String key : TypeNews.newsListUserChoice) {
                output.append(key).append("\n");
            }
            return output.toString();
        }

        private String listNews(String category) {
            StringBuilder output = new StringBuilder();
            if(checkCategory(category).contains(ERRCODE))
                return checkCategory(category);
            for (News news : newsList) {
                if(Objects.equals(news.getType(), category.toUpperCase()) ||
                        (Objects.equals(category.toUpperCase(), "BREAKING NEWS") && news.isBreakingNews())){
                    output.append(news).append("\n");
                }
            }
            if(output.length() == 0)
                output.append(ERRCODE + "200");
            else
                output.insert(0, TXTCODE);

            return output.toString();
        }

        private String countNews(String category) {
            int count = 0;
            if(checkCategory(category).contains(ERRCODE))
                return checkCategory(category);
            for (News news : newsList) {
                if(Objects.equals(news.getType(), category.toUpperCase()) ||
                        (Objects.equals(category.toUpperCase(), "BREAKING NEWS") && news.isBreakingNews())){
                    count++;
                }
            }
            return TXTCODE + count;
        }

        private String checkCategory(String category) {
            if(!TypeNews.newsListUserChoice.contains(category.toUpperCase()))
                return ERRCODE + "201";
            return "";
        }
    }
}
