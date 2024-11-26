package io.fokas90;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestcontainersRabbitmqBugApplication {

    public static void main(String[] args) {

        var context = SpringApplication.run(TestcontainersRabbitmqBugApplication.class, args);
        var rabbitAdmin = context.getBean(RabbitAdmin.class);
        rabbitAdmin.declareQueue();
    }
}
