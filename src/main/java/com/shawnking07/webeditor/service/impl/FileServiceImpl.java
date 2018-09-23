package com.shawnking07.webeditor.service.impl;

import com.shawnking07.webeditor.bean.FileProperties;
import com.shawnking07.webeditor.service.FileService;
import com.shawnking07.webeditor.viewmodel.FileTreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author shawn
 */
@Service
public class FileServiceImpl implements FileService {
    private Path basePath;

    @Autowired
    public FileServiceImpl(FileProperties fileProperties) {
        basePath = Paths.get(URI.create(fileProperties.getBasePath()));
    }

    @Override
    public void registerWatcher() throws IOException {
        // TODO: file watcher
        WatchService watcher = FileSystems.getDefault().newWatchService();
    }

    @Async
    @Override
    public Future<List<FileTreeNode>> getFileTree(Long userId, String dir) throws IOException {
        Path dirPath = basePath.resolve(userId.toString()).resolve(dir);
        List<FileTreeNode> tree = new ArrayList<>();
        DirectoryStream<Path> stream = Files.newDirectoryStream(dirPath);
        for (Path filePath : stream) {
            FileTreeNode node = new FileTreeNode();
            node.setName(filePath.getFileName().toString());
            node.setPath(basePath.relativize(filePath).toString());
            node.setHasChildren(filePath.toFile().isDirectory());
            tree.add(node);
        }
        return new AsyncResult<>(tree);
    }

    @Async
    @Override
    public void createFolder(Long userId) throws IOException {
        Files.createDirectory(basePath.resolve(userId.toString()));
    }
}
