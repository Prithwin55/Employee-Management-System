package emsprojectbackend.emsprojectbackend.service.impl;

import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;
import emsprojectbackend.emsprojectbackend.entity.Employee;
import emsprojectbackend.emsprojectbackend.exception.ResourceNotFoundException;
import emsprojectbackend.emsprojectbackend.mapper.EmployeeMapper;
import emsprojectbackend.emsprojectbackend.repository.EmployeeRepository;
import emsprojectbackend.emsprojectbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {


    public EmployeeRepository employeerepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapTOEmployee(employeeDto);
        Employee saved=employeerepository.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeerepository.findById(employeeId).
                orElseThrow(()->new ResourceNotFoundException("Employee Not Found"+employeeId));
        return EmployeeMapper.mapTOEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee>employees=employeerepository.findAll();
        List<EmployeeDto> empdto=employees.stream().map((emp)->EmployeeMapper.mapTOEmployeeDto(emp)).collect(Collectors.toList());
        return empdto;
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeerepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Id not found"+employeeId));
        employee.setFname(updatedEmployee.getFname());
        employee.setLname(updatedEmployee.getLname());
        employee.setEmail(updatedEmployee.getEmail());
        Employee updatedemployee=employeerepository.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeerepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Not Found employee ID"+employeeId));
        employeerepository.deleteById(employeeId);
    }
}
