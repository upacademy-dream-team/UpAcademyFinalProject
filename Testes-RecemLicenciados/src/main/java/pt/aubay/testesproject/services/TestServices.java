package pt.aubay.testesproject.services;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import pt.aubay.testesproject.business.TestBusiness;
import pt.aubay.testesproject.execptionHandling.AppException;
import pt.aubay.testesproject.models.dto.TestDTO;

@Transactional
@Path("test")
public class TestServices {
	
	@Inject
	protected TestBusiness testBusiness;
	
	@Context
	protected UriInfo context;
	
	@GET
	@Path("status")
	@Produces (MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addTest(TestDTO test) throws AppException {
		testBusiness.add(test);
		return Response.ok().entity("Success").build();
	}
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTests() {
		return testBusiness.getAll();
	}
	
	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTest(@PathParam("id") long id) throws AppException {
		return Response.ok(testBusiness.get(id), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("edit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.TEXT_PLAIN)
	public Response editTest(TestDTO test) throws AppException {
		testBusiness.edit(test);
		return Response.ok().entity("Success").build();
	}
	
	@DELETE
	@Path("remove/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.TEXT_PLAIN)
	public Response deleteTest(@PathParam("id") long id) throws AppException {
		testBusiness.remove(id);
		return Response.ok().entity("Success").build();
	}
	
//	@GET
//	@Path("getCategories/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Set<String> getCategories(@PathParam("id") long id) {
//		return testBusiness.getCategories(id);
//	}
}
