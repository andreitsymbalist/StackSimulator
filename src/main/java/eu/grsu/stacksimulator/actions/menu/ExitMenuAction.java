package eu.grsu.stacksimulator.actions.menu;

import eu.grsu.stacksimulator.actions.Action;
import eu.grsu.stacksimulator.menu.context.MenuContext;
import org.springframework.stereotype.Component;

@Component
public class ExitMenuAction implements Action {
    @Override
    public void execute(int index) {
        if (MenuContext.getCurrentMenu().getPreviousMenu() == null) {
            System.exit(0);
        }
        MenuContext.setCurrentMenu(MenuContext.getCurrentMenu().getPreviousMenu());
    }
}