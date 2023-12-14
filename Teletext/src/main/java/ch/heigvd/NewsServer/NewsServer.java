package ch.heigvd.NewsServer;

import ch.heigvd.Shared.*;

import java.io.IOException;
import java.net.*;
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
        @Override
        public void run() {
            System.out.println("Salut");
        }
    }
}
