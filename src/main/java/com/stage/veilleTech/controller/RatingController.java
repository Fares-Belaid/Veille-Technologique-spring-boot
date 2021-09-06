package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.*;
import com.stage.veilleTech.entity.FormationCollabKey;
import com.stage.veilleTech.services.CollaborateurService;
import com.stage.veilleTech.services.FormationService;
import com.stage.veilleTech.services.RatingService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private CollaborateurService collaborateurService;
    @Autowired
    private FormationService formationService;

    @PostMapping("/save/{idf}")
    @ResponseBody
    public RatingDto save(@RequestBody RatingDto ratingDto,@PathVariable("idf") int idf,@RequestHeader("auth-token") String token){

        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);
        FormationCollabKeyDto formationCollabKey = new FormationCollabKeyDto(cb.getId(),idf);
        ratingDto.setId(formationCollabKey);
        ratingDto.setCollaborateur(cb);
        FormationDto ra = formationService.findById(idf);
        ratingDto.setFormation(ra);
        RatingDto dto =ratingService.save(ratingDto);

        return dto;
    }

    @GetMapping("/find/{id}")
    public RatingDto findById(@PathVariable("id") FormationCollabKey id){
        return ratingService.findById(id);
    }

    @GetMapping("/")
    public List<RatingDto> findAll(){
        return ratingService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") FormationCollabKey id){
        ratingService.delete(id);
    }
}
