package com.example.esport_api.utill;

/**
 * @author udarasan
 * @TimeStamp 2023-05-15 11:51
 * @ProjectDetails esport_api
 */

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get("/Users/udarasan/Documents/freelance-projects/vibhath-nsbm/e-sport event plan system/frontend/app/src/assets/"+uploadDir);
        System.out.println("Upload path : "+uploadPath);
        System.out.println("Upload path : "+uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }
}