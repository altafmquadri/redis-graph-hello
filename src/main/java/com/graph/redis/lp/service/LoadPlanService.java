package com.graph.redis.lp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graph.redis.lp.object.LoadPlanEdge;
import com.graph.redis.lp.repository.RedisGraphRepository;

@Service
public class LoadPlanService {
	
	@Autowired
	RedisGraphRepository repository;

	public void create(LoadPlanEdge loadPlanEdge) {
		repository.createEdge(loadPlanEdge);
	}
	
	public List<LoadPlanEdge>  getLoadPlanEdge(LoadPlanEdge loadPlanEdge) {
		return (List<LoadPlanEdge>) repository.getEdgeByFilter(loadPlanEdge);
	}

	public void createAll(List<LoadPlanEdge> loadPlanEdges) {
		repository.createEdges(loadPlanEdges);	
	}
}
