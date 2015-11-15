package com.example.rest.resource;

import com.example.rest.form.EmployeeEditForm;
import com.example.rest.util.DateFormatter;
import com.example.service.DepartmentService;
import com.example.service.EmployeeService;
import java.net.URI;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.ws.rs.BeanParam;
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
public class EmployeeEditResource {
    
    @Inject
    private EmployeeService employeeService;
    @Inject
    private DepartmentService departmentService;
    @Inject
    private DateFormatter dateFormatter;
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Path("editMain")
    public Viewable editMain(@QueryParam("empId") @Pattern(regexp = "[1-9][0-9]*") String empId) throws Exception {
//        EmployeeDto employeeDto = employeeService.findByEmpId(Integer.valueOf(empId));
//        List<DepartmentDto> departmentList = departmentService.findAll();
//        models.put("employee", employeeDto);
//        models.put("departmentList", departmentList);
        return new Viewable("editMain");
    }
//    
//    @POST
//    @Path("editConfirm")
//    public Viewable editConfirm(@BeanParam EmployeeEditForm employeeForm) {
//        models.put("employee", employeeForm);
//        return new Viewable("editConfirm");
//    }
//    
//    @POST
//    @Path("editComplete")
//    public Response editComplete(@BeanParam EmployeeEditForm employeeForm) {
//        EmployeeDto employeeDto = convertToDto(employeeForm);
//        employeeService.update(employeeDto);
//        URI location = uriInfo.getBaseUriBuilder().path("employees/index").build();
//        return Response.status(Response.Status.MOVED_PERMANENTLY)
//                .location(location)
//                .build();
//    }
//    
//    private EmployeeDto convertToDto(EmployeeEditForm form) {
//        try {
//            EmployeeDto dto = new EmployeeDto();
//            dto.setEmpId(Integer.valueOf(form.getEmpId()));
//            dto.setName(form.getName());
//            dto.setJoinedDate(dateFormatter.parse(form.getJoinedDate()));
//            DepartmentDto departmentDto = departmentService.findById(Integer.valueOf(form.getDeptId()));
//            dto.setDepartment(departmentDto);
//            return dto;
//        } catch (ParseException ex) {
//            Logger.getLogger(EmployeeEditResource.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("日付のフォーマットエラーです。", ex);
//        }
//    }
}
