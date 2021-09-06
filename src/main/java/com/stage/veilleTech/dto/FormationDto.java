package com.stage.veilleTech.dto;

import com.stage.veilleTech.entity.*;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data

public class FormationDto {

    private Integer id;

    private String titre;

    private String description;

    private String categorie;

    private List<RessourceDto> ressources;

    private String image;

    private CollaborateurDto collaborateur;

    private List<RatingDto> ratings;

    private List<CommentaireDto> commentaires;

    public static FormationDto fromEntity(Formation formation) {
        if (formation == null) {
            return null;
            // TODO throw an exception
        }

        return FormationDto.builder()
                .id(formation.getId())
                .titre(formation.getTitre())
                .description(formation.getDescription())
                .categorie(formation.getCategorie())
                .collaborateur(CollaborateurDto.fromEntity(formation.getCollaborateur()))
                .image(formation.getImage())
//                .ressources(
//                        formation.getRessources() != null ?
//                                formation.getRessources().stream()
//                                    .map(RessourceDto::fromEntity)
//                                    .collect(Collectors.toList()) : null
//                )
                .ratings(
                        formation.getRatings() != null ?
                                formation.getRatings().stream()
                                    .map(RatingDto::fromEntity)
                                    .collect(Collectors.toList()) : null
                )
                .commentaires(
                        formation.getCommentaires() != null ?
                                formation.getCommentaires().stream()
                                    .map(CommentaireDto::fromEntity)
                                    .collect(Collectors.toList()) : null
                )
                .build();

    }

    public static Formation toEntity(FormationDto formationDto) {
        if (formationDto == null) {
            return null;
            // TODO throw an exception
        }

        Formation formation = new Formation();
        formation.setId(formationDto.getId());
        formation.setTitre(formationDto.getTitre());
        formation.setDescription(formationDto.getDescription());
        formation.setCategorie(formationDto.getCategorie());
        formation.setImage(formationDto.getImage());
        return formation;
    }

}
