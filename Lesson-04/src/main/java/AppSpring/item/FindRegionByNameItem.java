package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindRegionByNameItem extends Item {

private final Service service;

    public FindRegionByNameItem(Service service) {
        super("Find Region by Name");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findByName(KeyWord.REGION);

    }
}
