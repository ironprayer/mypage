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

public class JavaFakerUser {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Faker faker = new Faker(Locale.ENGLISH);
        File file = new File("./dummy_user.csv");
        BufferedWriter writer = null;
        Instant now = Instant.now();


        for(var count =0 ; count < 100000; count++) {
            String account_id = faker.name().fullName();
            String password = faker.internet().password();
            String nickname = faker.name().username();

            if(nickname.contains(".")){
                nickname = nickname.split("\\.")[0];
//                nickname = nickname.length() > 16 ? nickname.substring(0, 15) : nickname;
            }

            if(account_id.contains(" ")){
                account_id = account_id.split((" "))[1];
            }


            String[] words = {account_id, password, nickname, now.toString(), now.toString()};
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
