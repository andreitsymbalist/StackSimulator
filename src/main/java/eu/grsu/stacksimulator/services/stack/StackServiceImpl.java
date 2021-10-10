package eu.grsu.stacksimulator.services.stack;

import eu.grsu.stacksimulator.model.Stack;
import org.springframework.stereotype.Component;

@Component
public class StackServiceImpl<String> implements StackService<String> {
    @Override
    public void printStackTrace(Stack<String> stack) {
        for (int i = 0; i < stack.size(); i++) {
            System.out.println((i + 1) + ". " + stack.elementAt(i));
        }
    }
}
