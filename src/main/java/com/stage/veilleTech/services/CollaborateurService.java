package com.stage.veilleTech.services;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.entity.Collaborateur;

import java.util.List;

public interface CollaborateurService {

    CollaborateurDto save(CollaborateurDto collaborateurDto);

    CollaborateurDto findById(Integer id);

    List<CollaborateurDto> findAll();

    CollaborateurDto findByEmail(String email);

    void delete(Integer id);
}
