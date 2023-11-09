package com.nui.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nui.entity.PetitionEntity;

public interface PetitionRespository extends JpaRepository<PetitionEntity, Integer> {

}
