package beans;
public class Edge {
	//Destination Vertex Index
	private Integer destination;
	//Distance of road
	private Double distance;
	//Vehicles per unit time
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
