package com.example.boilerplateproj.board;

import com.example.boilerplateproj.domain.board.entity.Board;
import com.example.boilerplateproj.domain.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaAuditing
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
public class JpaTest {

    //@Autowired
    //private BoardRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void insert10() throws Exception {
        EntityManager entityManager = testEntityManager.getEntityManager();

        List<Board> posts = entityManager.createQuery("select b from Board b", Board.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
    }
}
