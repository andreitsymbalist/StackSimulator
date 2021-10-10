package eu.grsu.stacksimulator.utils.parser;

import eu.grsu.stacksimulator.model.Stack;

import java.util.List;

public interface Parser {
    Stack<String> linesToStack(List<String> lines);
}
