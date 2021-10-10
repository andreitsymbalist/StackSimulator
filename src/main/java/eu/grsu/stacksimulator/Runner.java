package eu.grsu.stacksimulator;

// 5. Разработка класса стека, осуществляющего чтение строковых данных из файла, запись данных в стек, вывод из стека.

import eu.grsu.stacksimulator.client.UserInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
        UserInterface.run();
    }
}
