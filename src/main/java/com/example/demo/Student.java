package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name="Student")
@Table(name = "student", uniqueConstraints = { @UniqueConstraint(columnNames = "email", name = "student_email_unique") })
public class Student {

	@Id
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequency", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	@Column(name = "id", updatable = false)
	private Long id;
	@Column(name = "email", columnDefinition = "TEXT", nullable = false)
	private String email;

	@Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
	private String firstName;
	@Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
	private String lastName;

	@Column(name = "age", nullable = false)
	private Integer age;

	public Student() {

	}

	public Student( String email, String firstName, String lastName, Integer age) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}

}
