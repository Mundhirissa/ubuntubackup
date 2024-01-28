package com.Invetoryitem.Invetory.Controller;

import com.Invetoryitem.Invetory.Repository.ChumbaRepository;
import com.Invetoryitem.Invetory.model.Chumba;
import com.Invetoryitem.Invetory.model.Idara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Chumba")
public class ChumbaController {
    @Autowired
    private ChumbaRepository chumbaRepository;

    @GetMapping("/all")
    public List<Chumba> getAllChumba(){
        return chumbaRepository.findAll();
    }


    @PostMapping("/save")
    public Chumba createChumba(@RequestBody Chumba chumba){
        return chumbaRepository.save(chumba);
    }

    @DeleteMapping("/delete/{room_number}")
    public String Deletechumba(@PathVariable Long room_number){
        Chumba Deletechumba =chumbaRepository.findById(room_number).get();
        chumbaRepository.delete(Deletechumba);
        return "chumba deleted: "+room_number;
    }


    @PutMapping(value = "update/{room_number}")
    public String updatedchumba(@PathVariable Long room_number,@RequestBody Chumba chumba){
        Chumba updatedchumba = chumbaRepository.findById(room_number).get();
        updatedchumba.setRoom_name(chumba.getRoom_name());
        updatedchumba.setRoom_number(chumba.getRoom_number());
        updatedchumba.setIdara(chumba.getIdara());
        chumbaRepository.save(chumba);
        return "updated...";
    }

    @GetMapping("/byid/{room_number}")
    public Optional<Chumba> getChumba(@PathVariable Long room_number){
        return chumbaRepository.findById(room_number);

    }







}
