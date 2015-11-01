package com.example.service;

import com.example.persistence.dao.EmployeeDao;
import com.example.persistence.entity.Department;
import com.example.persistence.entity.Employee;
import com.example.rest.dto.EmployeeDto;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author tada
 */
@Dependent
public class EmployeeService implements Serializable {
    
    @Inject
    private EmployeeDao employeeDao;
    
    @Transactional(Transactional.TxType.REQUIRED)
    public List<EmployeeDto> findAll() {
        return convertToDtoList(employeeDao.findAll());
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public EmployeeDto findByEmpId(Integer empId) {
        return convertToDto(employeeDao.findByEmpId(empId));
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public List<EmployeeDto> findByName(String nameKey) {
        return convertToDtoList(employeeDao.findByName(nameKey));
//        throw new RuntimeException("ERROR IN SERVICE!!!");
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee insert(EmployeeDto employeeDto) {
        return employeeDao.insert(convertToEntity(employeeDto));
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Employee update(EmployeeDto employeeDto) {
        return employeeDao.update(convertToEntity(employeeDto));
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Integer delete(Integer empId) {
        return employeeDao.deleteByEmpId(empId);
    }
    
    private EmployeeDto convertToDto(Employee entity) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmpId(entity.getEmpId());
        dto.setName(entity.getName());
        dto.setJoinedDate(entity.getJoinedDate());
        dto.getDepartment().setDeptId(entity.getDepartment().getDeptId());
        dto.getDepartment().setName(entity.getDepartment().getName());
        return dto;
    }
    
    private List<EmployeeDto> convertToDtoList(List<Employee> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    
    private Employee convertToEntity(EmployeeDto dto) {
        Employee entity = new Employee();
        entity.setEmpId(dto.getEmpId());
        entity.setName(dto.getName());
        entity.setJoinedDate(dto.getJoinedDate());
        Department department = new Department();
        department.setDeptId(dto.getDepartment().getDeptId());
        department.setName(dto.getDepartment().getName());
        entity.setDepartment(department);
        return entity;
    }
    
}
