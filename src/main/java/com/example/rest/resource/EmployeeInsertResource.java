package com.example.rest.resource;

import com.example.rest.form.EmployeeInsertForm;
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
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
public class EmployeeInsertResource {
    
    @Inject
    private EmployeeService employeeService;
    @Inject
    private DepartmentService departmentService;
    @Inject
    private DateFormatter dateFormatter;
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Path("insertMain")
    public Viewable insertMain() throws Exception {
//        List<DepartmentDto> departmentList = departmentService.findAll();
//        models.put("departmentList", departmentList);
        return new Viewable("insertMain");
    }
//    
//    @POST
//    @Path("insertConfirm")
//    public Viewable insertConfirm(@BeanParam EmployeeInsertForm employeeInsertForm) throws Exception {
//        models.put("employee", employeeInsertForm);
//        return new Viewable("insertConfirm");
//    }
//    
//    @POST
//    @Path("insertComplete")
//    public Response insertComplete(@BeanParam EmployeeInsertForm employeeInsertForm) throws Exception {
//        EmployeeDto employeeDto = convertToDto(employeeInsertForm);
//        employeeService.insert(employeeDto);
//        // index画面にリダイレクト
//        URI location = uriInfo.getBaseUriBuilder().path("employees/index").build();
//        return Response.status(Response.Status.MOVED_PERMANENTLY)
//                .location(location).build();
//    }
//    
//    private EmployeeDto convertToDto(EmployeeInsertForm form) {
//        try {
//            EmployeeDto dto = new EmployeeDto();
//            dto.setName(form.getName());
//            dto.setJoinedDate(dateFormatter.parse(form.getJoinedDate()));
//            DepartmentDto departmentDto = departmentService.findById(Integer.valueOf(form.getDeptId()));
//            dto.setDepartment(departmentDto);
//            return dto;
//        } catch (ParseException ex) {
//            Logger.getLogger(EmployeeEditResource.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException("日付のフォーマットエラーです。", ex);
//        }
//        
//    }
}
