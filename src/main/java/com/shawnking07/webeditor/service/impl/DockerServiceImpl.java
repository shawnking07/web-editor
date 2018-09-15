package com.shawnking07.webeditor.service.impl;

import com.shawnking07.webeditor.bean.DockerClientProperties;
import com.shawnking07.webeditor.service.DockerService;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.ContainerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shawn
 */
@Service
public class DockerServiceImpl implements DockerService {

    private final DockerClient dockerClient;

    private final DockerClientProperties dockerClientProperties;

    @Autowired
    public DockerServiceImpl(DockerClientProperties dockerClientProperties) {
        this.dockerClientProperties = dockerClientProperties;
        this.dockerClient = DefaultDockerClient.builder()
                .uri(dockerClientProperties.getUrl())
                .connectionPoolSize(dockerClientProperties.getConnectionPoolSize())
                .build();
    }

    @Override
    public List<Container> listContainers() throws DockerException, InterruptedException {
        return dockerClient.listContainers();
    }

    @Override
    public String createContainer() throws DockerException, InterruptedException {
        return dockerClient.createContainer(
                ContainerConfig.builder()
                        .image("ubuntu")
                        .tty(true)
                        .build(),
                "ubuntu_demo1"
        ).id();
    }
}
