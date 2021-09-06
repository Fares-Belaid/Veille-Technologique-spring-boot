package com.stage.veilleTech.repository;

import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface FormationRepository extends JpaRepository<Formation, Integer> {

    List<Formation> getFormationByCollaborateurNom(String nom);
    List<Formation> getFormationByCollaborateurId(Integer id);


}
