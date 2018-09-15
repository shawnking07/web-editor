package com.shawnking07.webeditor.viewmodel;

import lombok.Data;

/**
 * @author shawn
 */
@Data
public class FileTreeNode {
    private String name;
    private String path;
    private Boolean hasChildren;
}
