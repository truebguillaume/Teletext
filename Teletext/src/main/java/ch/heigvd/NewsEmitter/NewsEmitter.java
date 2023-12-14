package ch.heigvd.NewsEmitter;

import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NewsEmitter {

    int port = 5000;
    private Map<String, String> typeNewsIPAddress = new HashMap<String, String>() {{
        put("weather", "239.0.0.1");
        put("heig", "239.0.0.2");
        put("politic", "239.0.0.3");
        put("sport", "239.0.0.4");
    }};

    public void start(String newsType) {

        if(!typeNewsIPAddress.containsKey(newsType)){
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
                        case "weather":
                            news = NewsCreator.getRandomWeatherNews();
                            break;
                        case "heig":
                            news = NewsCreator.getRandomHeigNews();
                            break;
                        case "politic":
                            news = NewsCreator.getRandomPoliticNews();
                            break;
                        case "sport":
                            news = NewsCreator.getRandomSportNews();
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
                    InetAddress address = InetAddress.getByName(typeNewsIPAddress.get(newsType));
                    DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

                    // Envoie du datagramm
                    datagramSocket.send(packet);
                    System.out.println("> News sent (" + newsType + ") on " + address);

                    // Attente avant d'envoyer la prochaine nouvelle (10 secondes)
                    Thread.sleep(5000);
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