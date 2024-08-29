package emsprojectbackend.emsprojectbackend.mapper;

import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;
import emsprojectbackend.emsprojectbackend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapTOEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFname(),
                employee.getLname(),
                employee.getEmail());
    }

    public static Employee mapTOEmployee(EmployeeDto employeedto)
    {
        return new Employee(
                employeedto.getId(),
                employeedto.getFname(),
                employeedto.getLname(),
                employeedto.getEmail());
    }
}
