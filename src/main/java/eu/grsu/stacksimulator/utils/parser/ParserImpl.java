package eu.grsu.stacksimulator.utils.parser;

import eu.grsu.stacksimulator.model.Stack;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParserImpl implements Parser {
    @Override
    public Stack<String> linesToStack(List<String> lines) {
        Stack<String> stringStack = new Stack<>();
        lines.forEach(stringStack::push);
        return stringStack;
    }
}
