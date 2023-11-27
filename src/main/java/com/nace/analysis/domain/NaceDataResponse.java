package com.nace.analysis.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class NaceDataResponse {

    private List<NaceDataDto> content;
    @JsonIgnore
    private int pageNo;
    @JsonIgnore
    private int pageSize;
    @JsonIgnore
    private long totalElements;
    @JsonIgnore
    private int totalPages;
    @JsonIgnore
    private boolean last;
    
    public NaceDataResponse() {
    	
    }
    
	public NaceDataResponse(List<NaceDataDto> content, int pageNo, int pageSize, long totalElements, int totalPages,
			boolean last) {
		super();
		this.content = content;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.totalElements = totalElements;
		this.totalPages = totalPages;
		this.last = last;
	}

	public List<NaceDataDto> getContent() {
		return content;
	}

	public void setContent(List<NaceDataDto> content) {
		this.content = content;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	@Override
	public String toString() {
		return "NaceDataResponse [content=" + content + ", pageNo=" + pageNo + ", pageSize=" + pageSize
				+ ", totalElements=" + totalElements + ", totalPages=" + totalPages + ", last=" + last + "]";
	}
    
	
    
}
