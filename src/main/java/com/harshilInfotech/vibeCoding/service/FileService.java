package com.harshilInfotech.vibeCoding.service;

import com.harshilInfotech.vibeCoding.dto.project.FileContentResponse;
import com.harshilInfotech.vibeCoding.dto.project.FileNode;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface FileService {

    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);

}
