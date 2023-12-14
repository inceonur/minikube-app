package com.turkcell.devops.minikubeapp.controller;


import com.turkcell.devops.minikubeapp.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ProducerController {

  //  private static KafkaConsumer<String, String> consumer;
   // @Value("${spring.kafka.consumer.topic}")
   // private String topicName;
    @Autowired
    private ProducerService service;
    @RequestMapping(value="/greet", method= RequestMethod.GET)
    public String greet() {
        return "Welcome Java App v13!";
    }
    @GetMapping("/message/{message}")
    public String message(@PathVariable String message) {
        service.sendMessage(message);
        return "Message sent!";
    }
    @GetMapping("/load")
    public String loader() {
        final int NUM_TESTS = 1000;
        long start = System.nanoTime();
        for (int i = 0; i < NUM_TESTS; i++) {
            spin(500);
        }
        return("Took " + (System.nanoTime()-start)/1000000 +"ms (expected " + (NUM_TESTS*500) + ")");
    }
    private static void spin(int milliseconds) {
        long sleepTime = milliseconds*1000000L;
        long startTime = System.nanoTime();
        while ((System.nanoTime() - startTime) < sleepTime) {}
    }

/*
    @RequestMapping(value="/consume", method= RequestMethod.GET)
    public List<String> consumeFromBeginning() {

        List<String> messages = new ArrayList<>();

        String message = null;

        setup();

        consumer.subscribe(Arrays.asList(topicName));

        ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(10));

        for (ConsumerRecord<String, String> record : records) {

            messages.add(record.value());
        }

        return messages;

    }
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    public  void setup() {

        Properties consumerProperties = new Properties();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID()
                .toString());

        consumer = new KafkaConsumer<>(consumerProperties);
    }


*/



}