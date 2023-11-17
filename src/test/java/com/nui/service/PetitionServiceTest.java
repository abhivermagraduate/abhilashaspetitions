package com.nui.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nui.dao.PetitionRespository;
import com.nui.dao.PetitionSignatureRespository;
import com.nui.entity.PetitionEntity;
import com.nui.model.Petition;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class PetitionServiceTest {

	@Mock
	private PetitionRespository petitionRespository;

	@Mock
	private PetitionSignatureRespository petitionSignatureRespository;

	@InjectMocks
	private PetitionService petitionService;

	@Test
	public void getPetitions_whenGetAllPetitions_thenReturnPetitionList() {

		PetitionEntity mockPetitionEntity = mock(PetitionEntity.class, RETURNS_DEEP_STUBS);
		List<PetitionEntity> mockPetitionEntities = new ArrayList<PetitionEntity>();
		mockPetitionEntities.add(mockPetitionEntity);
		given(petitionRespository.findAll()).willReturn(mockPetitionEntities);
		List<Petition> petitions = petitionService.getPetitions();
		assertNotNull(petitions);
	}

}
