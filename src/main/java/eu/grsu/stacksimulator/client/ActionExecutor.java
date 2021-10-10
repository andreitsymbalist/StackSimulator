package eu.grsu.stacksimulator.client;

import eu.grsu.stacksimulator.menu.context.MenuContext;
import eu.grsu.stacksimulator.utils.console.ConsoleUtil;

public class ActionExecutor {
    public static void execute(){
        try {
            System.out.print("Select menu item: ");
            int index = ConsoleUtil.getScanner().nextInt() - 1;
            System.out.println();
            MenuContext.getCurrentMenu().getMenuItems().get(index).getAction().execute(index);
        } catch (Exception exception){
            System.out.println(exception.getMessage() + "\n");
        }
    }
}
