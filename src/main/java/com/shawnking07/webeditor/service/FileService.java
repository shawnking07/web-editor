package com.shawnking07.webeditor.service;

import com.shawnking07.webeditor.viewmodel.FileTreeNode;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

/**
 * File Tree Service
 *
 * @author shawn
 */
public interface FileService {
    void registerWatcher() throws IOException;

    /**
     * Async get file tree with path
     *
     * @param dir folder path
     * @return File tree
     * @throws IOException NIO
     */
    List<FileTreeNode> getFileTree(@NotNull String dir) throws IOException;

    /**
     * Create folder for user with his ID
     *
     * @param userId system user id
     * @throws IOException NIO
     */
    void createFolder(@NotNull Long userId) throws IOException;
}
