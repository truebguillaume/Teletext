package ch.heigvd.PicoCLI;

import ch.heigvd.NewsServer.NewsServer;
import picocli.CommandLine;

@CommandLine.Command(
        name = "Teletext - A new way to be kept informed!",
        version = "1.0",
        description = "Start what you want!",
        subcommands = { PicoCLI.NewsEmitter.class, PicoCLI.NewsServer.class, PicoCLI.NewsClient.class },
        mixinStandardHelpOptions = true)
public class PicoCLI{

    @CommandLine.Command(
            name = "emitter",
            version = "1.0",
            description = "Start the emitters.",
            mixinStandardHelpOptions = true)
    public static class NewsEmitter implements Runnable{

        @CommandLine.Parameters(description = "Type of news you want to emitt.")
        private String newsType;

        @Override
        public void run() {
            ch.heigvd.NewsEmitter.NewsEmitter e = new ch.heigvd.NewsEmitter.NewsEmitter();
            e.start(newsType);
        }
    }

    @CommandLine.Command(
            name = "server",
            version = "1.0",
            description = "Start the server that get news emitted.",
            mixinStandardHelpOptions = true)
    public static class NewsServer implements Runnable{
        @Override
        public void run() {
            ch.heigvd.NewsServer.NewsServer server = new ch.heigvd.NewsServer.NewsServer();
            server.start();
        }
    }

    @CommandLine.Command(
            name = "client",
            version = "1.0",
            description = "Start the clients to read news.",
            mixinStandardHelpOptions = true)
    public static class NewsClient implements Runnable{

        //@CommandLine.Parameters(description = "Your port")
        //private int port;

        @Override
        public void run() {
            ch.heigvd.NewsClient.NewsClient n = new ch.heigvd.NewsClient.NewsClient();
            n.start();
        }
    }
}