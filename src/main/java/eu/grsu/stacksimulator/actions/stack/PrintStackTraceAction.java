package eu.grsu.stacksimulator.actions.stack;

import eu.grsu.stacksimulator.actions.Action;
import eu.grsu.stacksimulator.context.ApplicationContext;
import eu.grsu.stacksimulator.services.stack.StackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintStackTraceAction implements Action {

    private final StackService<String> stackService;

    @Autowired
    public PrintStackTraceAction(StackService<String> stackService) {
        this.stackService = stackService;
    }

    @Override
    public void execute(int index) {
        stackService.printStackTrace(ApplicationContext.getStringStack());
        System.out.println();
    }
}
