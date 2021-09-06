package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.CommentaireDto;
import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.entity.Commentaire;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.entity.FormationCollabKey;
import com.stage.veilleTech.exception.EntityNotFoundException;
import com.stage.veilleTech.exception.ErrorCodes;
import com.stage.veilleTech.repository.CollaborateurRepository;
import com.stage.veilleTech.repository.CommentaireRepository;
import com.stage.veilleTech.repository.FormationRepository;
import com.stage.veilleTech.services.CommentaireService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentaireServiceImpl implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CollaborateurRepository collaborateurRepository;

    @Override
    public CommentaireDto save(CommentaireDto commentaireDto) {
        return CommentaireDto.fromEntity(
                commentaireRepository.save(CommentaireDto.toEntity(commentaireDto))
        );
    }

    @Override
    public CommentaireDto findById(FormationCollabKey id) {

        if (id == null) {
            log.error("Commentaire  ID is NULL");
            return null;
        }
        return commentaireRepository.findById(id)
                .map(CommentaireDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "aucun commentaire ,'a ete trouvé avec l'id " +id, ErrorCodes.COMMENTAIRE_NOT_FOUND
                ));
    }


    public void affecterCommentaireAFormation(int id,int idCollab){
        Optional<Formation> formation = formationRepository.findById(id);

        Collaborateur collaborateur = collaborateurRepository.getById(idCollab);
        FormationCollabKey fck = new FormationCollabKey(formation.get().getId(),collaborateur.getId());
        Optional<Commentaire> commentaire = commentaireRepository.findById(fck);
        if (commentaire.isPresent()){
            Commentaire commentaire1 = commentaire.get();
            commentaire1.setFormation(formation.get());
            commentaire1.setCollaborateur(collaborateur);

            commentaireRepository.save(commentaire1);
        }
    }


    @Override
    public List<CommentaireDto> findAll() {

        return commentaireRepository.findAll().stream()
                .map(CommentaireDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(FormationCollabKey id) {
        if (id == null) {
            log.error("commentaire  ID is NULL");
            return ;
        }
        commentaireRepository.deleteById(id);
    }
}
