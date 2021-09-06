package com.stage.veilleTech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)

public class Rating {

    @EmbeddedId
    private FormationCollabKey id;

    @ManyToOne
    @MapsId("collaborateurId")
    @JoinColumn(name = "collaborateur_id")
    private Collaborateur collaborateur;


    @ManyToOne
    @MapsId("formationId")
    @JoinColumn(name = "formation_id",nullable = true)
    private Formation formation;

    private float stars;

    @CreatedDate
    @Column(name="creationDate", nullable = false, updatable = false)
    private Instant dateCreation;





}
