package ch.heigvd.NewsClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NewsClient {

    public void start() {
        final int serverPort = 9876;

        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            byte[] sendData = "menu".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), serverPort);
            socket.send(sendPacket);

            while (true) {

                // Attente de la réponse du serveur
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(receivedMessage);

                // L'utilisateur saisit le message à envoyer
                System.out.print("> ");
                String messageToSend = scanner.nextLine();

                // Envoi du message au serveur
                sendData = messageToSend.getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), serverPort);
                socket.send(sendPacket);

                // Quitter la boucle si l'utilisateur a saisi 'exit'
                if (messageToSend.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Fermeture du scanner et de la socket
            scanner.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

