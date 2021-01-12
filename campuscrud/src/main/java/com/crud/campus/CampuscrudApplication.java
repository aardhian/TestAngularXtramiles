package com.crud.campus;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.crud.campus.model.Student;
import com.crud.campus.repository.StudentRepository;

@SpringBootApplication
public class CampuscrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CampuscrudApplication.class, args);
	}

	@Bean
	ApplicationRunner init(StudentRepository studentRepo) {
		// Populate some of students
		
		return args -> {
			
			Stream.of(new Student("00001", "Name 1", "a@email.com"),
					new Student("00002", "Name 2","b@email.com")).forEach(student->{
						studentRepo.save(student);
			});
			
			studentRepo.findAll().forEach(System.out::println);
		};
	}
}
