package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.RolesDto;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.CollaborateurRepository;
import com.stage.veilleTech.repository.RolesRepository;
import com.stage.veilleTech.services.CollaborateurService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CollaborateurServiceImpl implements CollaborateurService {

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public CollaborateurDto save(CollaborateurDto collaborateurDto) {

         CollaborateurDto savedCollab = CollaborateurDto.fromEntity(
                collaborateurRepository.save(CollaborateurDto.toEntity(collaborateurDto))
        );

         RolesDto rolesDto = RolesDto.builder()
                 .roleName("ADMIN")
                 .collaborateur(savedCollab)
                 .build();

         rolesRepository.save(RolesDto.toEntity(rolesDto));

         return savedCollab;
    }



    @Override
    public CollaborateurDto findById(Integer id) {

        if (id == null) {
            log.error("Collaborateur  ID is NULL");
            return null;
        }
        return collaborateurRepository.findById(id)
                .map(CollaborateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucun collaborateur ,'a ete trouvé avec l'id " +id, ErrorCodes.COLLABORATEUR_NOT_FOUND
                ));
    }




    @Override
    public List<CollaborateurDto> findAll() {

        return collaborateurRepository.findAll().stream()
                .map(CollaborateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CollaborateurDto findByEmail(String email) {
        return collaborateurRepository.findCollaborateurByEmail(email)
                .map(CollaborateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun collaborateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.COLLABORATEUR_NOT_FOUND)
                );
    }


    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Collaborateur ID is NULL");
            return ;
        }
        collaborateurRepository.deleteById(id);
    }
}
