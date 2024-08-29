package emsprojectbackend.emsprojectbackend.controllers;

import emsprojectbackend.emsprojectbackend.dto.DepartmentDto;
import emsprojectbackend.emsprojectbackend.dto.EmployeeDto;
import emsprojectbackend.emsprojectbackend.entity.Department;
import emsprojectbackend.emsprojectbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin("*")
@AllArgsConstructor
public class DepartmentController {

    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
       DepartmentDto deptdto=departmentService.createdepartment(departmentDto);


       return new ResponseEntity<>(deptdto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getdeptbyid(@PathVariable("id") Long id)
    {
       DepartmentDto dept= departmentService.getDepartmentById(id);
       return ResponseEntity.ok(dept);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment()
    {
        List<DepartmentDto> response=departmentService.getAllDepartment();
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> updateemployee(@PathVariable Long id, @RequestBody DepartmentDto departmentDto)
    {
        DepartmentDto departmentDto1=departmentService.updateDepartment(id,departmentDto);
        return ResponseEntity.ok(departmentDto1);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id)
    {
       String s= departmentService.deleteDepartment(id);
       return ResponseEntity.ok(s);
    }
}
