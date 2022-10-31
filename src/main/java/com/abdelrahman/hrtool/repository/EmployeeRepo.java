package com.abdelrahman.hrtool.repository;

import com.abdelrahman.hrtool.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
}
