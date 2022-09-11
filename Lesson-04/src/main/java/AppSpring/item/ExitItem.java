package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;


public class ExitItem extends Item {
    private final Service service;

    public ExitItem(Service service) {
        super("Exit", true);
        this.service = service;
    }

    @Override
    public void exec() {
        service.exit();
    }
}
