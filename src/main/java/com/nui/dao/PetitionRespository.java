/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
package com.nui.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nui.entity.PetitionEntity;

/**
 * Purpose of this PetitionRespository interface is to insert,fetch and search petition in database through JPA methods.
 */
@Repository
public interface PetitionRespository extends JpaRepository<PetitionEntity, Integer> {

	
	/**
	 * Purpose of this method is to search petition by petition title.
	 * @param petitionTitle
	 * @return list of Petition entity
	 */
    @Query("SELECT p FROM PetitionEntity p WHERE p.petitionTitle LIKE %:petitionTitle%")
    List<PetitionEntity> searchPeitionByTitle(@Param("petitionTitle") String petitionTitle);

	
}
