package com.stage.veilleTech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stage.veilleTech.dto.RessourceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ressource  {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String document;

    @ManyToOne(cascade = CascadeType.ALL)
    private Formation formation;


}
