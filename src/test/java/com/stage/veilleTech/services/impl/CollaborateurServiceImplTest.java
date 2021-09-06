package com.stage.veilleTech.services.impl;

import com.stage.veilleTech.dto.CollaborateurDto;
import com.stage.veilleTech.services.CollaborateurService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollaborateurServiceImplTest {

    @Autowired
    private CollaborateurService service;

    @Test
    public void shouldSaveCollaborateurWithSuccess(){
        CollaborateurDto expectedCollab = CollaborateurDto.builder()
                .nom("collab test")
                .prenom("collab prenom test")
                .email(("email test"))
                .build();

       CollaborateurDto savedCollab= service.save(expectedCollab);
        assertNotNull(savedCollab);
        assertNotNull(savedCollab.getId());
        Assertions.assertEquals(expectedCollab.getNom(), savedCollab.getNom());
        Assertions.assertEquals(expectedCollab.getPrenom(), savedCollab.getPrenom());
        Assertions.assertEquals(expectedCollab.getEmail(), savedCollab.getEmail());

    }

    @Test
    public void shouldUpdateCollaborateurWithSuccess(){
        CollaborateurDto expectedCollab = CollaborateurDto.builder()
                .nom("collab test")
                .prenom("collab prenom test")
                .email(("email test"))
                .build();

        CollaborateurDto savedCollab= service.save(expectedCollab);

        CollaborateurDto collabToUpdate = savedCollab;

        collabToUpdate.setNom("collab update");

        savedCollab = service.save(collabToUpdate);

        assertNotNull(collabToUpdate);
        assertNotNull(collabToUpdate.getId());
        Assertions.assertEquals(collabToUpdate.getNom(), savedCollab.getNom());
        Assertions.assertEquals(collabToUpdate.getPrenom(), savedCollab.getPrenom());
        Assertions.assertEquals(collabToUpdate.getEmail(), savedCollab.getEmail());

    }


    
}