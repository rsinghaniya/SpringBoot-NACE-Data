package com.nace.analysis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nacedata")
public class NaceData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String orderId;
	@Column(length = 100)
	private String level;
	@Column(length = 100)
	private String code;
	@Column(length = 100)
	private String parent;
	@Column(length = 255)
	private String description;
	@Column(length = 255)
	private String itemIncludes;
	@Column(length = 255)
	private String itemIncludesExtra;
	@Column(length = 255)
	private String rulings;
	@Column(length = 255)
	private String itemExcludes;
	@Column(length = 100)
	private String refIsicRev;
	
	public NaceData() {
		
	}
	
	public NaceData(Long id, String orderId, String level, String code, String parent, String description,
			String itemIncludes, String itemIncludesExtra, String rulings, String itemExcludes, String refIsicRev) {
		super();
		this.id = id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "NaceData [id=" + id + ", orderId=" + orderId + ", level=" + level + ", code=" + code + ", parent="
				+ parent + ", description=" + description + ", itemIncludes=" + itemIncludes + ", itemIncludesExtra="
				+ itemIncludesExtra + ", rulings=" + rulings + ", itemExcludes=" + itemExcludes + ", refIsicRev="
				+ refIsicRev + "]";
	}
	

	
}
