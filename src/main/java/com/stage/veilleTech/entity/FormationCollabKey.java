package com.stage.veilleTech.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable

public class FormationCollabKey implements Serializable {

    @Column(name = "collaborateur_id")
    private Integer collaborateurId;

    @Column(name = "formation_id")
    private Integer formationId;

}
