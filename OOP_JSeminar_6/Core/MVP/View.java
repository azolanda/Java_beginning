package Core.MVP;

import java.util.Scanner;

public class View {

    public String input(Scanner scan) {
        return scan.nextLine();
    }

    public <T> void viewInformation(T information) {
        System.out.print(information);
    }
}