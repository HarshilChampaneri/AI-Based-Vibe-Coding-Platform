package com.harshilInfotech.vibeCoding.service.implementation;

import com.harshilInfotech.vibeCoding.dto.project.FileContentResponse;
import com.harshilInfotech.vibeCoding.dto.project.FileNode;
import com.harshilInfotech.vibeCoding.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {



    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
