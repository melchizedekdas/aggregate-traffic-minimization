package service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import beans.Edge;
import beans.Vertex;
import beans.AugmentedVertex;
import datastructure.MinHeap;

public class RouteBlockingService {
	private static RouteBlockingService routeBlockingService;
	private RouteBlockingService() {}
	public static RouteBlockingService getRouteBlockingService() {
		if(routeBlockingService==null) {
			routeBlockingService=new RouteBlockingService();
		}
		return routeBlockingService;
	}
	public List<Edge> findOptimalRoute(List<Vertex> inputAdjacencyList, Integer source, Integer destination) {
		List<Edge> edgeSequence=new LinkedList<Edge>();
		MinHeap minHeap=new MinHeap();
		
		List<AugmentedVertex> adjacencyList=new ArrayList<AugmentedVertex>();
		for(int i=0;i<inputAdjacencyList.size();i++) {
			Vertex inputVertex=inputAdjacencyList.get(i);
			AugmentedVertex tempVertex=new AugmentedVertex(inputVertex);
			tempVertex.setIndex(i);
			adjacencyList.add(tempVertex);
		}
		
		AugmentedVertex currentVertex=adjacencyList.get(source);
		currentVertex.setTotalDistance(0);
		currentVertex.setTotalTraffic(currentVertex.getTotalIncomingTraffic());
		currentVertex.setValue(0);
		
		minHeap.insert(currentVertex);
		currentVertex.setReached(true);
		while(!minHeap.isEmpty()){
			currentVertex=minHeap.deleteMin();
			currentVertex.setProcessed(true);
			if(currentVertex.getIndex()==destination) {
				break;
			}
			List<Edge> outgoingEdges = currentVertex.getOutgoingEdges();
			for(Edge outgoingEdge:outgoingEdges) {
				AugmentedVertex vertex = adjacencyList.get(outgoingEdge.getDestination());
				if(vertex.isProcessed()) {
					continue;
				}
				double totalTraffic=currentVertex.getTotalTraffic()+vertex.getTotalIncomingTraffic()-outgoingEdge.getTraffic();
				double totalDistance=currentVertex.getTotalDistance()+outgoingEdge.getDistance();
				double value=totalDistance*totalTraffic;
				if(vertex.isReached()) {
					if(value<vertex.getValue()) {
						vertex.setTotalDistance(totalDistance);
						vertex.setTotalTraffic(totalTraffic);
						vertex.setValue(value);
						vertex.setMinEdge(outgoingEdge);
						vertex.setMinPredecessor(currentVertex.getIndex());
						minHeap.heapify(vertex);
					}
				}
				else {
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


}
