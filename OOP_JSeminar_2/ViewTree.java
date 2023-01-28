import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ViewTree {
    private static String output = "";

    public static String makePersonList(Person human, int count, int level) {
        String line = "";
        String relative = "";
        String humanSex = human.getSex();
        int grandCount = level - 1;
        List<Person> personCollection = human.getPersonList();

        if (count > 0) {
            line = "--".repeat(count) + "|";
        }

        switch (level) {
            case 0:
                break;

            case 1:
                if (humanSex.equals("female")) {
                    relative = " - daughter";
                } else if (humanSex.equals("male")) {
                    relative = " - son";
                }
                break;

            default:
                if (humanSex.equals("female")) {
                    relative = " - " + "grand".repeat(grandCount) + "daughter";
                } else if (humanSex.equals("male")) {
                    relative = " - " + "grand".repeat(grandCount) + "son";
                }
                break;
        }

        String result;

        if (human.getAnimalList().isEmpty()) {
            result = line + human + relative + ", animals: no" + "\n";
        } else {
            result = line + human + relative + ", animals: "
                    + human.getAnimalList() + "\n";
        }

        output += result;

        for (Person element : personCollection) {
            makePersonList(element, count + 1, level + 1);
        }

        return output;
    }

    public static void savePersonList(String tree) {
        // записываем полученное дерево в файл
        byte data[] = tree.getBytes();
        Path p = Paths.get("./output.txt");

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(p))) {
            out.write(data);

        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
