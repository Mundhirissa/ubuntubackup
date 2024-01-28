package com.Invetoryitem.Invetory.Repository;

import com.Invetoryitem.Invetory.model.Vifaa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VifaaRepository extends JpaRepository<Vifaa,Long> {
}
