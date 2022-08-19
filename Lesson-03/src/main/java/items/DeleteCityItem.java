package items;

import controller.Controller;
import menu.Item;

public class DeleteCityItem extends Item{
        private final Controller controller;

        public DeleteCityItem(Controller controller) {
            super("Delete city");
            this.controller = controller;
        }

        @Override
        public void exec() {
            controller.deleteCity();

        }
}
