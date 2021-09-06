package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.CommentaireDto;
import com.stage.veilleTech.dto.FormationCollabKeyDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.entity.FormationCollabKey;
import com.stage.veilleTech.services.CollaborateurService;
import com.stage.veilleTech.services.CommentaireService;
import com.stage.veilleTech.services.FormationService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private FormationService formationService;

    @PostMapping("/save/{idf}")
    @ResponseBody
    public CommentaireDto save(@RequestBody CommentaireDto commentaireDto,@PathVariable("idf") int idf,@RequestHeader("auth-token") String token){

        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);
        FormationCollabKeyDto formationCollabKey = new FormationCollabKeyDto(cb.getId(),idf);
        commentaireDto.setId(formationCollabKey);
        commentaireDto.setCollaborateur(cb);
        System.out.println(commentaireDto);
        FormationDto ff = formationService.findById(idf);
        System.out.println(ff);
        commentaireDto.setFormation(ff);
        CommentaireDto dto =commentaireService.save(commentaireDto);

        //commentaireService.affecterCommentaireAFormation(idf, cb.getId());

        return dto;

    }

    @GetMapping("/find/{id}")
    public CommentaireDto findById(@PathVariable("id") FormationCollabKey id){
        return commentaireService.findById(id);
    }

    @GetMapping("/")
    public List<CommentaireDto> findAll(){
        return commentaireService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") FormationCollabKey id){
        commentaireService.delete(id);
    }
}
