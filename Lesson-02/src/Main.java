import controller.Controller;

public class Main {
    public static void main(String[] args) {

        new Main().run();

    }

    private void run() {
        Controller controller = new Controller();
        controller.addTable();
        controller.addStudent();
        controller.addStudent();
        controller.printer();
    }
}
