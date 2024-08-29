package emsprojectbackend.emsprojectbackend.service.impl;

import emsprojectbackend.emsprojectbackend.dto.DepartmentDto;
import emsprojectbackend.emsprojectbackend.entity.Department;
import emsprojectbackend.emsprojectbackend.exception.ResourceNotFoundException;
import emsprojectbackend.emsprojectbackend.mapper.DepartmentMapper;
import emsprojectbackend.emsprojectbackend.mapper.EmployeeMapper;
import emsprojectbackend.emsprojectbackend.repository.DepartmentRepository;
import emsprojectbackend.emsprojectbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceimpl implements DepartmentService {
    DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto createdepartment(DepartmentDto departmentDto) {
        Department dept= DepartmentMapper.mapToDepartment(departmentDto);
        Department saveddept=departmentRepository.save(dept);
        return DepartmentMapper.mapToDepartmentDto(saveddept);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List<Department> dept= departmentRepository.findAll();
        List<DepartmentDto> deptdto=dept.stream().map((e)->DepartmentMapper.mapToDepartmentDto(e)).collect(Collectors.toList());
        return  deptdto;
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department dept= departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));

        return DepartmentMapper.mapToDepartmentDto(dept);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        Department dept= departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));

        DepartmentDto deptdto=DepartmentMapper.mapToDepartmentDto(dept);

        deptdto.setDname(departmentDto.getDname());
        deptdto.setDdesc(departmentDto.getDdesc());

        Department deptsaved= departmentRepository.save(DepartmentMapper.mapToDepartment(deptdto));

        return DepartmentMapper.mapToDepartmentDto(deptsaved);
    }

    @Override
    public String deleteDepartment(Long id) {
        Department dept= departmentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
        departmentRepository.deleteById(id);
        return "Deleted";
    }

}
