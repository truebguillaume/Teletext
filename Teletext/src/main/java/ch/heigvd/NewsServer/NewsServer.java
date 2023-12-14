package ch.heigvd.NewsServer;

import ch.heigvd.Shared.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            DatagramSocket socket = null;
            try {
                // Adresse IP et port du serveur
                String serverIP = "127.0.0.1";
                int serverPort = 5001;

                // Creation du socket UDP
                socket = new DatagramSocket(serverPort);

                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

                while (true) {

                    // Réception de la réponse du serveur
                    byte[] receiveData = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    socket.receive(receivePacket);

                    // Afficher la réponse du serveur
                    String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Réponse du serveur: " + serverResponse);

                    // Lire l'entrée de l'utilisateur
                    System.out.print("Entrez votre commande: ");
                    String userMessage = consoleInput.readLine();

                    // Convertir le message en tableau de bytes
                    byte[] sendData = userMessage.getBytes();

                    // Créer un datagramme à envoyer au serveur
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(serverIP), serverPort);

                    // Envoyer le datagramme
                    socket.send(sendPacket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    socket.close(); // Fermer le socket à la fin
                }
            }
        }
    }
}
