package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.CommentaireDto;
//import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.entity.Ressource;
import com.stage.veilleTech.services.CollaborateurService;
import com.stage.veilleTech.services.FormationService;
import com.stage.veilleTech.services.RessourceService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/ressource")
public class RessourceController {

    @Autowired
    private RessourceService ressourceService;

    @Autowired
    private FormationService formationService;

    @Autowired
    private CollaborateurService collaborateurService;
//    @PostMapping("/upload")
//    public RessourceDto uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//        return ressourceService.store(file);
//    }

//    @PostMapping("/uploadFiles")
//    public String upload(@RequestParam("files") MultipartFile[] files) throws IOException {
//        for (MultipartFile file: files){
//            ressourceService.store(file);
//        }
//        return "redirect:/";
//    }

    @PostMapping("/save")
    public RessourceDto uploadFile(@RequestBody RessourceDto ressourceDto,@RequestHeader("auth-token") String token) {

//        int idf = formationDto.getId();
//        RessourceDto ressourceDto1 = ressourceService.save(ressourceDto);

        //ressourceService.affecterRessourceAFormation(fdt.getRessources().get(0).getId(),fdt.getId());
        //Affectation
        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);


        RessourceDto newDto=  ressourceService.save(ressourceDto);
        formationService.affecterFormationACollaborateur(newDto.getFormation().getId(),cb.getId());

        return newDto;
    }

    @GetMapping("findByFormation/{idf}")
    public  List <RessourceDto> getRessourcesByFormation_Id(@PathVariable Integer idf){
        return ressourceService.getRessourcesByFormation_Id(idf);
    }

    @GetMapping("find/{id}")
    public RessourceDto getFileById(@PathVariable Integer id){
        return ressourceService.getFileById(id);
    }

    @GetMapping("/")
    public List<RessourceDto> getFileList(){
        return ressourceService.getFileList();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        ressourceService.delete(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id,@RequestBody Ressource ressource,@RequestHeader("auth-token") String token){
         ressourceService.update(id,ressource);
         formationService.update(ressource.getFormation().getId(),ressource.getFormation());

    }
}
