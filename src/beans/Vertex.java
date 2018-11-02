package beans;

import java.util.List;
 
public class Vertex {
	//Sum of traffic of all incoming edges to this vertex
	protected Double totalIncomingTraffic;
	protected List<Edge> outgoingEdges;
	public Double getTotalIncomingTraffic() {
		return totalIncomingTraffic;
	}
	public void setTotalIncomingTraffic(Double totalIncomingTraffic) {
		this.totalIncomingTraffic = totalIncomingTraffic;
	}
	public List<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	public void setOutgoingEdges(List<Edge> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
}
