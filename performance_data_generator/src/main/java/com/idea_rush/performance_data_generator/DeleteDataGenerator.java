package com.idea_rush.performance_data_generator;

import com.idea_rush.performance_data_generator.entity.Idea;
import com.idea_rush.performance_data_generator.repository.IdeaRepository;
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
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DeleteDataGenerator {

    private final IdeaRepository ideaRepository;
    private final JwtUtils jwtUtils;

    @PostConstruct
    public void generateDeleteData() throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Idea> ideas = ideaRepository.findThreeThousand();
        List<DeleteData> deleteDatas = ideas.stream().map(idea -> new DeleteData(idea.getId(), jwtUtils.generateToken(idea.getUser_id()))).toList();

        File file = new File("./delete_performance_data.csv");
        BufferedWriter writer = null;

        for(DeleteData data : deleteDatas) {
            String line = "\"" + data.postId() + "\"," + "\"" + data.jwt() + "\"";

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
