package com.fileUpload.controller;

import com.fileUpload.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileController {


    @Autowired
    private FileService fileService;


    @PostMapping("/upload")
    public ResponseEntity<String> storeFileIntoDb(@RequestParam("file") MultipartFile file) throws IOException {

        String response = fileService.storeFile(file);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/getFileByName/{filename}")
    public ResponseEntity<byte[]> getImage(@PathVariable String filename){
        byte[] imageData = fileService.getFile(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }

}
