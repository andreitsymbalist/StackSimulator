package eu.grsu.stacksimulator.menu.context;

import eu.grsu.stacksimulator.menu.entities.Menu;
import lombok.Getter;
import lombok.Setter;

public class MenuContext {
    @Getter
    @Setter
    private static Menu currentMenu;
}
