package com.nace.analysis.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nace.analysis.domain.NaceDataDto;
import com.nace.analysis.domain.NaceDataResponse;
import com.nace.analysis.entity.NaceData;
import com.nace.analysis.helper.NaceDataExcelHelper;
import com.nace.analysis.repository.NaceDataRepository;
import com.nace.analysis.service.NaceDataService;

@Service
public class NaceDataServiceImpl implements NaceDataService {

	private NaceDataRepository dataRepository;

	public NaceDataServiceImpl(NaceDataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}

	@Override
	public List<NaceDataDto> uploadNaceData(MultipartFile file) {
		List<NaceDataDto> response = new ArrayList<>();
		try {
			response = NaceDataExcelHelper.excelToNaceData(file.getInputStream());

			List<NaceData> naceData = response.stream().map(this::mapToEntity).collect(Collectors.toList());
			dataRepository.saveAll(naceData);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public NaceDataResponse getNaceDataWithPagination(int pageNo, int pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<NaceData> naceData = dataRepository.findAll(pageable);

		List<NaceDataDto> content = naceData.getContent().stream().map(this::mapToResponse)
				.collect(Collectors.toList());

		NaceDataResponse response = new NaceDataResponse();
		response.setContent(content);
		response.setPageNo(naceData.getNumber());
		response.setPageSize(naceData.getSize());
		response.setTotalElements(naceData.getTotalElements());
		response.setTotalPages(naceData.getTotalPages());
		response.setLast(naceData.isLast());

		return response;
	}

	@Override
	public List<NaceDataDto> getNaceData() {

		List<NaceData> naceData = dataRepository.findAll();

		return naceData.stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	private NaceData mapToEntity(NaceDataDto response) {

		NaceData data = new NaceData();

		data.setOrderId(response.getOrderId());
		data.setLevel(response.getLevel());
		data.setCode(response.getCode());
		data.setParent(response.getParent());
		data.setDescription(response.getDescription());
		data.setItemIncludes(response.getItemIncludes());
		data.setItemIncludesExtra(response.getItemIncludesExtra());
		data.setRulings(response.getRulings());
		data.setItemExcludes(response.getItemExcludes());
		data.setRefIsicRev(response.getRefIsicRev());

		return data;
	}

	private NaceDataDto mapToResponse(NaceData data) {

		NaceDataDto response = new NaceDataDto();

		response.setOrderId(data.getOrderId());
		response.setLevel(data.getLevel());
		response.setCode(data.getCode());
		response.setParent(data.getParent());
		response.setDescription(data.getDescription());
		response.setItemIncludes(data.getItemIncludes());
		response.setItemIncludesExtra(data.getItemIncludesExtra());
		response.setRulings(data.getRulings());
		response.setItemExcludes(data.getItemExcludes());
		response.setRefIsicRev(data.getRefIsicRev());

		return response;
	}

}
