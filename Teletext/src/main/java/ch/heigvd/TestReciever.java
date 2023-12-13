package ch.heigvd;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestReciever {
    public static void main(String[] args) {
        int port = 8888; // Port de réception des nouvelles

        try {
            // Création du socket UDP pour recevoir
            DatagramSocket datagramSocket = new DatagramSocket(port);

            // Buffer pour stocker les données reçues
            byte[] receiveData = new byte[1024];

            while (true) {
                // Préparation du paquet pour recevoir les données
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                // Réception du paquet
                datagramSocket.receive(receivePacket);

                // Conversion des données reçues en chaîne de caractères
                String receivedNews = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Affichage de la nouvelle reçue
                System.out.println("Received news: " + receivedNews);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
