package com.codeexample.springbootrestapi.repositories;

import com.codeexample.springbootrestapi.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
/*Jpa Repository is Implemented by a Concrete Class called SimpleJpaRepository which provides implementations
Methods such as deleteAll, CreateNew, deletebyId etc. So we don't need to define these implementations again. */
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {


}
