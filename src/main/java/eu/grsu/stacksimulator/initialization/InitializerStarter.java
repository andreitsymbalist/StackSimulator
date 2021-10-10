package eu.grsu.stacksimulator.initialization;

import eu.grsu.stacksimulator.initialization.initializers.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class InitializerStarter {

    private final List<Initializer> initializers;

    @Autowired
    public InitializerStarter(List<Initializer> initializers) {
        this.initializers = initializers;
    }

    @PostConstruct
    private void start() {
        initializers.forEach(Initializer::init);
    }
}
