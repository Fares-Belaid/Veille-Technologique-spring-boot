package com.stage.veilleTech.services;

import com.stage.veilleTech.dto.CommentaireDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.entity.FormationCollabKey;

import java.util.List;

public interface CommentaireService {

    CommentaireDto save(CommentaireDto commentaireDto);

    CommentaireDto findById(FormationCollabKey id);

     void affecterCommentaireAFormation(int id, int idCollab);

    List<CommentaireDto> findAll();

    void delete(FormationCollabKey id);
}
