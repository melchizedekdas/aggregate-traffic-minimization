package beans;

public class AugmentedVertex extends Vertex{
	private int index;
	private int minHeapIndex;
	private double totalDistance;
	private double totalTraffic;
	private double value;
	private Edge minEdge;
	private int minPredecessor;
	private boolean isReached;
	private boolean isProcessed;
	
	public AugmentedVertex(Vertex vertex) {
		this.totalIncomingTraffic=vertex.totalIncomingTraffic;
		this.outgoingEdges=vertex.outgoingEdges;
		totalDistance=Double.MAX_VALUE;
		totalTraffic=Double.MAX_VALUE;
		value=Double.MAX_VALUE;
		isReached=false;
		isProcessed=false;
	}
	public double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public double getTotalTraffic() {
		return totalTraffic;
	}
	public void setTotalTraffic(double totalTraffic) {
		this.totalTraffic = totalTraffic;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Edge getMinEdge() {
		return minEdge;
	}
	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}
	public boolean isReached() {
		return isReached;
	}
	public void setReached(boolean isReached) {
		this.isReached = isReached;
	}
	public boolean isProcessed() {
		return isProcessed;
	}
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	public int getMinHeapIndex() {
		return minHeapIndex;
	}
	public void setMinHeapIndex(int minHeapIndex) {
		this.minHeapIndex = minHeapIndex;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public int getMinPredecessor() {
		return minPredecessor;
	}
	public void setMinPredecessor(int minPredecessor) {
		this.minPredecessor = minPredecessor;
	}
}
