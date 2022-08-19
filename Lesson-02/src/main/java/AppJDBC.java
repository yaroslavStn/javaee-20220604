import controller.Controller;

public class AppJDBC {
    public static void main(String[] args) {

        new AppJDBC().run();

    }

    private void run() {
        Controller controller = new Controller();
        controller.addTable();
        controller.addStudent();
        controller.addStudent();
        controller.printer();
    }
}
