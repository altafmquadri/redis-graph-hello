package com.graph.redis.lp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graph.redis.lp.object.Facility;
import com.graph.redis.lp.object.LegEdge;
import com.graph.redis.lp.object.LoadPlanEdge;
import com.graph.redis.lp.service.FacilityService;
import com.graph.redis.lp.service.LegService;
import com.graph.redis.lp.service.LoadPlanService;


@RestController
@RequestMapping("/api/graph")
public class LoadPlanGraphController {
	@Autowired
	FacilityService facilityService;
	@Autowired
	LoadPlanService loadPlanService;
	@Autowired
	LegService legService;

	@PostMapping(path = "/Leg",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postLeg (@RequestBody LegEdge legEdge)  {
		legService.create(legEdge);
		return ResponseEntity.ok("");
	}
	
	@PostMapping(path = "/Legs",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postLegs (@RequestBody List<LegEdge> legEdges)  {
		legService.createAll(legEdges);
		return ResponseEntity.ok("");
	}

	@GetMapping("/Legs")
	public ResponseEntity<List<LegEdge>> getLegs(@RequestParam(name = "query") String legEdgeString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		LegEdge lpe = objectMapper.readValue(legEdgeString, LegEdge.class);

		List<LegEdge> ja = legService.getLegEdge(lpe);
		return ResponseEntity.accepted().body(ja);
	}
	
	@PostMapping(path = "/LoadPlans",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postloadPlans (@RequestBody List<LoadPlanEdge> loadPlans)  {
		loadPlanService.createAll(loadPlans);
		return ResponseEntity.ok("");
	}

	@PostMapping(path = "/LoadPlan",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postLoadPlan (@RequestBody LoadPlanEdge loadPlanEdge)  {
		loadPlanService.create(loadPlanEdge);
		return ResponseEntity.ok("");
	}

	@GetMapping("/LoadPlans")
	public ResponseEntity<List<LoadPlanEdge>> getLoadPlanEdges(@RequestParam(name = "query") String loadPlanEdgeString) throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		LoadPlanEdge lpe = objectMapper.readValue(loadPlanEdgeString, LoadPlanEdge.class);
		List<LoadPlanEdge> ja = loadPlanService.getLoadPlanEdge(lpe);
		return ResponseEntity.accepted().body(ja);
	}

	@PostMapping(path = "/Facility",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postFacility (@RequestBody Facility facility)  {
		facilityService.create(facility);
		return ResponseEntity.ok("");
	}
	
	@PutMapping(path = "/Facility/{id}",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> updateFacility (@RequestBody Facility facility, @PathVariable("id") String id)  {
		facilityService.update(facility, id);
	
		return ResponseEntity.ok("");
	}

	@PostMapping(path = "/Facilities",consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> postFacilities(@RequestBody List<Facility> facilities)  {
		facilityService.createAll(facilities);
		return ResponseEntity.ok("Hello World!");
	}

	@GetMapping("/Facility")
	public ResponseEntity<List<Facility>> getAll() {
		List<Facility> ja = facilityService.getAll();
		return ResponseEntity.accepted().body(ja);
	}

	@GetMapping("/ping")
	public ResponseEntity<String> getPing() {
		return ResponseEntity.accepted().body("I am awake");
	}

	@DeleteMapping(path = "/Facility/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> deleteFacility(@PathVariable String id){
		facilityService.delete(id);
		return ResponseEntity.ok("Facility Deleted");
	}
}