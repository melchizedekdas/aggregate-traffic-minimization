package beans;

public class Edge {
	//DestinationVertexIndex
	private Integer destination;
	//distance of road
	private Double distance;
	//vehicles per unit time
	private Double traffic;

	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public void setTraffic(Double traffic) {
		this.traffic = traffic;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTraffic() {
		return traffic;
	}
	public void setTraffic(double traffic) {
		this.traffic = traffic;
	}

}
