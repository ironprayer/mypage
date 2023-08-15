package com.idea_rush.performance_data_generator.repository;

import com.idea_rush.performance_data_generator.entity.Idea;
import com.idea_rush.performance_data_generator.type.DeleteData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdeaRepository extends JpaRepository<Idea, Long> {


    @Query("select i from Idea i order by random() limit 3000")
    List<Idea> findThreeThousand();
}
