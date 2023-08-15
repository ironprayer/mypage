package com.idea_rush.performance_data_generator;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class PerformanceDataGeneratorApplication {
    public static void main(String[] args) {

        SpringApplication.run(PerformanceDataGeneratorApplication.class, args);
    }

}
