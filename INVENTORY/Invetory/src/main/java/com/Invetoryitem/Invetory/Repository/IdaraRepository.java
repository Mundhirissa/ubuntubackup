package com.Invetoryitem.Invetory.Repository;


import com.Invetoryitem.Invetory.model.Idara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IdaraRepository extends JpaRepository<Idara,Long> {
    Optional<Idara> findByName(String name);
}
