package ch.heigvd;

import ch.heigvd.PicoCLI.PicoCLI;
import picocli.CommandLine;
public class Main {
    public static void main(String[] args) {
        CommandLine main = new CommandLine(new PicoCLI());
        main.execute(args);

        System.exit(0);
    }
}