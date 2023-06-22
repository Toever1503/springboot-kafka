package kafkapublisher;

import kafkapublisher.dtos.BookDto;
import kafkapublisher.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherApplication.class, args);
    }


    // Autowiring Kafka Template
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    Logger logger = LoggerFactory.getLogger(this.getClass());


    // Publish messages using the GetMapping
//    @GetMapping("/publish")
//    public void publishMessage(@RequestParam("message") final String message,
//                               @RequestParam("topic") final String topic) {
//        logger.info("Publishing message: {} to topic: {}", message, topic);
//        // Sending the message
//        kafkaTemplate.send(topic, message);
//    }

    @GetMapping("/publish-user")
    public void publishUser(@RequestParam String name) {
        logger.info("Publishing user: {} to topic: {}");
        // Sending the message
        kafkaTemplate.send("user", new UserDto(1l, name));
    }


    @GetMapping("/publish-book")
    public void publishBook(@RequestParam String title) {
        logger.info("Publishing user: {} to topic: {}");
        // Sending the message
        kafkaTemplate.send("book", new BookDto(1l, title));
    }


}
