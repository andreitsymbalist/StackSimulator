package eu.grsu.stacksimulator.services.math;

public interface MathService {
    boolean bracketsBalanced(String expression);

    double solveExpressions(String expression);
}
