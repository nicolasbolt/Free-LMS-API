package com.nicolasbolt.lmsapi.repositories;

import com.nicolasbolt.lmsapi.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
