package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("SELECT s FROM Student s WHERE s.email=?1")
	Optional<Student> findStudentByEmail(String email);

	List<Student> findStudentByFirstNameEqualsAndAgeEquals(String firstName, Integer age);

	@Query("SELECT s FROM Student s WHERE s.firstName=?1 AND s.age>?2")
	List<Student> findStudentByFirstNameEqualsAndAgeGreaterThanEqual(String firstName, Integer age);

	@Query(value = "SELECT * FROM student  WHERE first_name=?1 AND age>=?2", nativeQuery = true)
	List<Student> findStudentByFirstNameEqualsAndAgeGreaterThanEqualNative(String firstName, Integer age);

	@Query(value = "SELECT * FROM student  WHERE first_name =:firstName AND age>=:age", nativeQuery = true)
	List<Student> findStudentByFirstNameEqualsAndAgeGreaterThanEqualNativeParam(@Param("firstName") String firstName,
			@Param("age") Integer age);

	@Modifying
	@Transactional
	@Query("DELETE FROM Student s WHERE s.id=?1")
	int deleteStudentById(Long id);
}
