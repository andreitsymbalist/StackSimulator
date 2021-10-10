package eu.grsu.stacksimulator.initialization.initializers.menu;

import eu.grsu.stacksimulator.actions.Action;
import eu.grsu.stacksimulator.initialization.initializers.Initializer;
import eu.grsu.stacksimulator.menu.entities.Menu;
import eu.grsu.stacksimulator.menu.context.MenuContext;
import eu.grsu.stacksimulator.menu.entities.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MenuInitializer implements Initializer {

    private final Map<String, Action> actionMap;

    @Autowired
    public MenuInitializer(Map<String, Action> actionMap) {
        this.actionMap = actionMap;
    }

    @Override
    public void init() {
        MenuContext.setCurrentMenu(Menu.builder()
                .menuItems(new ArrayList<>())
                .build());

        List<MenuItem> menuItemList = MenuContext.getCurrentMenu().getMenuItems();

        menuItemList.add(MenuItem.builder()
                .text("Print stack trace")
                .action(actionMap.get("printStackTraceAction"))
                .build());

        menuItemList.add(MenuItem.builder()
                .text("Check balance brackets")
                .action(actionMap.get("checkBalanceBracketsAction"))
                .build());

        menuItemList.add(MenuItem.builder()
                .text("Solve expression")
                .action(actionMap.get("solveExpressionAction"))
                .build());

        menuItemList.add(MenuItem.builder()
                .text("Exit")
                .action(actionMap.get("exitMenuAction"))
                .build());
    }
}
