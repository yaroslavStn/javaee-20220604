package AppSpring.ui;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SpringUi {
    private final Scanner scanner = new Scanner(System.in);

    public String inputData() {
        return scanner.nextLine();
    }

    public void outputMessage(String s) {
        System.out.println(s);
    }

    public int readInt() {
        int choice = 0;
        try {
            String s = scanner.nextLine();
            choice = Integer.parseInt(s);
        } catch (Exception e) {
            outputMessage("Incorrect, enter another");
            readInt();
        }
        return choice;
    }
}
