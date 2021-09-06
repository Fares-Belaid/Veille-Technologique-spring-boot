package com.stage.veilleTech.services;

import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.entity.Formation;

import java.util.List;
import java.util.Optional;

public interface FormationService {

    FormationDto save(FormationDto formationDto);

    FormationDto findById(Integer id);

    void update(Integer id,Formation formation);

    List<FormationDto> findAll();

    void delete(Integer id);

    void affecterFormationACollaborateur(Integer formaId, Integer collabId);

    List<FormationDto> getFormationByCollaborateurNom(String nom);

    List<FormationDto> getFormationByCollaborateurId(Integer id);

}
