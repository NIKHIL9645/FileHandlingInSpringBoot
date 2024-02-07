package com.fileUpload.service;

import com.fileUpload.entity.Files;
import com.fileUpload.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {


    @Autowired
    private FileRepository fileRepository;
    public String storeFile(MultipartFile file) throws IOException {

        Files files = Files.builder().
                name(file.getOriginalFilename()).
                type(file.getContentType()).
                imageData(file.getBytes()).
                build();

         files = fileRepository.save(files);

            if (files.getId() != null){
                return "success";
            }
            return "Unable to upload ";
    }

    public byte[] getFile(String fileName) {

       return fileRepository.findByName(fileName).getImageData();
    }

}
