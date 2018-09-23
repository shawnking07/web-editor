package com.shawnking07.webeditor;

import com.shawnking07.webeditor.service.FileService;
import com.shawnking07.webeditor.viewmodel.FileTreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTest {
    @Autowired
    private FileService fileService;

    @Test
    public void createDir() throws IOException, InterruptedException, ExecutionException {
        fileService.createFolder(233L);
        Thread.sleep(1000);
        Future<List<FileTreeNode>> future = fileService.getFileTree(233L, "");
        if (future.isDone()) {
            Assert.assertTrue(CollectionUtils.isEmpty(future.get()));
        }
    }
}
