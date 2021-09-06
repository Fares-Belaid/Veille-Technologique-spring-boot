package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.FormationDto;

//import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.entity.Ressource;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.CollaborateurRepository;
import com.stage.veilleTech.repository.FormationRepository;
import com.stage.veilleTech.services.FormationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FormationServiceImpl implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CollaborateurRepository collaborateurRepository;


    @Override
    public FormationDto save(FormationDto formationDto) {
//      Formation savedFormation= formationRepository.save(FormationDto.toEntity(formationDto));
//
//      formationDto.getRessources().forEach(ligRes -> {
//          Ressource ressource = RessourceDto.toEntity(ligRes);
//          ressource.setFormation(savedFormation);
//          ressourceRepository.save(ressource);
//      });
//        return FormationDto.fromEntity(savedFormation);

        return FormationDto.fromEntity(
                formationRepository.save(FormationDto.toEntity(formationDto))
        );
    }




    public void affecterFormationACollaborateur(Integer formaId, Integer collabId){
        Optional<Formation> formation = formationRepository.findById(formaId);
        Collaborateur collaborateur = collaborateurRepository.getById(collabId);
    if (formation.isPresent()){
        Formation formation1 = formation.get();
        formation1.setCollaborateur(collaborateur);
        formationRepository.save(formation1);
        }
    }


//    @Override
//    public Ressource store(MultipartFile file) throws IOException {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        Ressource FileDB = new Ressource(fileName, file.getContentType(), file.getBytes());
//
//        return ressourceRepository.save(FileDB);
//    }

    @Override
    public FormationDto findById(Integer id) {
        if (id == null) {
            log.error("Formation  ID is NULL");
            return null;
        }
        return formationRepository.findById(id)
                .map(FormationDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucune formation ,'a ete trouvé avec l'id " +id, ErrorCodes.FORMATION_NOT_FOUND
                ));
    }

    @Override
    public void update(Integer id,Formation formation) {
        Formation formation1 = formationRepository.findById(id).get();
        formation1.setTitre(formation.getTitre());
        formation1.setDescription(formation.getDescription());
        formation1.setCategorie(formation.getCategorie());
        formation1.setImage(formation.getImage());
        formationRepository.save(formation1);
    }

    @Override
    public List<FormationDto> findAll() {
        return formationRepository.findAll().stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }




    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Formation  ID is NULL");
            return ;
        }
        formationRepository.deleteById(id);
    }

    @Override
    public List<FormationDto> getFormationByCollaborateurNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("nom invalid");
            return null;
        }
        return formationRepository.getFormationByCollaborateurNom(nom).stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<FormationDto> getFormationByCollaborateurId(Integer id) {
        if (id == null) {
            log.error("Formation  ID is NULL");
            return null;
        }
        return formationRepository.getFormationByCollaborateurId(id).stream()
                .map(FormationDto::fromEntity)
                .collect(Collectors.toList());
    }
}
