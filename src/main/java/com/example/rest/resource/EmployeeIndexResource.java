package com.example.rest.resource;

import com.example.persistence.entity.Employee;
import com.example.rest.dto.cdi.EmployeeListDto;
import com.example.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
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
    private EmployeeListDto employeeListDto;
    
    @GET
    @Path("index")
    public Viewable index() throws Exception {
        List<Employee> employeeList = employeeService.findByName("");
        employeeListDto.setEmployeeList(employeeList);
        // TODO: 演習1-3. index.jspに遷移する
        return null;
    }
    
    @GET
    @Path("findByName")
    // TODO: 演習2. バリデーションエラー時にindex.jspに遷移する
    
    public Viewable findByName(@QueryParam("name") @DefaultValue("") 
            @Pattern(regexp = "[a-zA-Z\\s]*", message = "{employee.name.pattern.alphabet.or.space}")
            @Size(max = 10, message = "{employee.name.size.string}")
            String name) throws Exception {
        List<Employee> employeeList = employeeService.findByName(name);
        employeeListDto.setEmployeeList(employeeList);
        return new Viewable("index");
//        throw new Exception("コントローラーで例外"); // 例外発生時は、@ErrorTemplateで指定したindex画面に遷移する
    }
    
    /**
     * [at]ErrorTemplateを指定していないので、
     * 例外はExceptionMapperがキャッチして、例外画面に遷移する
     * @throws Exception 
     */
    @GET
    @Path("throwRuntimeException")
    public void throwRuntimeException() throws Exception {
        throw new RuntimeException("実行時例外が発生しました。");
    }
    
    /**
     * [at]ErrorTemplateを指定していないので、
     * 例外はExceptionMapperがキャッチして、例外画面に遷移する
     * @throws Exception 
     */
    @GET
    @Path("throwIOException")
    public void throwIOException() throws Exception {
        throw new IOException("入出力例外が発生しました。");
    }
}
