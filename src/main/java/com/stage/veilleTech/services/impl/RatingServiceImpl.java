package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.RatingDto;
import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.entity.FormationCollabKey;
import com.stage.veilleTech.entity.Rating;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.CollaborateurRepository;
import com.stage.veilleTech.repository.FormationRepository;
import com.stage.veilleTech.repository.RatingRepository;
import com.stage.veilleTech.services.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @Override
    public RatingDto save(RatingDto ratingDto) {

        return RatingDto.fromEntity(
                ratingRepository.save(RatingDto.toEntity(ratingDto))
        );
    }



    @Override
    public RatingDto findById(FormationCollabKey id) {

        if (id == null) {
            log.error("Rating  ID is NULL");
            return null;
        }
        return ratingRepository.findById(id)
                .map(RatingDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucun rating ,'a ete trouvé avec l'id " +id, ErrorCodes.RATING_NOT_FOUND
                ));
    }

    @Override
    public List<RatingDto> findAll() {

        return ratingRepository.findAll().stream()
                .map(RatingDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(FormationCollabKey id) {
        if (id == null) {
            log.error("Rating  ID is NULL");
            return ;
        }
        ratingRepository.deleteById(id);
    }
}
