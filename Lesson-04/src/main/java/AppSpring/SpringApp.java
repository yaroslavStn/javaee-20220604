package AppSpring;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringApp {
    private static final Logger log = Logger.getLogger(SpringApp.class.getName());

    public static void main(String[] args) {
        log.info("Start main...");
        SpringApplication.run(SpringApp.class, args);
        log.info("Finish main...");
    }

    @Bean
    public ApplicationRunner runner(ConsoleRun run) {
        return (args) -> run.run();
    }
}
