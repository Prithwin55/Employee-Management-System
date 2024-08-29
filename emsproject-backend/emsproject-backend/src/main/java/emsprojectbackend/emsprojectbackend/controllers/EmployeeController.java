package emsprojectbackend.emsprojectbackend.controllers;

import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;
import emsprojectbackend.emsprojectbackend.entity.Employee;
import emsprojectbackend.emsprojectbackend.mapper.EmployeeMapper;
import emsprojectbackend.emsprojectbackend.service.EmployeeService;
import emsprojectbackend.emsprojectbackend.service.impl.EmployeeServiceimpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedemployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id)
    {
        System.out.println(id);
        EmployeeDto employee =employeeService.getEmployeeById(id);
        System.out.println(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
       List<EmployeeDto> empDto= employeeService.getAllEmployees();
       return new ResponseEntity<>(empDto,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empId,@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto updateEmployee=employeeService.updateEmployee(empId, employeeDto);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);

    }

    @DeleteMapping("{id}")

    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("EmployeeDELETED");
    }

}
