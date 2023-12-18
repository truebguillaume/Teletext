package ch.heigvd.NewsClient;

import java.net.*;
import java.util.Scanner;

public class NewsClient {

    public void start(int serverPort) {

        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            // Envoi le code menu à la connexion pour afficher celui-ci
            byte[] sendData = "welcome".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("localhost"), serverPort);
            socket.send(sendPacket);

            while (true) {

                // Attente de la réponse du serveur
                byte[] receiveData = new byte[10240];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                String[]  splitMessage = receivedMessage.split(" ");
                handleMessage(splitMessage);

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

    private void handleMessage(String[] messages) {
        if(messages[0].equals("TXT")) {
            for(int i = 1 ; i < messages.length ; ++i)
                System.out.print(messages[i] + " ");
        }
        else if(messages[0].equals("ERR")){
            handleError(messages[1]);
        }
        System.out.println();
    }

    private void handleError(String errorCode) {
        switch(errorCode) {
            case "100":
                System.err.println("Unknown command, please retry.");
                break;
            case "200":
                System.err.println("Currently, there is no news in this category.");
                break;
            case "201":
                System.err.println("Currently, this category does not exist.");
                break;
            default:
                System.err.println("Error, something went wrong.");
                break;
        }
    }
}

