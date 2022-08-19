package items;

import controller.Controller;
import menu.Item;


public class ExitItem extends Item {
    private final Controller controller;

    public ExitItem(Controller controller) {
        super("Exit", true);
        this.controller=controller;
    }

    @Override
    public void exec() {
        controller.exit();
    }
}
