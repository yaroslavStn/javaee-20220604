package items;

import controller.Controller;
import menu.Item;

public class AddCityItem extends Item {
    private final Controller controller;

    public AddCityItem(Controller controller) {
        super("Add city");
        this.controller = controller;
    }

    @Override
    public void exec() {
        controller.addCity();

    }
}
