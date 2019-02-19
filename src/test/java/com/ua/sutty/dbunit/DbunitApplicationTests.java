package com.ua.sutty.dbunit;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.ua.sutty.dbunit.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.io.IOException;

@RunWith(SpringRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DatabaseSetup(value = "classpath:dataset.xml")
@SpringBootTest(classes = DbunitApplication.class)
public class DbunitApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @ExpectedDatabase("classpath:dataset.xml")
    public void contextLoads() throws IOException {
        System.out.println(userRepository.findAll());
    }

}
