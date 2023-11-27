package com.nace.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nace.analysis.entity.NaceData;

public interface NaceDataRepository extends JpaRepository<NaceData, Long> {

}
