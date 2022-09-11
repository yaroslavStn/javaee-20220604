package AppSpring.menu;

import java.util.Scanner;

public class ConsoleMenu implements Menu {
    private final Scanner sc = new Scanner(System.in);
    private final Item[] items;
    private Exception exception;

    public ConsoleMenu(Item[] items) {
        this.items = items;
    }

    @Override
    public void run() {
        for (; ; ) {
            showMenu();
            System.out.println("Enter choice:");

            int choice = 0;
            boolean correct = true;
            while (correct) {
                String s = sc.nextLine();
                try {
                    choice = Integer.parseInt(s) - 1;
                    if (choice >= 0 && choice < items.length) {
                        correct = false;
                    } else {
                        throw exception;
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect, enter another");
                }
            }
            items[choice].exec();
            if (items[choice].isExit()) {
                break;
            }
        }

    }


    private void showMenu() {
        System.out.println("--------Menu--------");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + " - " + items[i].getName());
        }

    }
}
