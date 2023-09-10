package restapi.crud.REST;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import restapi.crud.REST.StudentRepository;

@Path("students")

public class RestResource {
	StudentRepository repo = new StudentRepository();
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Rest> getstudent()
	{
		System.out.println("getRest is called....");
		System.out.println("Data from the database");
		return repo.getstudent();
		
	}
	
	@GET
	@Path("student/{Sid} ")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Rest getRest(@PathParam("Sid") int Sid)
	{
		return repo.getRest(Sid);
		
	}
	
	@POST
	@Path("student")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Rest createstudent(Rest s1)
	{
		System.out.println("Created sucessfully");
		System.out.println(s1);
repo.create(s1);
		
		return s1;
	}
	

	@PUT
	@Path("student")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Rest updatestudent(Rest s1)
	{
		System.out.println("Updated sucessfully");
		System.out.println(s1);
		if(repo.getRest(s1.getSid()).getSid()==0)
		{
			repo.create(s1);
		}
		else {
			repo.update(s1);
		}
		return s1;
	}
	
	@DELETE
	@Path("student/{Sid}")
	public Rest deletestudent(@PathParam("Sid") int Sid)
	{
		System.out.println("Deleted sucessfully");
		Rest s=repo.getRest(Sid);
		
		if(s.getSid()!=0)
			repo.delete(Sid);
		return s;
		
	}
}
