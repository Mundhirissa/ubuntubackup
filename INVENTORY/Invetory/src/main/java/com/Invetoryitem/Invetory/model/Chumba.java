package com.Invetoryitem.Invetory.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Chumba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long room_number;
    private String room_name;

    @ManyToOne
    @JoinColumn(name = "idaraID")
    private Idara idara;


}
