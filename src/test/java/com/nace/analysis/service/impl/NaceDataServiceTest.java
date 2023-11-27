package com.nace.analysis.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.nace.analysis.domain.NaceDataDto;
import com.nace.analysis.entity.NaceData;
import com.nace.analysis.repository.NaceDataRepository;

@SpringBootTest
class NaceDataServiceTest {

	@InjectMocks
	private NaceDataServiceImpl naceDataService;

	@Mock
	private NaceDataRepository naceDataRepository;

	@Test
	void shouldGetNaceData() {
		
		when(naceDataRepository.findAll()).thenReturn(getNaceData());
		List<NaceDataDto> naceData = naceDataService.getNaceData();
		
		assertNotNull(naceData);
		verify(naceDataRepository, times(1)).findAll();
		
	}
	
	@Test
	void shouldThrowNPEWhenNoNACEDataRetrieved() {
		
		when(naceDataRepository.findAll()).thenReturn(null);
		
		assertThrows(NullPointerException.class, () -> naceDataService.getNaceData());
				
	}

	private List<NaceData> getNaceData() {

		List<NaceData> naceDataList = new ArrayList<NaceData>();

		NaceData data = new NaceData();
		data.setOrderId("1");

		naceDataList.add(data);
		return naceDataList;
	}

}
