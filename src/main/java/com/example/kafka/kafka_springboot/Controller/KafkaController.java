package com.example.kafka.kafka_springboot.Controller;

import com.example.kafka.kafka_springboot.Service.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;


@RestController
public class KafkaController {

    @Autowired
    private final Data data;

    public KafkaController(Data data) {
        this.data = data;
    }


    @GetMapping("adddata/{message}")
    public String post(@PathVariable("message") final String message) throws FileNotFoundException {
        data.getStockDataFile();
        return "all messages added";
    }
}
