package eu.grsu.stacksimulator.actions.math;

import eu.grsu.stacksimulator.actions.Action;
import eu.grsu.stacksimulator.context.ApplicationContext;
import eu.grsu.stacksimulator.model.Stack;
import eu.grsu.stacksimulator.services.math.MathService;
import eu.grsu.stacksimulator.services.stack.StackService;
import eu.grsu.stacksimulator.utils.console.ConsoleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckBalanceBracketsAction implements Action {

    private final StackService<String> stackService;
    private final MathService mathService;

    @Autowired
    public CheckBalanceBracketsAction(StackService<String> stackService, MathService mathService) {
        this.stackService = stackService;
        this.mathService = mathService;
    }

    @Override
    public void execute(int index) {
        Stack<String> stack = ApplicationContext.getStringStack();

        stackService.printStackTrace(stack);
        System.out.print("Select expression: ");
        index = ConsoleUtil.getScanner().nextInt() - 1;
        System.out.println("\nExpression is valid: " +
                mathService.bracketsBalanced(stack.elementAt(index)) + "\n");
    }
}
