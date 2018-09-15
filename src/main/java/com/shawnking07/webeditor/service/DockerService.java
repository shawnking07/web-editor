package com.shawnking07.webeditor.service;

import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;

import java.util.List;

/**
 * @author shawn
 */
public interface DockerService {
    List<Container> listContainers() throws DockerException, InterruptedException;

    String createContainer() throws DockerException, InterruptedException;
}
