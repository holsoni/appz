package com.example.appza.repository;

import com.example.appza.model.Coach;
import lombok.var;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@DataJpaTest
class CoachRepositoryTest {
    public static final String NAME = "name1";
    @Autowired
    private CoachRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindCoachByName(){
        var expected =  Coach.builder()
                            .name("name1")
                            .year(1999)
                            .build();

        entityManager.persist(expected);
        entityManager.flush();

        var result = repository.findCoachByName(NAME);
        Assertions.assertThat(result).isEqualTo(expected);

    }

    @Test
    void testFindAllByYear(){
        var expected = Coach.builder()
                .name("name1")
                .year(1999)
                .build();


        entityManager.persist(expected);
        entityManager.flush();

        var result = repository.findByYear(1999);
        Assertions.assertThat(result).isEqualTo(expected);

    }

}