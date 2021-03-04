package com.example.kafka.kafka_springboot.Service;

import com.example.kafka.kafka_springboot.Producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Service
public class Data {

    @Autowired
    private final Producer producer;

    @Autowired
    public Data(Producer producer)
    {
        this.producer = producer;
    }

    public void getStockDataFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("stock data - Stock Data.csv"));
        while (sc.hasNext())  //returns a boolean value
        {
            this.producer.sendMessage(sc.nextLine());
        }
        sc.close();  //closes the scanner
    }
}
