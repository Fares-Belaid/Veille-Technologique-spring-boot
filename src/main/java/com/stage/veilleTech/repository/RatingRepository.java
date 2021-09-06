package com.stage.veilleTech.repository;

import com.stage.veilleTech.entity.FormationCollabKey;
import com.stage.veilleTech.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, FormationCollabKey> {

}
