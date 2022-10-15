package com.example.demo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			Student maria = new Student("maria.jones@gmail.com", "Maria", "Jones", 20);
			Student ahmed = new Student("ahmed.ali@gmail.com", "Ahmed", "Ali", 16);
			
			System.out.println("Adding students");
			studentRepository.saveAll(List.of(maria, ahmed));

			System.out.println("Number of students");
			System.out.println(studentRepository.count());

			System.out.println("Fetching students");
			studentRepository.findById(2L).ifPresentOrElse(student -> {
				System.out.println(student);
			}, () -> System.out.println("Student with ID 2 not found"));
			
			
			studentRepository.findById(3L).ifPresentOrElse(student -> {
				System.out.println(student);
			}, () -> System.out.println("Student with ID 3 not found"));
			
			System.out.println("Fetching all students");
			List<Student> student = studentRepository.findAll();
			
			student.forEach(System.out::println);
			
			studentRepository.deleteById(1L);
			System.out.println("Number of students");
			System.out.println(studentRepository.count());
			
			System.out.println("=================");
			
			studentRepository.findStudentByEmail("ahmed.ali@gmail.com").ifPresentOrElse(System.out::println, ()-> 
				
			System.out.println("Student with ID 3 not found"));
		};
	}
}
