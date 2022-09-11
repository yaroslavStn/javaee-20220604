package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;

public class AddRegionItem extends Item {
    private final Service service;

    public AddRegionItem (Service service) {
        super("Add Region");
        this.service = service;
    }

    @Override
    public void exec() {
        service.addRegion();
    }
}
