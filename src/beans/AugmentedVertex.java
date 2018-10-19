package beans;

public class AugmentedVertex extends Vertex{
	//Index of vertex in the list of Vertices
	private int index;
	//Index of vertex in min-heap array if present in heap. Used for fast heapify operation
	private int minHeapIndex;
	//Total distance from source to this vertex
	private double totalDistance;
	//Total incoming traffic encountered in the path
	private double totalTraffic;
	//Product of totalDistance and totalTraffic
	private double value;
	//The edge through which this vertex was reached so that value is minimum
	private Edge minEdge;
	//The vertex from we reached this vertex in the minimum value route
	private int minPredecessor;
	//If this vertex has been reached by relaxing any edge
	private boolean isReached;
	//If the outgoing edges from this vertex have been processed till now
	private boolean isProcessed;
	
	public AugmentedVertex(Vertex vertex) {
		this.totalIncomingTraffic=vertex.totalIncomingTraffic;
		this.outgoingEdges=vertex.outgoingEdges;
		
		//Initialization
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
