package beans;

import java.util.List;

public class Vertex {
	//Sum of traffic of all incoming edges to this vertex
	protected Integer totalIncomingTraffic;
	protected List<Edge> outgoingEdges;
	public Integer getTotalIncomingTraffic() {
		return totalIncomingTraffic;
	}
	public void setTotalIncomingTraffic(Integer totalIncomingTraffic) {
		this.totalIncomingTraffic = totalIncomingTraffic;
	}
	public List<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	public void setOutgoingEdges(List<Edge> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
}
