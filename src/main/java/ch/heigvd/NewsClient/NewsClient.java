package ch.heigvd.NewsClient;/*
package ch.heigvd.NewsClient;

import ch.heigvd.PicoCLI.PicoCLI;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NewsClient {
    private int port = 5001;
    private String ipAddress = "127.0.0.1";

    public NewsClient(int port, String ipAddress){
        this.port = port;
        this.ipAddress = ipAddress;
        this.start();
    }


    private void start() {
        try (DatagramSocket socket = new DatagramSocket(port)) {
            String myself = InetAddress.getLocalHost().getHostAddress() + ":" + port;
            System.out.println("> Client unicast receiver started on /" + myself);

            byte[] receiveData = new byte[1024];

            while (true) {

                // Lire la réponse du serveur
                String line;
                StringBuilder textOut = new StringBuilder();
                while ((line = bin.readLine()) != null && !line.equals(EOT)) {
                    textOut.append(line);
                }

                handleMessage(textOut.toString().split("_"));

                // Ecris le message à envoyer au serveur
                String userMessage = consoleInput.nextLine();

                // Envoyer le message au serveur
                out.println(userMessage);


                DatagramPacket packet = new DatagramPacket(
                        receiveData,
                        receiveData.length
                );

                socket.receive(packet);

                String message = new String(
                        packet.getData(),
                        packet.getOffset(),
                        packet.getLength(),
                        StandardCharsets.UTF_8
                );

                System.out.println("Unicast receiver (" + myself + ") received message: " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(String serverIP, int serverPort) {

        try {

            socket = new Socket(serverIP, serverPort);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new Scanner(socket.getInputStream());
            bin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            consoleInput = new Scanner(System.in);

            // Boucle pour permettre à l'utilisateur d'envoyer des messages au serveur
            while (true) {

                // Lire la réponse du serveur
                String line;
                StringBuilder textOut = new StringBuilder();
                while ((line = bin.readLine()) != null && !line.equals(EOT)) {
                    textOut.append(line);
                }

                handleMessage(textOut.toString().split("_"));

                // Ecris le message à envoyer au serveur
                String userMessage = consoleInput.nextLine();

                // Envoyer le message au serveur
                out.println(userMessage);

            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void handleMessage(String[] messages) {
        if(messages[0].equals("EGE")){
            // Fermer la connexion

        }
        else if(messages[0].equals("ERR")){

        }
        else if (messages[0].equals("CMD")) {

        }
        else if(messages[0].equals("TXT")) {

        }
    }


}
*/


import java.io.*;
import java.net.*;

public class NewsClient {

    public void start() {
        DatagramSocket socket = null;
        try {
            // Adresse IP et port du serveur
            String serverIP = "192.168.1.100";
            int serverPort = 5001;

            // Creation du socket UDP
            socket = new DatagramSocket(serverPort);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                // Lire l'entrée de l'utilisateur
                System.out.print("Entrez votre commande: ");
                String userMessage = consoleInput.readLine();

                // Convertir le message en tableau de bytes
                byte[] sendData = userMessage.getBytes();

                // Créer un datagramme à envoyer au serveur
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(serverIP), serverPort);

                // Envoyer le datagramme
                socket.send(sendPacket);

                // Réception de la réponse du serveur
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                // Afficher la réponse du serveur
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Réponse du serveur: " + serverResponse);
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

