package com.Invetoryitem.Invetory.Controller;

import com.Invetoryitem.Invetory.serices.Imageservicse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class Imagecntroller {

    @Autowired
    private Imageservicse imageservicse;

    @GetMapping("/filesystem/{filename}")
    public ResponseEntity<?> downloadfile(@PathVariable String filename) throws IOException {
        byte[] getimage =imageservicse.downloadfile(filename);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(getimage);
    }


    @PostMapping("/filesystem")
    public ResponseEntity<?> uploadfile(@RequestParam("image")MultipartFile file) throws IOException {
         String uploadimage =imageservicse.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadimage);
    }







}
