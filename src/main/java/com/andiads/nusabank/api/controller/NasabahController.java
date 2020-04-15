package com.andiads.nusabank.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import com.andiads.nusabank.api.Repository.NasabahRepository;
import com.andiads.nusabank.api.entity.Nasabah;
import com.andiads.nusabank.api.exception.*;

@RestController
@RequestMapping("/nusabank/api")
public class NasabahController {

	private static final String LinkFormat =
	          "<a href='http://localhost:8080/nusabank/api/nasabah/page/?page=%s&size=%s'>%s</a><br/>";
	
	@Autowired
	private NasabahRepository nasabahRepository;
	
	public NasabahController(NasabahRepository nr) {
		this.nasabahRepository=nr;
	}
	
	// get all of nasabah lists
	@GetMapping("/nasabah")
	public List<Nasabah> getAllNasabah(){
		return this.nasabahRepository.findAll();
	}
	
	// get all paged nasabah lists
	@GetMapping("/nasabah/page/")
	public String showPagedNasabahList(Pageable pageable) {
		
		Page<Nasabah> pgNasabah = this.nasabahRepository.findAll(pageable);
		List<Nasabah> listNasabah = pgNasabah.getContent();
		
		String response = 
				listNasabah.stream()
				.map(Nasabah::toString)
				.collect(Collectors.joining("<br/>"));
		response += "<br/><br/>";
		if (pgNasabah.hasPrevious()) {
			response += String.format(LinkFormat, 
					pgNasabah.getNumber()-1,
					pgNasabah.getSize(), 
					"Previous Page");
		}
		if (pgNasabah.hasNext()) {
			response += String.format(LinkFormat, 
					pgNasabah.getNumber()+1,
					pgNasabah.getSize(), 
					"Next Page");
		}
		return response;
		
	}
	
	// get nasabah by ID
	@GetMapping("/nasabah/{id}")
	public Nasabah getNasabahById(@PathVariable(value = "id") int id) {
		return this.nasabahRepository.findById(id)
				.orElseThrow(() -> new NasabahNotFoundException("Nasabah", "id", id));
	}
	
	// search nasabah by nama
	@GetMapping("/nasabah/search/name/{namaContains}")
	public Page<Nasabah> getNasabahByNamaContaining(@PathVariable(value = "namaContains") String nama, Pageable pageable) {
		return this.nasabahRepository.findByNamaContaining(nama, pageable);				
	}
	
	// search nasabah by nik
	@GetMapping("/nasabah/search/nik/{nikContains}")
	public Page<Nasabah> getNasabahByNikContaining(@PathVariable(value = "nikContains") String nik, Pageable pageable) {
		return this.nasabahRepository.findByNikContaining(nik, pageable);
	}
	

	// post new nasabah
	
	
	// update
	
	// delete
}
