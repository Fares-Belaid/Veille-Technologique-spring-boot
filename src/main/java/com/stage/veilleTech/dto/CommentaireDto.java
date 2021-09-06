package com.stage.veilleTech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stage.veilleTech.entity.Commentaire;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class CommentaireDto {

    private FormationCollabKeyDto id;

    private String commentaire;

    private CollaborateurDto collaborateur;

    @JsonIgnore
    private FormationDto formation;




    public static CommentaireDto fromEntity(Commentaire commentaire) {
        if (commentaire == null) {
            return null;
            // TODO throw an exception
        }

        return CommentaireDto.builder()
                .id(FormationCollabKeyDto.fromEntity(commentaire.getId()))
                .commentaire(commentaire.getCommentaire())
                .collaborateur(CollaborateurDto.fromEntity(commentaire.getCollaborateur()))
                .build();
    }

    public static Commentaire toEntity(CommentaireDto commentaireDto) {
        if (commentaireDto == null) {
            return null;
            // TODO throw an exception
        }

        Commentaire commentaire = new Commentaire();
        commentaire.setId(FormationCollabKeyDto.toEntity(commentaireDto.getId()));
        commentaire.setCommentaire(commentaireDto.getCommentaire());
        commentaire.setCollaborateur(CollaborateurDto.toEntity(commentaireDto.getCollaborateur()));
        commentaire.setFormation(FormationDto.toEntity(commentaireDto.getFormation()));
        return commentaire;
    }

}
