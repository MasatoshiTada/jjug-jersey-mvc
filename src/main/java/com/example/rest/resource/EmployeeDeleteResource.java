package com.example.rest.resource;

import com.example.rest.dto.EmployeeDto;
import com.example.service.EmployeeService;
import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Path("employees")
@RequestScoped
public class EmployeeDeleteResource {
    
    @Inject
    private EmployeeService employeeService;
    
    @Context
    private UriInfo uriInfo;
        
    @GET
    @Path("deleteConfirm")
    public Viewable deleteConfirm(@QueryParam("empId") @Pattern(regexp = "[1-9][0-9]*") String empId) throws Exception {
        EmployeeDto employeeDto = employeeService.findByEmpId(Integer.valueOf(empId));
        return new Viewable("deleteConfirm", employeeDto);
    }
    
    @POST
    @Path("delete")
    public Response delete(@FormParam("empId") @Pattern(regexp = "[1-9][0-9]*") String empId) throws Exception {
        employeeService.delete(Integer.valueOf(empId));
        URI location = uriInfo.getBaseUriBuilder().path("employees/index").build();
        return Response.status(Response.Status.MOVED_PERMANENTLY)
                .location(location)
                .build();
    }
    
}
