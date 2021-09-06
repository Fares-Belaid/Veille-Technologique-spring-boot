package com.stage.veilleTech.repository;

import com.stage.veilleTech.entity.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RessourceRepository extends JpaRepository<Ressource, Integer> {


    List <Ressource> getRessourcesByFormation_Id(Integer idf);
}
