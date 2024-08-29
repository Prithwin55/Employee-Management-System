package emsprojectbackend.emsprojectbackend.service;

import emsprojectbackend.emsprojectbackend.dto.DepartmentDto;
import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;

import java.util.List;

public interface DepartmentService {

    public DepartmentDto createdepartment(DepartmentDto departmentDto);

    List<DepartmentDto> getAllDepartment();

    public DepartmentDto getDepartmentById(Long id);

    public DepartmentDto updateDepartment(Long id,DepartmentDto departmentDto);

    public String deleteDepartment(Long id);
}
