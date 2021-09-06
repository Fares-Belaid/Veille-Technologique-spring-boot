package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.CommentaireDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.entity.Ressource;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.FormationRepository;
import com.stage.veilleTech.repository.RessourceRepository;
import com.stage.veilleTech.services.RessourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RessourceServiceImpl implements RessourceService {

    @Autowired
    private RessourceRepository ressourceRepository;

    @Autowired
    private FormationRepository formationRepository;
//
//    @Override
//    public RessourceDto store(MultipartFile file) throws IOException {
//
//           String docName = file.getOriginalFilename();
//
//            RessourceDto ressource = new RessourceDto(docName,file.getContentType(), file.getBytes());
//            return RessourceDto.fromEntity(ressourceRepository.save(RessourceDto.toEntity(ressource)));
//
//    }


    @Override
    public RessourceDto save(RessourceDto ressourceDto) {
        return RessourceDto.fromEntity(
                ressourceRepository.save(RessourceDto.toEntity(ressourceDto))
        );
    }

    @Override
    public RessourceDto getFileById(Integer id) {
        if (id == null) {
            log.error("Formation  ID is NULL");
            return null;
        }
        return ressourceRepository.findById(id)
                .map(RessourceDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucune formation ,'a ete trouvé avec l'id " +id, ErrorCodes.RESSOURCE_NOT_FOUND
                ));

    }

    public void affecterRessourceAFormation(Integer ressourceId, Integer formaId){
        Formation formation = formationRepository.getById(formaId);
        Optional<Ressource> ressource = ressourceRepository.findById(ressourceId);
        if (ressource.isPresent()) {
            Ressource ressource1= ressource.get();
            ressource1.setFormation(formation);
            ressourceRepository.save(ressource1);
        }
    }

    @Override
    public List<RessourceDto> getRessourcesByFormation_Id(Integer idf) {
        return ressourceRepository.getRessourcesByFormation_Id(idf).stream()
                .map(RessourceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id,Ressource ressource) {

        Ressource ressource1 = ressourceRepository.findById(id).get();
        ressource1.setDocument(ressource.getDocument());
        ressourceRepository.save(ressource1);
    }

    @Override
    public List<RessourceDto> getFileList() {
        return ressourceRepository.findAll().stream()
                .map(RessourceDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Ressource  ID is NULL");
            return ;
        }
        ressourceRepository.deleteById(id);
    }
}
