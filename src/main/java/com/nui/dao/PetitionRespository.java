package com.nui.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.nui.entity.PetitionEntity;

@Repository
public interface PetitionRespository extends JpaRepository<PetitionEntity, Integer> {

}
