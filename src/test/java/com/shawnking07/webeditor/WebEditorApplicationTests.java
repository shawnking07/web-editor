package com.shawnking07.webeditor;

import com.shawnking07.webeditor.domain.User;
import com.shawnking07.webeditor.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebEditorApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("2233");

        userRepository.save(user);
    }

    @Test
    public void delete() {
        userRepository.deleteById(1L);
    }

}
