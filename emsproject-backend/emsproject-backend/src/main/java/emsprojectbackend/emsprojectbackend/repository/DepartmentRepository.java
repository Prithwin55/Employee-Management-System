package emsprojectbackend.emsprojectbackend.repository;

import emsprojectbackend.emsprojectbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
