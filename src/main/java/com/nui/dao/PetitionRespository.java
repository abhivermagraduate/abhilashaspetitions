package com.nui.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nui.entity.PetitionEntity;

@Repository
public interface PetitionRespository extends JpaRepository<PetitionEntity, Integer> {

	
    @Query("SELECT p FROM PetitionEntity p WHERE p.petitionTitle LIKE %:petitionTitle%")
    List<PetitionEntity> searchPeitionByTitle(@Param("petitionTitle") String petitionTitle);

	
}
