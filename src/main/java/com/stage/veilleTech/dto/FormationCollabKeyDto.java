package com.stage.veilleTech.dto;

import com.stage.veilleTech.entity.FormationCollabKey;
import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable

public class FormationCollabKeyDto implements Serializable {

    private Integer collaborateurId;

    private Integer formationId;

    public static FormationCollabKeyDto fromEntity(FormationCollabKey formationCollabKey) {
        if (formationCollabKey == null) {
            return null;
            // TODO throw an exception
        }

        return FormationCollabKeyDto.builder()
                .collaborateurId(formationCollabKey.getCollaborateurId())
                .formationId(formationCollabKey.getFormationId())
                .build();
    }

    public static FormationCollabKey toEntity(FormationCollabKeyDto formationCollabKeyDto) {
        if (formationCollabKeyDto == null) {
            return null;
            // TODO throw an exception
        }

        FormationCollabKey formationCollabKey = new FormationCollabKey();
        formationCollabKey.setCollaborateurId(formationCollabKeyDto.getCollaborateurId());
        formationCollabKey.setFormationId(formationCollabKeyDto.getFormationId());

        return formationCollabKey;
    }
}
