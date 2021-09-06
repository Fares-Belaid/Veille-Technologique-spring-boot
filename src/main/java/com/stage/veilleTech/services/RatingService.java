package com.stage.veilleTech.services;

import com.stage.veilleTech.dto.RatingDto;
import com.stage.veilleTech.entity.FormationCollabKey;

import java.util.List;

public interface RatingService {

    RatingDto save(RatingDto ratingDto);


    RatingDto findById(FormationCollabKey id);

    List<RatingDto> findAll();

    void delete(FormationCollabKey id);
}
