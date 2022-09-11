package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindCityByIdItem extends Item {
    private final Service service;


    public FindCityByIdItem(Service service) {
        super("Find City by ID");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findById(KeyWord.CITY);
    }
}
