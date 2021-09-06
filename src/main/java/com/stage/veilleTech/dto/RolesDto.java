package com.stage.veilleTech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stage.veilleTech.entity.Roles;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

    private Integer id;

    private String roleName;

    @JsonIgnore
    private CollaborateurDto collaborateur;

    public static RolesDto fromEntity(Roles roles) {
        if (roles == null) {
            return null;
        }
        return RolesDto.builder()
                .id(roles.getId())
                .roleName(roles.getRoleName())
                .build();
    }

    public static Roles toEntity(RolesDto dto) {
        if (dto == null) {
            return null;
        }
        Roles roles = new Roles();
        roles.setId(dto.getId());
        roles.setRoleName(dto.getRoleName());
        roles.setCollaborateur(CollaborateurDto.toEntity(dto.getCollaborateur()));
        return roles;
    }
}
