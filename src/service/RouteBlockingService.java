package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import beans.Edge;
import beans.Vertex;
import beans.AugmentedVertex;
import datastructure.MinHeap;
import datastructure.PriorityQueue;

//Singleton
public class RouteBlockingService {
	private static RouteBlockingService routeBlockingService;
	private RouteBlockingService() {}
	public static RouteBlockingService getRouteBlockingService() {
		if(routeBlockingService==null) {
			routeBlockingService=new RouteBlockingService();
		}
		return routeBlockingService;
	}
	
	/*Find optimal route from source to destination to minimize traffic disruption 
	using a greedy algorithm which uses ideas from Dijkstra Single source shortest path algorithm.*/
	public List<Edge> findOptimalRoute(List<Vertex> inputAdjacencyList, Integer source, Integer destination) {
		List<Edge> edgeSequence=new LinkedList<Edge>();
		PriorityQueue minHeap=new MinHeap();
		
		List<Map<Integer,Edge>> adjacencyMap=new ArrayList();
		for(Vertex vertex:inputAdjacencyList) {
			Map<Integer,Edge> map=new HashMap<Integer,Edge>();
			for(Edge edge:vertex.getOutgoingEdges()) {
				map.put(edge.getDestination(),edge);
			}
			adjacencyMap.add(map);
		}
		
		//Create an augmented Vertex adjacency list from the input. 
		List<AugmentedVertex> adjacencyList=new ArrayList<AugmentedVertex>();
		for(int i=0;i<inputAdjacencyList.size();i++) {
			Vertex inputVertex=inputAdjacencyList.get(i);
			AugmentedVertex tempVertex=new AugmentedVertex(inputVertex);
			tempVertex.setIndex(i);
			adjacencyList.add(tempVertex);
		}
		
		//Initialize current vertex to source and initialize its attributes
		AugmentedVertex currentVertex=adjacencyList.get(source);
		currentVertex.setTotalDistance(0);
		currentVertex.setTotalTraffic(currentVertex.getTotalIncomingTraffic());
		currentVertex.setValue(0);
		
		//Insert source vertex as the first vertex in the min heap
		minHeap.insert(currentVertex);
		currentVertex.setReached(true);
		
		//Iterate till min-heap is empty or minimum value path to destination vertex is found 
		while(!minHeap.isEmpty()){
			currentVertex=minHeap.deleteMin();
			currentVertex.setProcessed(true);
			if(currentVertex.getIndex()==destination) {
				break;
			}
			List<Edge> outgoingEdges = currentVertex.getOutgoingEdges();
			
			for(Edge outgoingEdge:outgoingEdges) {
				//Relax all edges from the vertex being processed
				AugmentedVertex vertex = adjacencyList.get(outgoingEdge.getDestination());
				if(vertex.isProcessed()) {
					continue;
				}
				double totalTraffic=currentVertex.getTotalTraffic()+vertex.getTotalIncomingTraffic()-outgoingEdge.getTraffic();
				
				//System.out.println("currentVertex: "+currentVertex.getIndex()+", reached Vertex: "+vertex.getIndex());
				//System.out.println("currentVertex total traffic: "+currentVertex.getTotalTraffic()+", reached Vertex TotalIncomingTraffic: "+vertex.getTotalIncomingTraffic()+", outgoingEdge.getTraffic(): "+outgoingEdge.getTraffic());
				if(adjacencyMap.get(vertex.getIndex()).containsKey(currentVertex.getIndex())) {
					totalTraffic-=adjacencyMap.get(vertex.getIndex()).get(currentVertex.getIndex()).getTraffic();
					//System.out.println("loop: "+adjacencyMap.get(vertex.getIndex()).get(currentVertex.getIndex()).getTraffic());
				}
				//System.out.println("totalTraffic: "+totalTraffic);
				double totalDistance=currentVertex.getTotalDistance()+outgoingEdge.getDistance();
				//System.out.println("totalDistance: "+totalDistance);
				double value=totalDistance*totalTraffic;
				//System.out.println("value: "+value);
				if(vertex.isReached()) {
					//Vertex is already present in min-heap
					if(value<vertex.getValue()) {
						//Better path to vertex has been found
						vertex.setTotalDistance(totalDistance);
						vertex.setTotalTraffic(totalTraffic);
						vertex.setValue(value);
						vertex.setMinEdge(outgoingEdge);
						vertex.setMinPredecessor(currentVertex.getIndex());
						minHeap.heapify(vertex);
					}
				}
				else {
					//Vertex is reached for the first time
					vertex.setTotalDistance(totalDistance);
					vertex.setTotalTraffic(totalTraffic);
					vertex.setValue(value);
					vertex.setMinEdge(outgoingEdge);
					vertex.setMinPredecessor(currentVertex.getIndex());
					vertex.setReached(true);
					minHeap.insert(vertex);
				}
			}
		}
		
		if(adjacencyList.get(destination).isProcessed()) {
			//Find the optimal path by traveling back from destination to source
			Stack<Edge> edges=new Stack<Edge>();
			currentVertex=adjacencyList.get(destination);
			while(currentVertex.getIndex()!=source) {
				edges.push(currentVertex.getMinEdge());
				currentVertex=adjacencyList.get(currentVertex.getMinPredecessor());
			}
			while(!edges.isEmpty()) {
				edgeSequence.add(edges.pop());
			}
		}
		return edgeSequence;
	}
	public void generateTotalTraffic(List<Vertex> adjacencyList) {
		for(Vertex vertex:adjacencyList) {
			vertex.setTotalIncomingTraffic(0.0);
		}
		for(Vertex vertex:adjacencyList) {
			List<Edge> outgoingEdges = vertex.getOutgoingEdges();
			for(Edge edge:outgoingEdges) {
				adjacencyList.get(edge.getDestination()).setTotalIncomingTraffic(adjacencyList.get(edge.getDestination()).getTotalIncomingTraffic()+edge.getTraffic());
			}
		}
	}


}
