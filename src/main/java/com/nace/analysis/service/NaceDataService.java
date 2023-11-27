package com.nace.analysis.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nace.analysis.domain.NaceDataDto;
import com.nace.analysis.domain.NaceDataResponse;

public interface NaceDataService {

	List<NaceDataDto> uploadNaceData(MultipartFile file);

	NaceDataResponse getNaceDataWithPagination(int pageNo, int pageSize, String sortBy, String sortDir);

	List<NaceDataDto> getNaceData();
}
