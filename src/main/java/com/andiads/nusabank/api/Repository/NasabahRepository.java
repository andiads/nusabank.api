package com.andiads.nusabank.api.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.andiads.nusabank.api.entity.Nasabah;

@Repository
public interface NasabahRepository extends PagingAndSortingRepository<Nasabah, Integer>,
	JpaRepository<Nasabah,Integer>{

	 @RestResource(path = "namaContains")
	 public Page<Nasabah> findByNamaContaining(@Param("nama") String nama, Pageable p);

	 @RestResource(path = "nikContains")
	 public Page<Nasabah> findByNikContaining(@Param("nik") String nik, Pageable p);
}
