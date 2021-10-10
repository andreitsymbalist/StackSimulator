package eu.grsu.stacksimulator.menu.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Menu {
    private List<MenuItem> menuItems;
    private Menu previousMenu;
}
