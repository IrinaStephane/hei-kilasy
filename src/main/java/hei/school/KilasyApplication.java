package hei.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KilasyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KilasyApplication.class, args);
    }

    /**
     * Sends an SMS. The grading code only knows this interface, so changing the SMS provider
     * only means changing the bean below.
     */
    public interface SmsSender {
        void send(String phone, String text);
    }

    /**
     * Simulated SMS provider: the SMS is written to the logs. The real provider is not chosen yet.
     */
    @Bean
    public SmsSender smsSender() {
        return (phone, text) -> System.out.println("[SMS] " + phone + " : " + text);
    }
}
