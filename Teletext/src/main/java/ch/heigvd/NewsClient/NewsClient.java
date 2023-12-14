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
/*
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

*/
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