package eu.grsu.stacksimulator.services.stack;

import eu.grsu.stacksimulator.model.Stack;

public interface StackService<E> {
    void printStackTrace(Stack<E> stack);
}
