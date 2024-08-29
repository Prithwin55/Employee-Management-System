package emsprojectbackend.emsprojectbackend.mapper;

import emsprojectbackend.emsprojectbackend.dto.DepartmentDto;
import emsprojectbackend.emsprojectbackend.entity.Department;

public class DepartmentMapper {
    public static Department mapToDepartment(DepartmentDto departmentDto)
    {
        Department dept= new Department(
                departmentDto.getId(),
                departmentDto.getDname(),
                departmentDto.getDdesc());
        return dept;
    }

    public static DepartmentDto mapToDepartmentDto(Department department)
    {
        DepartmentDto dept= new DepartmentDto(
                department.getId(),
                department.getDname(),
                department.getDdesc());
        return dept;
    }
}
