//package com.stage.veilleTech.services.strategy;
//
//import com.flickr4java.flickr.FlickrException;
//import com.stage.veilleTech.dto.FormationDto;
//import com.stage.veilleTech.entity.Formation;
//import com.stage.veilleTech.exception.ErrorCodes;
//import com.stage.veilleTech.exception.InvalidOperationException;
//import com.stage.veilleTech.services.FlickrService;
//import com.stage.veilleTech.services.FormationService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//
//
//import java.io.InputStream;
//
//@Service("formationStrategy")
//@Slf4j
//public class SaveFormationPhoto implements Strategy<FormationDto> {
//
//    private FlickrService flickrService;
//    private FormationService formationService;
//
//    @Autowired
//    public SaveFormationPhoto(FlickrService flickrService, FormationService formationService) {
//        this.flickrService = flickrService;
//        this.formationService = formationService;
//    }
//
//    @Override
//    public FormationDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
//        FormationDto formation = formationService.findById(id);
//        String urlPhoto =   flickrService.savePhoto(photo,titre);
//        if (!StringUtils.hasLength(urlPhoto)){
//            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de formation", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
//        }
//
//        formation.setPhoto(urlPhoto);
//        return formationService.save(formation);
//    }
//}
