package io.fokas90;

import java.util.Map;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

@Configuration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    RabbitMQContainer rabbitContainer() {

        var imageName = DockerImageName.parse("library/rabbitmq:3-management")
                .asCompatibleSubstituteFor("rabbitmq");
        return new RabbitMQContainer(imageName).withEnv(Map.of("RABBITMQ_DEFAULT_USER", "user",
                "RABBITMQ_DEFAULT_PASS", "pass", "RABBITMQ_DEFAULT_VHOST", "vhost"));
    }
}
