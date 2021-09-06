package com.stage.veilleTech.controller;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.services.CollaborateurService;
import com.stage.veilleTech.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborateur")
public class CollaborateurController {

    @Autowired
    private CollaborateurService collaborateurService;

    @PostMapping("/save")
    @ResponseBody
    public CollaborateurDto save(@RequestBody CollaborateurDto collaborateurDto){
       return collaborateurService.save(collaborateurDto);
    }

    @GetMapping("/byAuth")
    public CollaborateurDto getCollaborateur(@RequestHeader("auth-token") String token){
        JwtUtil jw= new JwtUtil();
        String username = jw.extractUsername(token);
        CollaborateurDto cb= collaborateurService.findByEmail(username);
        return cb;
    }

    @GetMapping("/find/{id}")
    public CollaborateurDto findById(@PathVariable("id") Integer id){
        return collaborateurService.findById(id);
    }

    @GetMapping("/")
    public List<CollaborateurDto> findAll(){
        return collaborateurService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        collaborateurService.delete(id);
    }
}
