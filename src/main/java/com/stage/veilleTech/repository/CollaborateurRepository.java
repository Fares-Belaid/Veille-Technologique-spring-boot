package com.stage.veilleTech.repository;

import com.stage.veilleTech.entity.Collaborateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

    Optional<Collaborateur> findCollaborateurByEmail(String email);

}
