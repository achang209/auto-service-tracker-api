package com.example.autoservicetrackerapi.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    void store(MultipartFile file);

    String convertToFileDownloadUri(MultipartFile file);

    public Resource loadFileAsResource(String fileName);

}
