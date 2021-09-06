package com.stage.veilleTech.dto;

import com.stage.veilleTech.entity.Ressource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RessourceDto {

    private Integer id;

    private String document;

    private FormationDto formation;



    public static RessourceDto fromEntity(Ressource ressource) {
        if (ressource == null) {
            return null;
            // TODO throw an exception
        }

        return RessourceDto.builder()
                .id(ressource.getId())
                .document(ressource.getDocument())
               .formation(FormationDto.fromEntity(ressource.getFormation()))
                .build();

    }

    public static Ressource toEntity(RessourceDto ressourceDto) {
        if (ressourceDto == null) {
            return null;
            // TODO throw an exception
        }

        Ressource ressource = new Ressource();
        ressource.setId(ressourceDto.getId());
        ressource.setDocument(ressourceDto.getDocument());
        ressource.setFormation(FormationDto.toEntity(ressourceDto.getFormation()));
        return ressource;
    }




}
