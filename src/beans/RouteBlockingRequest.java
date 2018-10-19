package beans;

import java.util.List;

public class RouteBlockingRequest {
	private List<Vertex> adjacencyList;
	private Integer source;
	private Integer destination;
	public List<Vertex> getAdjacencyList() {
		return adjacencyList;
	}
	public void setAdjacencyList(List<Vertex> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}

}
