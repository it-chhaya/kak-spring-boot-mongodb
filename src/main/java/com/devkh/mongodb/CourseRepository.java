package com.devkh.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {

    List<Course> findByTitleContainsIgnoreCase(String title);

}
