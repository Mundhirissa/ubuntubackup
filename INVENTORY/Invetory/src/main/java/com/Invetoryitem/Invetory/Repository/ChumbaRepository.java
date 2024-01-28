package com.Invetoryitem.Invetory.Repository;

import com.Invetoryitem.Invetory.model.Chumba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChumbaRepository extends JpaRepository<Chumba,Long> {
}
