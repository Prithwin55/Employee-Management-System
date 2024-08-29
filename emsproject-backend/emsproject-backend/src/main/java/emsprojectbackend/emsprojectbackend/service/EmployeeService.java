package emsprojectbackend.emsprojectbackend.service;

import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getEmployeeById(Long employeeId);

    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);

    public void deleteEmployee(Long employeeId);

}
