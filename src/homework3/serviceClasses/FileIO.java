package homework3.serviceClasses;

import homework3.enums.ServiceMessage;
import homework3.enums.Trait;
import homework3.human.Musketeer;

import java.io.*;
import java.nio.file.Path;

public class FileIO {

    private static final Path pathToDefaultMusketeers = Path.of("src\\homework3\\resources\\humans\\player.txt");

    public static void savePlayer(Musketeer player) {
        try(FileWriter writer = new FileWriter(pathToDefaultMusketeers.toString())) {

            writer.write(player.getMainInfo());
            System.out.println(ServiceMessage.SAVE_SUCCESS);

        } catch (IOException e) {
            System.out.println(ServiceMessage.SAVE_EXCEPTION);
        }
    }

    public static Musketeer loadPlayer() {
        try(BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(pathToDefaultMusketeers)))) {
            String name = reader.readLine().trim();
            Trait trait = Trait.valueOf(reader.readLine().trim());

            System.out.println(ServiceMessage.LOAD_SUCCESS);
            return new Musketeer(name, trait);
        }
        catch (Exception e) {
            System.out.println(ServiceMessage.LOAD_EXCEPTION);
            return new PersonCreator().createMusketeer();
        }
    }
}
