package com.example.rest.resource;

import com.example.rest.dto.EmployeeDto;
import com.example.rest.models.Models;
import com.example.rest.util.DateFormatter;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.server.mvc.ErrorTemplate;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 *
 * @author tada
 */
@Path("employees")
@RequestScoped
public class EmployeeIndexResource {
    
    @Inject
    private EmployeeService employeeService;
    @Inject
    private Models models;
    
    @GET
    @Path("index")
    public Viewable index() throws Exception {
        List<EmployeeDto> employeeList = employeeService.findByName("");
        models.put("employeeList", employeeList);
        return new Viewable("index");
    }
    
    @GET
    @Path("findByName")
    @ErrorTemplate(name = "index")
    public Viewable findByName(@QueryParam("name") @DefaultValue("") @Pattern(regexp = "[a-zA-Z]*") String name) throws Exception {
        List<EmployeeDto> employeeList = employeeService.findByName(name);
        models.put("employeeList", employeeList);
        return new Viewable("index");
    }
    
}
