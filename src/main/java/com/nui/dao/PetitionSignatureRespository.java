package com.nui.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nui.entity.PetitionSignatureEntity;

@Repository
public interface PetitionSignatureRespository extends JpaRepository<PetitionSignatureEntity, Integer> {

}
