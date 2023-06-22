package kafkapublisher.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import kafkapublisher.dtos.BookDto;
import kafkapublisher.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Autowired
    ObjectMapper objectMapper;

//    @KafkaListener(
//            topics = "welcome",
//            groupId = "group_id")
//    // Method
//    public void consume(String message) {
//        // Print statement
//        System.out.println("Topic welcome get message: = " + message);
//    }

    @KafkaListener(topics = "user",
            groupId = "group_id",
            containerFactory = "userListener")
    public void consumeUser(UserDto userDto) {
        System.out.println("Topic user: = " + userDto);
    }

    @KafkaListener(topics = "book",
            groupId = "group_id",
            containerFactory = "bookListener")
    public void consumeBook(BookDto userDto) {
        System.out.println("Topic book: = " + userDto);
    }

//    @KafkaListener(topics = "book",
//            groupId = "group_id")
//    public void consumeBook(String bookDto) {
//        ObjectReader reader = this.objectMapper.readerFor(BookDto.class);
//        try {
//            BookDto book = reader.readValue(bookDto);
//            System.out.println("Topic book val: = " + book);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Topic book val invalid format!");
//        }
//    }
}
