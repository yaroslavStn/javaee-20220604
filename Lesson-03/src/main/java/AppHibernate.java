import controller.Controller;
import items.*;
import menu.ConsoleMenu;
import menu.Item;
import menu.Menu;
import ui.CityUI;
import ui.ConsoleCityUI;

import java.util.Scanner;

public class AppHibernate {
    public static void main(String[] args) {
new AppHibernate().run();
    }

    private void run() {
        Scanner sc= new Scanner(System.in);
        CityUI ui = new ConsoleCityUI(sc);


        Controller controller = new Controller(ui);
        Item[] items ={
                new AddCityItem(controller),
                new FindCityByIdItem(controller),
                new FindCityByNameItem(controller),
                new PrintCitiesItem(controller),
                new DeleteCityItem(controller),
                new ExitItem(controller)
        };

        Menu menu = new ConsoleMenu(sc,items);
        menu.run();
    }
}
