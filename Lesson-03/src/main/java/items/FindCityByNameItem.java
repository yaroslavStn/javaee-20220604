package items;

import controller.Controller;
import menu.Item;

public class FindCityByNameItem extends Item {
    private final Controller controller;

    public FindCityByNameItem(Controller controller) {
        super("Find city by name");
        this.controller=controller;
    }

    @Override
    public void exec() {
        controller.findCityByName();

    }
}

