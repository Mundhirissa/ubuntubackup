package com.Invetoryitem.Invetory.Controller;


import com.Invetoryitem.Invetory.Repository.IdaraRepository;
import com.Invetoryitem.Invetory.model.Idara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/v1")
public class IdaraController {
    @Autowired
    private IdaraRepository idaraRepository;



    @GetMapping("/Idara")
    public List<Idara> getallIdara(){
        return idaraRepository.findAll();
    }


    @PostMapping("/Idara")
    public ResponseEntity<?> createIdara(@RequestBody Idara idara) {
        try {
            // Check for empty space
            if (idara.getName().trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty or contain only spaces");
            }

            // Check if the name already exists in the database
            if (idaraRepository.findByName(idara.getName()).isPresent()) {
                throw new DataIntegrityViolationException("Idara with the given name already exists");
            }

            // Save the Idara if all checks pass
            Idara savedIdara = idaraRepository.save(idara);
            return new ResponseEntity<>(savedIdara, HttpStatus.CREATED);
        } catch (IllegalArgumentException | DataIntegrityViolationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







    @DeleteMapping("/Idara/{idaraID}")
public String DeleteIdara(@PathVariable Long idaraID){
        Idara DeleteIdara =idaraRepository.findById(idaraID).get();
        idaraRepository.delete(DeleteIdara);
        return "idara deleted: "+idaraID;
    }



    @PutMapping(value = "/Idara/{idaraID}")
    public String updateIdara(@PathVariable Long idaraID,@RequestBody Idara idara){
        Idara updatedIdara = idaraRepository.findById(idaraID).get();
        updatedIdara.setName(idara.getName());
        idaraRepository.save(updatedIdara);
        return "updated...";
    }



//    @PutMapping(value = "update/{voterId}")
//    public String updateVoter(@PathVariable Long voterId,@RequestBody Voter voter){
//        Voter updatedVoter = voterRepository.findById(voterId).get();
//        updatedVoter.setFirstName(voter.getFirstName());
//        updatedVoter.setLastName(voter.getLastName());
//        updatedVoter.setEmail(voter.getEmail());
//        updatedVoter.setAddress(voter.getAddress());
//        updatedVoter.setPassword(voter.getPassword());
//        voterRepository.save(updatedVoter);
//        return "updated...";
//    }

@GetMapping("/Idara/{idaraID}")
    public Optional<Idara> getIdara(@PathVariable Long idaraID){
        return idaraRepository.findById(idaraID);

}



}
