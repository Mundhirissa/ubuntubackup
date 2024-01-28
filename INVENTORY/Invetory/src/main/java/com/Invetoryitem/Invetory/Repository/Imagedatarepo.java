package com.Invetoryitem.Invetory.Repository;

import com.Invetoryitem.Invetory.model.Imagedata;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Imagedatarepo extends JpaRepository<Imagedata,Long> {


    Optional<Imagedata> findByName(String filename);
}
