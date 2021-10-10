package eu.grsu.stacksimulator.initialization.initializers.context;

import eu.grsu.stacksimulator.context.ApplicationContext;
import eu.grsu.stacksimulator.initialization.initializers.Initializer;
import eu.grsu.stacksimulator.utils.filemanager.FileManager;
import eu.grsu.stacksimulator.utils.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContextInitializer implements Initializer {

    private final FileManager fileManager;
    private final Parser parser;

    @Autowired
    public ContextInitializer(FileManager fileManager, Parser parser) {
        this.fileManager = fileManager;
        this.parser = parser;
    }

    @Override
    public void init() {
        ApplicationContext.setStringStack(parser.linesToStack(fileManager.readLines()));
    }
}
