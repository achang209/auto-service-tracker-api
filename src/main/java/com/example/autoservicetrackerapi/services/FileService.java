package com.example.autoservicetrackerapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public void uploadFile(MultipartFile file) throws IOException {
        String fileName = getFileName(file);
        Path copyLocation = Paths.get(uploadDir + File.separator + fileName).toAbsolutePath();
        Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
    }

    public String getFileDownloadUri(MultipartFile file) {
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
                .path(getFileName(file)).toUriString();
        return fileDownloadUri;
    }

    public String getFileName(MultipartFile file) {
        return StringUtils.cleanPath(file.getOriginalFilename());
    }
}
