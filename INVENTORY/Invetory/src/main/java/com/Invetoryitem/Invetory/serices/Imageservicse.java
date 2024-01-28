package com.Invetoryitem.Invetory.serices;


import com.Invetoryitem.Invetory.Repository.Imagedatarepo;
import com.Invetoryitem.Invetory.model.Imagedata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service

public class Imageservicse {

    private final String FOLDER_PATH = "C:\\Users\\hp\\Desktop\\IMAGEFILEPATH\\";
    @Autowired
    private Imagedatarepo imagedatarepo;



    public String uploadImage(MultipartFile file)throws IOException{
        String filePath = FOLDER_PATH+file.getOriginalFilename();

        Imagedata filedata =imagedatarepo.save(Imagedata.builder()
                .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filepath(filePath).build());

        file.transferTo(new File(filePath));

        if (filedata != null){
            return "file uploaded succesfull : "+filePath;
        }
        return null;
    }



    public byte[] downloadfile(String filename) throws IOException {
        Optional<Imagedata> filedata = imagedatarepo.findByName(filename);
        String filepath =filedata.get().getFilepath();
        byte[] images = Files.readAllBytes(new File(filepath).toPath());
        return images;

    }


}
