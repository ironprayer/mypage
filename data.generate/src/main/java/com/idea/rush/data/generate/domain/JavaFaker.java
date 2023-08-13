package com.idea.rush.data.generate.domain;

import com.github.javafaker.Faker;
import com.idea.rush.data.generate.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class JavaFaker {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Faker faker = new Faker(Locale.ENGLISH);
        File file = new File("./dummy.csv");
        BufferedWriter writer = null;

        for(var count =0 ; count < 900000; count++) {
            String title = faker.job().title();
            String content = faker.lorem().sentence(10, 20);
            String image = faker.internet().image();
            Long price = (long) (Double.parseDouble(faker.commerce().price(1000, 1000000)));
            Long bidSuccessPrice = 0L;
            Instant startTime = faker.date().between(Date.valueOf("2023-07-20"), Date.valueOf("2023-08-10")).toInstant();
            Instant endTime = startTime.plusSeconds(600);
            String auctionStatus = "END";
            String category = (Category.values())[random.nextInt(5)].toString();
            String dealStatus = DealStatus.values()[random.nextInt(2)].toString();
            Long userId = random.nextLong(100000) + 1;

            if(dealStatus.equals(DealStatus.BID_WIN.toString())){
                bidSuccessPrice = (long) (Double.parseDouble(faker.commerce().price(10000, 100000000)));
            }

            String[] words = {title, content, image, price.toString(), bidSuccessPrice.toString(), startTime.toString(), endTime.toString(), auctionStatus.toString(), category.toString(), dealStatus.toString(), userId.toString(), startTime.minusSeconds(3600).toString(), startTime.minusSeconds(3600).toString()};
            for (int i = 0; i < words.length; i++) {
                words[i] = '"' + words[i] + '"';
            }
            String line = String.join(",", words);

            System.out.println(count + "번째 데이터 생성했습니다");
            try {
                FileWriter fw = new FileWriter(file, true);
                writer = new BufferedWriter(fw);
                writer.write(line);
                writer.write("\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                writer.close();
            }
        }

    }

}
