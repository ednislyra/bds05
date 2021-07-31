package com.devsuperior.movieflix.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.entities.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.dto.ReviewRevisionDTO;
import com.devsuperior.movieflix.services.ReviewService;

@RestController
@RequestMapping (value = "/reviews")
public class ReviewResource {

	@Autowired
	private ReviewService service;
	
	@GetMapping
	public ResponseEntity<Page<ReviewDTO>> reviewsForCurrentUser(Pageable pageable) {
		Page<ReviewDTO> page = service.reviewsForCurrentUser(pageable);		
		return ResponseEntity.ok().body(page);
	}
	
	@PreAuthorize("hasAnyRole('MEMBER', 'VISITOR')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody ReviewRevisionDTO dto){
		service.saveRevision(id, dto);
		return ResponseEntity.noContent().build();
	}
}
