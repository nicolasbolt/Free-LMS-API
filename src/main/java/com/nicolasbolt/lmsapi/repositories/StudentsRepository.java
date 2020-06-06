package com.nicolasbolt.lmsapi.repositories;

import com.nicolasbolt.lmsapi.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Student, Long> {
}
