package com.graph.redis.lp.object;

import com.graph.redis.core.object.GraphEdgeElementType;
import com.graph.redis.core.object.RepositoryEdge;

public class LegEdge extends RepositoryEdge {
	
	@GraphEdgeElementType ("fromNode")
	private Facility origin;
	@GraphEdgeElementType ("toNode")
	private Facility destination;
	@GraphEdgeElementType ("edge")
	private Leg leg;
	
	public Facility getOrigin() {
		return origin;
	}
	public void setOrigin(Facility origin) {
		this.origin = origin;
	}
	public Leg getLeg() {
		return leg;
	}
	public void setLeg(Leg leg) {
		this.leg = leg;
	}
	public Facility getDestination() {
		return destination;
	}
	public void setDestination(Facility destination) {
		this.destination = destination;
	}
}
