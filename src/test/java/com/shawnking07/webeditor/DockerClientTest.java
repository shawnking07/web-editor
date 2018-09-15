package com.shawnking07.webeditor;

import com.shawnking07.webeditor.service.DockerService;
import com.spotify.docker.client.exceptions.DockerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockerClientTest {
    @Autowired
    private DockerService dockerService;

    @Test
    public void test() throws DockerException, InterruptedException {
        System.out.println(dockerService.createContainer());
    }
}
