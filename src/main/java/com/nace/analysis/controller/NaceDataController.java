package com.nace.analysis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nace.analysis.domain.NaceDataDto;
import com.nace.analysis.domain.NaceDataResponse;
import com.nace.analysis.service.NaceDataService;
import com.nace.analysis.utils.AppConstants;

@RestController
@RequestMapping("/rest/api")
public class NaceDataController {

	@Autowired
	private NaceDataService dataService;

	/**
	 * This API is used to upload the NACE Data to Database
	 * @param file
	 * @return
	 */
	@PostMapping("/upload")
	public ResponseEntity<List<NaceDataDto>> uploadNaceData(@RequestParam(name = "file") MultipartFile file) {
		return ResponseEntity.ok(dataService.uploadNaceData(file));
	}

	/**
	 * This API returns the list of NACE Data from Database
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@GetMapping("/nace-data")
	public ResponseEntity<List<NaceDataDto>> getNaceData() {
		return ResponseEntity.ok(dataService.getNaceData());
	}

	/**
	 * This API can be used to get the NACE Data with pagination capabilities and
	 * can be integrated with front end to provide the pagination and sorting
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param sortBy
	 * @param sortDir
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
	@GetMapping("/nace-data-with-pagination")
	public ResponseEntity<NaceDataResponse> getNaceDataWithPagination(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NO, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIR, required = false) String sortDir) {
		return ResponseEntity.ok(dataService.getNaceDataWithPagination(pageNo, pageSize, sortBy, sortDir));
	}

}
