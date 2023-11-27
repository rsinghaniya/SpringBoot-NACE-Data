package com.nace.analysis.domain;

public class NaceDataDto {
	
	private String orderId;
	private String level;
	private String code;
	private String parent;
	private String description;
	private String itemIncludes;
	private String itemIncludesExtra;
	private String rulings;
	private String itemExcludes;
	private String refIsicRev;
	
	public NaceDataDto() {
		
	}
	
	public NaceDataDto(String orderId, String level, String code, String parent, String description,
			String itemIncludes, String itemIncludesExtra, String rulings, String itemExcludes, String refIsicRev) {
		super();
		this.orderId = orderId;
		this.level = level;
		this.code = code;
		this.parent = parent;
		this.description = description;
		this.itemIncludes = itemIncludes;
		this.itemIncludesExtra = itemIncludesExtra;
		this.rulings = rulings;
		this.itemExcludes = itemExcludes;
		this.refIsicRev = refIsicRev;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemIncludes() {
		return itemIncludes;
	}

	public void setItemIncludes(String itemIncludes) {
		this.itemIncludes = itemIncludes;
	}

	public String getItemIncludesExtra() {
		return itemIncludesExtra;
	}

	public void setItemIncludesExtra(String itemIncludesExtra) {
		this.itemIncludesExtra = itemIncludesExtra;
	}

	public String getRulings() {
		return rulings;
	}

	public void setRulings(String rulings) {
		this.rulings = rulings;
	}

	public String getItemExcludes() {
		return itemExcludes;
	}

	public void setItemExcludes(String itemExcludes) {
		this.itemExcludes = itemExcludes;
	}

	public String getRefIsicRev() {
		return refIsicRev;
	}

	public void setRefIsicRev(String refIsicRev) {
		this.refIsicRev = refIsicRev;
	}

	@Override
	public String toString() {
		return "NaceDataResponse [orderId=" + orderId + ", level=" + level + ", code=" + code + ", parent=" + parent
				+ ", description=" + description + ", itemIncludes=" + itemIncludes + ", itemIncludesExtra="
				+ itemIncludesExtra + ", rulings=" + rulings + ", itemExcludes=" + itemExcludes + ", refIsicRev="
				+ refIsicRev + "]";
	}
	
	
	
}
