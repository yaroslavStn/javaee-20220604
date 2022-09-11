package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;

public class AddCountryItem extends Item {
    private final Service service;

    public AddCountryItem(Service service) {
        super("Add Country");
        this.service = service;
    }

    @Override
    public void exec() {
        service.addCountry();
    }
}
