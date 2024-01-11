package edu.platform.application.service.impl;

import edu.platform.application.service.UploadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class UploadServiceImpl implements UploadService {

    @Override
    public List<String> uploadFile(MultipartFile[] files, String path) {
        if (files == null) {
            return List.of();
        }
        List<String> result = new ArrayList<>();

        File dest;
        String fileName;
        for (MultipartFile file : files) {
            fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
            dest = new File(path + "/" + fileName);
            try {
                file.transferTo(dest);

                result.add(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                log.error(String.format("Upload file error => %s", e.getCause().toString()));
            }
        }

        return result;
    }
}
