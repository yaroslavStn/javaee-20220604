package items;

import controller.Controller;
import menu.Item;

public class FindCityByIdItem extends Item {
    private final Controller controller;
    public FindCityByIdItem(Controller controller) {
        super("Find city by ID");
        this.controller=controller;
    }

    @Override
    public void exec() {
        controller.findCityById();

    }
}
