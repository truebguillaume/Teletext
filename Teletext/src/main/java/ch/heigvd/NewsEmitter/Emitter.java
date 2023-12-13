package ch.heigvd.NewsEmitter;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Emitter {

    private String ipAddress;
    int port;

    public Emitter(String ipAddress, int port){
        this.ipAddress = ipAddress;
        this.port = port;
    }
    public void start() {

        DatagramSocket datagramSocket = null;

        try {
            // Création du socket UDP
            datagramSocket = new DatagramSocket();

            // Boucle d'emission
            while (true) {
                // Selection du type de la news
                Random random = new Random();
                int randomNumber = random.nextInt(4) + 1;
                String news = "";
                String type = "";
                switch (randomNumber) {
                    case 1:
                        news = NewsCreator.getRandomWeatherNews();
                        type = "Météo";
                        break;
                    case 2:
                        news = NewsCreator.getRandomHeigNews();
                        type = "HEIG";
                        break;
                    case 3:
                        news = NewsCreator.getRandomPolitiqueNews();
                        type = "Politique";
                        break;
                    case 4:
                        news = NewsCreator.getRandomSportNews();
                        type = "Sport";
                        break;
                }

                // Creation du datagramm
                byte[] data = news.getBytes();
                InetAddress address = InetAddress.getByName(ipAddress);
                DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

                // Envoie du datagramm
                datagramSocket.send(packet);
                System.out.println("> News sent (" + type + ")");

                // Attente avant d'envoyer la prochaine nouvelle (10 secondes)
                Thread.sleep(10000);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
}