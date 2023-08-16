package com.idea_rush.performance_data_generator;

import com.idea_rush.performance_data_generator.entity.Idea;
import com.idea_rush.performance_data_generator.entity.Users;
import com.idea_rush.performance_data_generator.repository.IdeaRepository;
import com.idea_rush.performance_data_generator.repository.UserRepository;
import com.idea_rush.performance_data_generator.type.DeleteData;
import com.idea_rush.performance_data_generator.util.JwtUtils;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.Instant;
import java.util.*;

@Component
@RequiredArgsConstructor
public class DeleteDataGenerator {

    private final IdeaRepository ideaRepository;
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @PostConstruct
    public void generateDeleteData() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
//        List<Idea> ideas = ideaRepository.findThreeThousand();
//        List<DeleteData> deleteDatas = ideas.stream().map(idea -> new DeleteData(idea.getId(), jwtUtils.generateToken(idea.getUser_id()))).toList();

        List<Users> users = userRepository.findRandomLimit();
        File file = new File("/Users/ironprayer/user_token_20000.csv");
        BufferedWriter writer = null;
        Set<Long> a = new HashSet<>();

        for(var data : users) {
            String line = "\"" + jwtUtils.generateToken(data.getId()) + "\"";
            a.add(data.getId());

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

        System.out.println(a.size());
    }
}
