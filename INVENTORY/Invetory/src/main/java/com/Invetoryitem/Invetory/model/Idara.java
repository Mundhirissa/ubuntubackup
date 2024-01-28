package com.Invetoryitem.Invetory.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Idara {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idaraID;
    private String name;
}
