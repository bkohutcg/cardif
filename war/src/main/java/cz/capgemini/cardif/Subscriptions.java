package cz.capgemini.cardif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Branislav Kohut
 */
@SpringBootApplication
@ComponentScan(basePackages = {"cz.capgemini.cardif"})
class Subscriptions {
    public static void main(String[] args) {
        SpringApplication.run(Subscriptions.class, args);
    }

}
