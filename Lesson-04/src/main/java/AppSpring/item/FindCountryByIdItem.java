package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindCountryByIdItem extends Item {
    private final Service service;
    public FindCountryByIdItem(Service service) {
        super("Find Country by ID");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findById(KeyWord.COUNTRY);

    }
}
