package com.example.rest.dto.cdi;

import com.example.persistence.entity.Employee;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * コントローラーからビューに値を渡すDTOです。
 * @author tada
 */
@Named
@RequestScoped
public class EmployeeListDto {
    private List<Employee> employeeList;

    /**
     * @return the employeeList
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * @param employeeList the employeeList to set
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
