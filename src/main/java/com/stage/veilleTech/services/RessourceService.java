package com.stage.veilleTech.services;

import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.entity.Ressource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RessourceService {



//    RessourceDto store(MultipartFile file) throws IOException;

    RessourceDto save(RessourceDto ressourceDto);

    void affecterRessourceAFormation(Integer ressourceId, Integer formaId);

    List <RessourceDto> getRessourcesByFormation_Id(Integer idf);

      void update(Integer id,Ressource ressource);

    RessourceDto getFileById(Integer id);

    List<RessourceDto> getFileList();

    void delete(Integer id);
}
