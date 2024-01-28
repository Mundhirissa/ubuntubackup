package com.Invetoryitem.Invetory.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vifaa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String tool_name;
    private Long Idadi;

    @ManyToOne
    @JoinColumn(name = "room_number")
    private Chumba chumba;

}
