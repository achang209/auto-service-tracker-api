package com.example.autoservicetrackerapi.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface FileStorageService {

    void store(MultipartFile file);

    String convertToFileDownloadUri(MultipartFile file);

    public Resource loadFileAsResource(String fileName);

}
