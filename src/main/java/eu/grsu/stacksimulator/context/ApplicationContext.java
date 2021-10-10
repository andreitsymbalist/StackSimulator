package eu.grsu.stacksimulator.context;

import eu.grsu.stacksimulator.model.Stack;
import lombok.Getter;
import lombok.Setter;

public class ApplicationContext {
    @Getter
    @Setter
    private static Stack<String> stringStack;
}
