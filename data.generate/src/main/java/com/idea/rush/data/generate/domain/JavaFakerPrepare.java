package com.idea.rush.data.generate.domain;

import com.github.javafaker.Faker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.Locale;
import java.util.Random;

public class JavaFakerPrepare {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Faker faker = new Faker(Locale.ENGLISH);
        File file = new File("/Users/ironprayer/dummy_prepare_400000.csv");
        BufferedWriter writer = null;

        for(var count =0 ; count < 400000; count++) {
            String title = faker.job().title();
            String content = faker.lorem().sentence(10, 20);
            String image = faker.internet().image();
            Long price = (long) (Double.parseDouble(faker.commerce().price(1000, 1000000)));
            Long bidSuccessPrice = 0L;
            Instant startTime = faker.date().between(Date.valueOf("2023-08-25"), Date.valueOf("2023-09-30")).toInstant();
            Instant endTime = startTime.plusSeconds(600);
            String auctionStatus = "PREPARE";
            String category = (Category.values())[random.nextInt(5)].toString();
            String dealStatus = DealStatus.NO_ACTION.toString();
            Long userId = random.nextLong(100000) + 1;

//            if(dealStatus.equals(DealStatus.BID_WIN.toString())){
//                bidSuccessPrice = (long) (Double.parseDouble(faker.commerce().price(10000, 100000000)));
//            }

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
