package AppSpring.item;

import AppSpring.services.Service;
import AppSpring.menu.Item;
import AppSpring.menu.KeyWord;

public class FindRegionByIdItem extends Item {
    private final Service service;

    public FindRegionByIdItem(Service service) {
        super("Find Region by ID");
        this.service = service;
    }

    @Override
    public void exec() {
        service.findById(KeyWord.REGION);
    }
}
