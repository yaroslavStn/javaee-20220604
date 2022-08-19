package items;

import controller.Controller;
import menu.Item;

public class PrintCitiesItem extends Item {
    private final Controller controller;
    public PrintCitiesItem(Controller controller) {
        super("Print city`s order");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.printCities();

    }
}
