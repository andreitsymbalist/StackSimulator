package eu.grsu.stacksimulator.client;

import eu.grsu.stacksimulator.menu.context.MenuContext;
import eu.grsu.stacksimulator.menu.entities.MenuItem;

import java.util.List;

public class UserInterface {
    public static void run() {
        while (true) {
            List<MenuItem> menuItems = MenuContext.getCurrentMenu().getMenuItems();
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).getText());
            }
            ActionExecutor.execute();
        }
    }
}
