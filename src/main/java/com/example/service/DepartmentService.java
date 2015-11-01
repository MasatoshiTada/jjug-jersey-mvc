package com.example.service;

import com.example.persistence.dao.DepartmentDao;
import com.example.persistence.entity.Department;
import com.example.rest.dto.DepartmentDto;
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
public class DepartmentService implements Serializable {
    
    @Inject
    private DepartmentDao departmentDao;

    @Transactional(Transactional.TxType.REQUIRED)
    public List<DepartmentDto> findAll() {
        return convertToDtoList(departmentDao.findAll());
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public DepartmentDto findById(Integer deptId) {
        Department entity = departmentDao.findById(deptId);
        return entity == null ? null : convertToDto(entity);
    }
    
    private DepartmentDto convertToDto(Department entity) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDeptId(entity.getDeptId());
        dto.setName(entity.getName());
        return dto;
    }
    
    private List<DepartmentDto> convertToDtoList(List<Department> entityList) {
        return entityList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
