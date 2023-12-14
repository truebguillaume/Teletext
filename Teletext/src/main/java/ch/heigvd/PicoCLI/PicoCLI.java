package ch.heigvd.PicoCLI;

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

        @CommandLine.Option(
                names = {"-t", "--type"},
                required = true,
                description = "Type of news you want to emitt.")
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

        }
    }

    @CommandLine.Command(
            name = "client",
            version = "1.0",
            description = "Start the clients to read news.",
            mixinStandardHelpOptions = true)
    public static class NewsClient implements Runnable{
        @Override
        public void run() {

        }
    }
}