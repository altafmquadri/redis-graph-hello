package com.graph.redis.lp.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.graph.redis.lp.object.Facility;
import com.graph.redis.lp.object.LegEdge;
import com.graph.redis.lp.repository.RedisGraphRepository;

@Service
public class LegService {
	
	@Autowired
	RedisGraphRepository repository;
	
	public void create(LegEdge legEdge) {
		repository.createEdge(legEdge);
	}
	
	public List<LegEdge> getLegEdge(LegEdge legEdge) {
		ArrayList<LegEdge> all = (ArrayList<LegEdge>) repository.getEdgeByFilter(legEdge);
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println(mapper.writeValueAsString(all));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<LegEdge>) all;	
	}
	
	public void createAll(List<LegEdge> legEdges) {
		for(LegEdge legEdge: legEdges) {
			repository.createEdge(legEdge);
		}

	}

}
