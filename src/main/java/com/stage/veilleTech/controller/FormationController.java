package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.dto.FormationDto;
import com.stage.veilleTech.dto.RessourceDto;
import com.stage.veilleTech.entity.Collaborateur;
import com.stage.veilleTech.entity.Formation;
import com.stage.veilleTech.services.CollaborateurService;
import com.stage.veilleTech.services.FormationService;
import com.stage.veilleTech.services.RessourceService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formation")
public class FormationController {

    @Autowired
    private FormationService formationService;

    @Autowired
    private CollaborateurService  collaborateurService;

    @Autowired
    private RessourceService ressourceService;

    @PostMapping("/save")
    @ResponseBody
    public FormationDto save(@RequestBody FormationDto formationDto,@RequestHeader("auth-token") String token){

        FormationDto fdt = formationService.save(formationDto);
//        int idf = formationDto.getId();
//        RessourceDto ressourceDto1 = ressourceService.save(ressourceDto);

        //ressourceService.affecterRessourceAFormation(fdt.getRessources().get(0).getId(),fdt.getId());
        //Affectation
        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);
        formationService.affecterFormationACollaborateur(fdt.getId(),cb.getId());

        return fdt;

    }

//    @PostMapping("/affecterForma/{idcollab}")
//    public void affecterFormationACollaborateur( @PathVariable("idcollab") Integer idcollab,@RequestBody FormationDto formationDto){
//        formationService.save(formationDto);
//        Integer idforma=formationDto.getId();
//        formationService.affecterFormationACollaborateur(idforma,idcollab);
//    }

    @PutMapping("/affecterForma/{idforma}")
    public void affecterFormationACollaborateur(@PathVariable("idforma") Integer idforma,@RequestHeader("auth-token") String token){

    }

    @GetMapping("/find/{id}")
    public FormationDto findById(@PathVariable("id") Integer id){
        return formationService.findById(id);
    }

    @GetMapping("/")
    public List<FormationDto> findAll(){
        return formationService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable("id") Integer id){
        formationService.delete(id);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<FormationDto> getFormationByCollaborateurNom(@RequestParam(value="nom")  String nom){
//        return formationService.getFormationByCollaborateurNom(nom);
//    }

//    @RequestMapping(method = RequestMethod.GET)
    @CrossOrigin("http://localhost:4200/")
    @GetMapping("/collaborateur")
    public List<FormationDto> getFormationByCollaborateur(@RequestHeader("auth-token") String token){
        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);

        return formationService.getFormationByCollaborateurId(cb.getId());
    }


}
