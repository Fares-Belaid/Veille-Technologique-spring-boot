package com.stage.veilleTech.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Collaborateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nom;

    private String prenom;

    private String email;

    private String password;

    @OneToMany(mappedBy = "collaborateur", cascade = CascadeType.ALL)
    private List<Formation> formations;

    @OneToMany(mappedBy = "collaborateur")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "collaborateur")
    private List<Commentaire> commentaires;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "collaborateur")
    @JsonIgnore
    private List<Roles> roles;



}
