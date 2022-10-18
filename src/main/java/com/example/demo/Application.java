package com.example.demo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.github.javafaker.Faker;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	void generateRandomStudents(StudentRepository studentRepository) {
		Faker faker = new Faker();
		
		for(int i=0; i<20; i++) {
			
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@amigoscode.edu", firstName,lastName);
			Integer age = faker.number().numberBetween(18, 55);
			Student student = new Student(email, firstName, lastName, age);
			studentRepository.save(student);
		}
		
		
	}
	
	void sorting(StudentRepository studentRepository) {
		// Sort sort = Sort.by(Direction.ASC, "firstName");
		 Sort sort = Sort.by( "firstName").ascending(). and(Sort.by("age")).descending();
		 studentRepository.findAll(sort).forEach(student->System.out.println(student.getFirstName() + " : " + student.getAge()));
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args -> {
			
			
//			 generateRandomStudents(studentRepository);
//			 
//			 PageRequest pageRequest = PageRequest.of(0, 10,Sort.by("firstName"));
//		Page<Student> page=	 studentRepository.findAll(pageRequest);
//		
//		System.out.println(page);
//		
		
			
//			Student maria = new Student("maria.jones@gmail.com", "Maria", "Jones", 20);
//			Student ahmed = new Student("ahmed.ali@gmail.com", "Ahmed", "Ali", 16);
//			
//			System.out.println("Adding students");
//			studentRepository.saveAll(List.of(maria, ahmed));
//
//			System.out.println("Number of students");
//			System.out.println(studentRepository.count());
//
//			System.out.println("Fetching students");
//			studentRepository.findById(2L).ifPresentOrElse(student -> {
//				System.out.println(student);
//			}, () -> System.out.println("Student with ID 2 not found"));
//			
//			
//			studentRepository.findById(3L).ifPresentOrElse(student -> {
//				System.out.println(student);
//			}, () -> System.out.println("Student with ID 3 not found"));
//			
//			System.out.println("Fetching all students");
//			List<Student> student = studentRepository.findAll();
//			
//			student.forEach(System.out::println);
//			
//			//studentRepository.deleteById(1L);
//			System.out.println("Number of students");
//			System.out.println(studentRepository.count());
//			
//			System.out.println("=================");
//			
//			studentRepository.findStudentByEmail("ahmed.ali@gmail.com").ifPresentOrElse(System.out::println, ()-> 
//				
//			System.out.println("Student with ID 3 not found"));
//			
//			studentRepository.findStudentByFirstNameEqualsAndAgeEquals("Ahmed", 16).forEach(System.out::println);
//			
//			studentRepository.findStudentByFirstNameEqualsAndAgeGreaterThanEqual("Ahmed", 15).forEach(System.out::println);
//			
//	System.out.println(" " +studentRepository.deleteStudentById(1L));
		};
	}
}
