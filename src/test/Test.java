package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import beans.Edge;
import beans.Vertex;
import service.RouteBlockingService;

public class Test {

	public static void main(String[] args) {
		Vertex v0=new Vertex();
		v0.setOutgoingEdges(new LinkedList<Edge>());

		Vertex v1=new Vertex();
		v1.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge0=new Edge();
		edge0.setDestination(1);
		edge0.setDistance(1);
		edge0.setTraffic(4);
		v0.getOutgoingEdges().add(edge0);

		Vertex v2=new Vertex();
		v2.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge1=new Edge();
		edge1.setDestination(2);
		edge1.setDistance(1);
		edge1.setTraffic(2);
		v1.getOutgoingEdges().add(edge1);

		Vertex v3=new Vertex();
		v3.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge2=new Edge();
		edge2.setDestination(3);
		edge2.setDistance(1.5);
		edge2.setTraffic(2);
		v2.getOutgoingEdges().add(edge2);

		Edge edge3=new Edge();
		edge3.setDestination(1);
		edge3.setDistance(2.1);
		edge3.setTraffic(1);
		v3.getOutgoingEdges().add(edge3);

		Vertex v4=new Vertex();
		v4.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge4=new Edge();
		edge4.setDestination(4);
		edge4.setDistance(5);
		edge4.setTraffic(3);
		v1.getOutgoingEdges().add(edge4);

		Vertex v5=new Vertex();
		v5.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge5=new Edge();
		edge5.setDestination(5);
		edge5.setDistance(1.5);
		edge5.setTraffic(1);
		v3.getOutgoingEdges().add(edge5);

		Edge edge6=new Edge();
		edge6.setDestination(5);
		edge6.setDistance(2);
		edge6.setTraffic(3);
		v4.getOutgoingEdges().add(edge6);

		Vertex v6=new Vertex();
		v6.setOutgoingEdges(new LinkedList<Edge>());

		Edge edge7=new Edge();
		edge7.setDestination(6);
		edge7.setDistance(4.5);
		edge7.setTraffic(4);
		v5.getOutgoingEdges().add(edge7);

		Edge edge8=new Edge();
		edge8.setDestination(0);
		edge8.setDistance(5.5);
		edge8.setTraffic(4);
		v6.getOutgoingEdges().add(edge8);
		
		v0.setTotalIncomingTraffic(4);
		v1.setTotalIncomingTraffic(5);
		v2.setTotalIncomingTraffic(2);
		v3.setTotalIncomingTraffic(2);
		v4.setTotalIncomingTraffic(3);
		v5.setTotalIncomingTraffic(4);
		v6.setTotalIncomingTraffic(4);
		
		List<Vertex> adjacencyList=new ArrayList<Vertex>();
		adjacencyList.add(v0);
		adjacencyList.add(v1);
		adjacencyList.add(v2);
		adjacencyList.add(v3);
		adjacencyList.add(v4);
		adjacencyList.add(v5);
		adjacencyList.add(v6);

		List<Edge> optimalRoute = RouteBlockingService.getRouteBlockingService().findOptimalRoute(adjacencyList,1, 5);
		if(!optimalRoute.isEmpty()) {
			System.out.print(1+" ");
			for(Edge edge:optimalRoute) {
				System.out.print(edge.getDestination()+" ");
			}
		}
		else {
			System.out.println("No route found");
		}
	}

}
