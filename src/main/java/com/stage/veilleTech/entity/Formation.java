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
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String titre;

    private String description;

    @CreatedDate
    @Column(name="creationDate", nullable = false, updatable = false)
    private Instant dateCreation;

    private String categorie;

    @Lob
    private String image;

    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ressource> ressources;

    @ManyToOne()
    private Collaborateur collaborateur;

    @OneToMany(mappedBy = "formation",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Commentaire> commentaires;



}
