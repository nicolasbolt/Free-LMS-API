package com.nicolasbolt.lmsapi.controllers;

import com.nicolasbolt.lmsapi.models.Course;
import com.nicolasbolt.lmsapi.services.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> findAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        coursesService.findAllCourses().forEach(courses::add);

        return courses;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Course findById(@PathVariable Long id) {
        return coursesService.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course) {
        coursesService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        coursesService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteCourse(@PathVariable Long id) {
        coursesService.deleteCourse(coursesService.findById(id).get());
    }
}
