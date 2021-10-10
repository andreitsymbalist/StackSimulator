package eu.grsu.stacksimulator.menu.entities;

import eu.grsu.stacksimulator.actions.Action;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MenuItem {
    private String text;
    private Action action;
    private Menu submenu;
}