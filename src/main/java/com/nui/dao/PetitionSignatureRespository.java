/**
 * @author Abhilasha Verma
 * Email : A.Verma7@nuigalway.ie 
 * Student Number : 22102028
 */
package com.nui.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nui.entity.PetitionSignatureEntity;

/**
 * Purpose of this PetitionSignatureRespository interface is to  insert and fetch PetitionSignature in database through JPA methods.
 *  
 */
@Repository
public interface PetitionSignatureRespository extends JpaRepository<PetitionSignatureEntity, Integer> {

}
