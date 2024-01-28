package com.Invetoryitem.Invetory.Controller;

import com.Invetoryitem.Invetory.Repository.VifaaRepository;
import com.Invetoryitem.Invetory.model.Idara;
import com.Invetoryitem.Invetory.model.Vifaa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Vifaa")
public class VifaaController {

    @Autowired
    private VifaaRepository vifaaRepository;


@GetMapping("/all")
    public List<Vifaa> GetallVifaa(){
    return vifaaRepository.findAll();
}

@PostMapping("/save")
    public Vifaa Createvifaa(@RequestBody Vifaa vifaa){
    return vifaaRepository.save(vifaa);
}


    @DeleteMapping("/delete/{ID}")
    public String DeleteVifaa(@PathVariable Long ID){
        Vifaa DeleteVifaa =vifaaRepository.findById(ID).get();
        vifaaRepository.delete(DeleteVifaa);
        return "items deleted: "+ID;
    }



    @PutMapping(value = "update/{ID}")
    public String updateVifaa(@PathVariable Long ID,@RequestBody Vifaa vifaa){
        Vifaa updatedVifaa = vifaaRepository.findById(ID).get();
        updatedVifaa.setChumba(vifaa.getChumba());
        updatedVifaa.setTool_name(vifaa.getTool_name());
        updatedVifaa.setIdadi(vifaa.getIdadi());
        vifaaRepository.save(vifaa);
        return "updated...";
    }


    @GetMapping("/byid/{ID}")
    public Optional<Vifaa> getVifaa(@PathVariable Long ID){
        return vifaaRepository.findById(ID);

    }




}
