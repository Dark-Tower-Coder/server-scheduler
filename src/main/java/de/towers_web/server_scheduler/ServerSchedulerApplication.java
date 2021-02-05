package de.towers_web.server_scheduler;

import de.towers_web.server_scheduler.services.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSchedulerApplication {

    public static void main(String[] args) {
        Service service = new Service();
        SpringApplication.run(ServerSchedulerApplication.class, args);

    }

}
