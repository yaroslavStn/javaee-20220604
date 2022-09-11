package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;

public class AddCityItem extends Item {
    private final Service service;

    public AddCityItem(Service service) {
        super("Add City");
        this.service = service;
    }

    @Override
    public void exec() {
service.addCity();
    }
}
