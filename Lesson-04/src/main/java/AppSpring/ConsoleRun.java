package AppSpring;

import AppSpring.item.*;
import AppSpring.menu.ConsoleMenu;
import AppSpring.menu.Item;
import AppSpring.menu.Menu;
import AppSpring.services.Service;
import AppSpring.ui.SpringUi;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.logging.Logger;

@Component
public class ConsoleRun {
    private static final Logger log = Logger.getLogger(ConsoleRun.class.getName());

    private Service service;

    public ConsoleRun(Service service) {
        this.service = service;
    }

    public void run() {
        Item[] items = {
                new AddCityItem(service),
                new FindCityByIdItem(service),
                new FindCityByNameItem(service),

                new AddRegionItem(service),
                new FindRegionByIdItem(service),
                new FindRegionByNameItem(service),

                new AddCountryItem(service),
                new FindCountryByIdItem(service),
                new FindCountryByNameItem(service),

                new ExitItem(service)
        };

        Menu menu = new ConsoleMenu(items);
        menu.run();

    }
}


