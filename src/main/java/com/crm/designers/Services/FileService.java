package com.crm.designers.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    public boolean saveLocalFile(MultipartFile file, String fileName) {

        String projectDirectory = System.getProperty("user.dir");
        Path filePath = Paths.get(projectDirectory, "src/main/resources/static/Invoices", fileName);
        try {
            Files.createDirectories(filePath);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
