package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Edge;
import beans.RouteBlockingRequest;
import service.RouteBlockingService;

@Path("/viproute")
public class RouteBlockingController {

	//Find a route that has to be blocked for a VIP to travel through in such a way that the traffic disruption is minimized
	@Path("/withtotaltraffic")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Edge> vipRouteWithTotalTraffic(RouteBlockingRequest request) {
		return RouteBlockingService.getRouteBlockingService().findOptimalRoute(request.getAdjacencyList(), request.getSource(), request.getDestination());
	}

	//Find a route that has to be blocked for a VIP to travel through in such a way that the traffic disruption is minimized
	@Path("/withouttotaltraffic")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Edge> vipRouteWithOutTotalTraffic(RouteBlockingRequest request) {
		RouteBlockingService.getRouteBlockingService().generateTotalTraffic(request.getAdjacencyList());
		return RouteBlockingService.getRouteBlockingService().findOptimalRoute(request.getAdjacencyList(), request.getSource(), request.getDestination());
	}
}
