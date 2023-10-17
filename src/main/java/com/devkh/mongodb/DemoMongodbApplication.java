package com.devkh.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMongodbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoMongodbApplication.class, args);
    }

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        // Remove all documents in MongoDB
        courseRepository.deleteAll();

        // Create new document
        Course course = Course.builder()
                .title("Spring Framework")
                .description("Spring Framework Description")
                .rate(4.5F)
                .feedback("This best ever")
                .build();
        Course course2 = Course.builder()
                .title("Data Analytics")
                .description("Mom Reksmey")
                .rate(4F)
                .feedback("Greatest experience for me")
                .build();
        Course course3 = Course.builder()
                .title("Flutter Mobile Development")
                .description("Kit Tara as Instructor")
                .rate(4.5F)
                .feedback("The best of mobile app development")
                .build();

        courseRepository.save(course);
        courseRepository.save(course2);
        courseRepository.save(course3);

        // Test
        System.out.println("FOUND COURSE BY ID => " + courseRepository.findById(course2.getId()));
        System.out.println("FOUND COURSE BY KEYWORD => " + courseRepository.findByTitleContainsIgnoreCase("mobile"));

    }

}
