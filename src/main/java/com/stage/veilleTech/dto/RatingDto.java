package com.stage.veilleTech.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stage.veilleTech.entity.Rating;
import lombok.Builder;
import lombok.Data;


@Builder
@Data

public class RatingDto {

    private FormationCollabKeyDto id;

    private float stars;

    private CollaborateurDto collaborateur;

    @JsonIgnore
    private FormationDto formation;


    public static RatingDto fromEntity(Rating rating) {
        if (rating == null) {
            return null;
            // TODO throw an exception
        }

        return RatingDto.builder()
                .id(FormationCollabKeyDto.fromEntity(rating.getId()))
                .stars(rating.getStars())
                .collaborateur(CollaborateurDto.fromEntity(rating.getCollaborateur()))
                .build();
    }

    public static Rating toEntity(RatingDto ratingDto) {
        if (ratingDto == null) {
            return null;
            // TODO throw an exception
        }

        Rating rating = new Rating();
        rating.setId(FormationCollabKeyDto.toEntity(ratingDto.getId()));
        rating.setStars(ratingDto.getStars());
        rating.setCollaborateur(CollaborateurDto.toEntity(ratingDto.getCollaborateur()));
        rating.setFormation(FormationDto.toEntity(ratingDto.getFormation()));
        return rating;
    }



}
