package com.graph.redis.lp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graph.redis.lp.object.Facility;
import com.graph.redis.lp.repository.RedisGraphRepository;

@Service
public class FacilityService {
	
	@Autowired
	RedisGraphRepository repository;
	
	public void create(Facility facility) {
		repository.create(facility);
	}

	public void createAll(List<Facility> facilities) {
		repository.createAll(facilities);	
	}
	
	
	public List<Facility> getAll() {
		@SuppressWarnings("unchecked")
		List<Facility> all = (List<Facility>) repository.getAll(new Facility());
		return all;
	}

	public void update(Facility facility, String id) {
		repository.update(facility, id);
		
	}
}
