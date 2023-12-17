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

    private List<News> newsList = new ArrayList<>();

    public Integer start() {
        ExecutorService executorService = Executors.newFixedThreadPool(2); // The number of threads in the pool must be the same as the number of tasks you want to run in parallel

        try {
            executorService.submit(new NewsReceiver()); // Start the first task
            executorService.submit(new ClientServer()); // Start the second task

            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS); // Wait for termination
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        } finally {
            executorService.shutdown();
        }

        return 0;
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

                    News newsToAdd = new News(splitted[1], splitted, LocalDateTime.now(), splitted[0].contains("BK"));
                    newsList.add(newsToAdd);
                    System.out.println("Received: " + newsToAdd);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class ClientServer implements Runnable{
        @Override
        public void run() {
            final int serverPort = 9876;

            try {
                DatagramSocket socket = new DatagramSocket(serverPort);



                while (true) {

                    // Attente du message du client
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);

                    String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Message du client : " + clientMessage);

                    // Réponse au client uniquement si le message n'est pas 'exit'
                    if (!clientMessage.equalsIgnoreCase("exit")) {
                        // Réponse au client
                        String responseMessage = handleMessage(clientMessage.split(" "));
                        byte[] sendData = responseMessage.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(), receivePacket.getPort());
                        socket.send(sendPacket);
                    } else {
                        // Quitter la boucle si le client a saisi 'exit'
                        break;
                    }
                }

                // Fermeture de la socket
                socket.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String handleMessage(String[] clientMessages) {
            switch (clientMessages[0]) {
                case "menu":
                    return printMenu();
                case "list":
                    return printNews(clientMessages[1]);
                default:
                    return "Unknown command. Please retry.";
            }
        }

        private String printMenu() {
            StringBuilder output = new StringBuilder();
            output.append("Please choose a news category to print with command list <categories>. \n");
            for (String key : TypeNews.mapTypeIP.keySet()) {
                output.append(key).append("\n");
            }
            output.append("BREAKING NEWS");
            return output.toString();
        }

        private String printNews(String type) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < newsList.size(); i++) {
                News news = newsList.get(i);

                if (Objects.equals(news.getType(), type.toUpperCase()) || (Objects.equals(type, "BREAKING") && news.isBreakingNews())) {
                    output.append(news);

                    if (i < newsList.size() - 1)
                        output.append("\n");
                }
            }
            if (output.length() == 0)
                output.append("No news in this category.");

            return output.toString();
        }

    }
}
