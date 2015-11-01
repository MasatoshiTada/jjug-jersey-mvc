package com.example.rest.form;

import javax.ws.rs.FormParam;

/**
 *
 * @author tada
 */
public class EmployeeEditForm {

    @FormParam("empId")
    private String empId;
    
    @FormParam("name")
    private String name;
    
    @FormParam("joinedDate")
    private String joinedDate;

    @FormParam("deptId")
    private String deptId;

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the joinedDate
     */
    public String getJoinedDate() {
        return joinedDate;
    }

    /**
     * @param joinedDate the joinedDate to set
     */
    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "EmployeeEditForm{" + "empId=" + empId + ", name=" + name + ", joinedDate=" + joinedDate + ", deptId=" + deptId + '}';
    }
    
}
