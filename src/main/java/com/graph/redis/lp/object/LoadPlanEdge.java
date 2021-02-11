package com.graph.redis.lp.object;

import com.graph.redis.core.object.RepositoryEdge;
public class LoadPlanEdge extends RepositoryEdge {
	
	private Facility origin;
	private Facility destination;
	private LoadPlan loadPlan;
	
	public Facility getOrigin() {
		return origin;
	}
	public void setOrigin(Facility origin) {
		this.origin = origin;
	}
	public LoadPlan getLoadPlan() {
		return loadPlan;
	}
	public void setLoadPlan(LoadPlan loadPlan) {
		this.loadPlan = loadPlan;
	}
	public Facility getDestination() {
		return destination;
	}
	public void setDestination(Facility destination) {
		this.destination = destination;
	}

}
