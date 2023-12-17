package ch.heigvd.NewsEmitter;

import ch.heigvd.Shared.*;

import java.io.IOException;
import java.net.*;
import java.util.Random;

public class NewsEmitter {

    final static int PORT = 5000;

    public void start(String newsType) {

        newsType = newsType.toUpperCase();

        if(!TypeNews.mapTypeIP.containsKey(newsType)){
            System.err.println("This type of news doesn't exist!");
        } else {
            DatagramSocket datagramSocket = null;

            try {
                // Création du socket UDP
                datagramSocket = new DatagramSocket();

                // Boucle d'emission
                while (true) {
                    String news = "";
                    switch (newsType) {
                        case "WEATHER":
                            news = "WEATHER " + NewsCreator.getRandomWeatherNews();
                            break;
                        case "HEIG":
                            news = "HEIG " + NewsCreator.getRandomHeigNews();
                            break;
                        case "POLITIC":
                            news = "POLITIC " + NewsCreator.getRandomPoliticNews();
                            break;
                        case "SPORT":
                            news = "SPORT " + NewsCreator.getRandomSportNews();
                            break;
                    }

                    // Choix des Breaking news
                    Random random = new Random();
                    int randomNumber = random.nextInt(5);
                    if(randomNumber == 4){
                        news = "BK " + news;
                    }else {
                        news = "NW " + news;
                    }

                    // Creation du datagramm
                    byte[] data = news.getBytes();
                    InetAddress address = InetAddress.getByName(TypeNews.mapTypeIP.get(newsType));
                    DatagramPacket packet = new DatagramPacket(data, data.length, address, PORT);

                    // Envoie du datagramm
                    datagramSocket.send(packet);
                    System.out.println("> News sent (" + newsType + ") on " + address);


                    randomNumber = (random.nextInt(26) + 5)*1000; // de 5 a 30

                    // Attente avant d'envoyer la prochaine nouvelle (10 secondes)
                    Thread.sleep(randomNumber);
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
}