package com.idea_rush.performance_data_generator.repository;

import com.idea_rush.performance_data_generator.entity.Idea;
import com.idea_rush.performance_data_generator.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("select i from Users i order by random() limit 20000 ")
    List<Users> findRandomLimit();
}
