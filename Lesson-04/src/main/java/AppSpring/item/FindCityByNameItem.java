package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindCityByNameItem extends Item {

    private final Service service;


    public FindCityByNameItem(Service service) {
        super("Find City by Name");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findByName(KeyWord.CITY);

    }
}
