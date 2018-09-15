package com.shawnking07.webeditor.service.impl;

import com.shawnking07.webeditor.service.FileService;
import com.shawnking07.webeditor.viewmodel.FileTreeNode;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shawn
 */
@Service
public class FileServiceImpl implements FileService {
    private static Path basePath = Paths.get(URI.create("file:/E:/filesystems-test"));

    @Override
    public void registerWatcher() throws IOException {
        // TODO: file watcher
        WatchService watcher = FileSystems.getDefault().newWatchService();
    }

    @Override
    public List<FileTreeNode> getFileTree(String dir) throws IOException {
        // TODO: config file for base path
        Path dirPath = basePath.resolve(dir);
        List<FileTreeNode> tree = new ArrayList<>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath);
        for (Path filePath : stream) {
            FileTreeNode node = new FileTreeNode();
            node.setName(filePath.getFileName().toString());
            node.setPath(basePath.relativize(filePath).toString());
            node.setHasChildren(filePath.toFile().isDirectory());
            tree.add(node);
        }
        return tree;
    }

    @Override
    public void createFolder(Long userId) throws IOException {
        Files.createDirectory(basePath.resolve(userId.toString()));
    }
}
