package com.stage.veilleTech.repository;

import com.stage.veilleTech.entity.Commentaire;
import com.stage.veilleTech.entity.FormationCollabKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<Commentaire, FormationCollabKey> {
}
