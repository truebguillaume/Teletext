package ch.heigvd.NewsEmitter;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class NewsEmitter {

    public static void main(String[] args) {
        final int port = 8888;
        DatagramSocket socket = null;
        NewsCreator nc = new NewsCreator();

        try {
            socket = new DatagramSocket();
            socket.setBroadcast(true);

            while (true) {
                Random random = new Random();
                int randomNumber = random.nextInt(4) + 1;
                String news = "";
                switch (randomNumber){
                    case 1:
                        news = NewsCreator.getRandomWeatherNews();
                        break;
                    case 2:
                        news = NewsCreator.getRandomHeigNews();
                        break;
                    case 3:
                        news = NewsCreator.getRandomPolitiqueNews();
                        break;
                    case 4:
                        news = NewsCreator.getRandomSportNews();
                        break;
                }

                byte[] sendData = news.getBytes();

                InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255");
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length, broadcastAddress, port);

                // Envoie du datagramm
                socket.send(packet);
                System.out.println("News sent");

                // Attente avant d'envoyer la prochaine nouvelle (10 secondes)
                Thread.sleep(10000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
