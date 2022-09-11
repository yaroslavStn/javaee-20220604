package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindCountryByNameItem extends Item {

private final Service service;


    public FindCountryByNameItem(Service service) {
        super("Find Country by Name");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findByName(KeyWord.COUNTRY);

    }
}
