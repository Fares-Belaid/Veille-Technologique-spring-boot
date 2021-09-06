package com.stage.veilleTech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stage.veilleTech.entity.Collaborateur;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class CollaborateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    private List<RolesDto> roles;

    @JsonIgnore
    private List<FormationDto> formations;

    @JsonIgnore
    private RatingDto rating;

    @JsonIgnore
    private List<CommentaireDto> commentaires;

    public static CollaborateurDto fromEntity(Collaborateur collaborateur) {
        if (collaborateur == null) {
            return null;
            // TODO throw an exception
        }

        return CollaborateurDto.builder()
                .id(collaborateur.getId())
                .nom(collaborateur.getNom())
                .prenom(collaborateur.getPrenom())
                .email(collaborateur.getEmail())
                .password(collaborateur.getPassword())
                .roles(
                        collaborateur.getRoles() != null ?
                                collaborateur.getRoles().stream()
                                .map(RolesDto::fromEntity)
                                .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Collaborateur toEntity(CollaborateurDto collaborateurDto) {
        if (collaborateurDto == null) {
            return null;
            // TODO throw an exception
        }

        Collaborateur collaborateur = new Collaborateur();
        collaborateur.setId(collaborateurDto.getId());
        collaborateur.setNom(collaborateurDto.getNom());
        collaborateur.setPrenom(collaborateurDto.getPrenom());
        collaborateur.setEmail(collaborateurDto.getEmail());
        collaborateur.setPassword(collaborateurDto.getPassword());

        return collaborateur;
    }
}
