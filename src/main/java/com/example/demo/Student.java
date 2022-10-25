package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email", name = "student_email_unique") })
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

	@OneToOne(mappedBy = "student", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private StudentIdCard studentIdCard;

	@OneToMany(mappedBy = "student", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Book> books = new ArrayList<>();

//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@JoinTable(name = "enrolment",
//	joinColumns = @JoinColumn(name = "student_id", foreignKey = @ForeignKey(name = "enrolment_student_id_fk")),
//			inverseJoinColumns = @JoinColumn(name = "course_id", foreignKey = @ForeignKey(name = "enrolment_course_id_fk")))
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, fetch = FetchType.LAZY
			,mappedBy = "student")
	private List<Enrolment> enrolments = new ArrayList<Enrolment>();

	@Column(name = "age", nullable = false)
	private Integer age;

	public void addBook(Book book) {
		if (!this.books.contains(book)) {
			this.books.add(book);
			book.setStudent(this);
		}
	}

	public void removeBook(Book book) {
		if (this.books.contains(book)) {
			this.books.remove(book);
			book.setStudent(null);
		}
	}
	
//	public void enrolToCourse(Course course) {
//	courses.add(course);
//	course.getStudents().add(this);
//	}
//	
//	public void unEnrolToCourse(Course course) {
//		courses.remove(course);
//		course.getStudents().remove(this);
//	}

	public Student() {

	}

	public Student(String email, String firstName, String lastName, Integer age) {
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

	public StudentIdCard getStudentIdCard() {
		return studentIdCard;
	}

	public void setStudentIdCard(StudentIdCard studentIdCard) {
		this.studentIdCard = studentIdCard;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}

	public List<Enrolment> getEnrolments() {
		return enrolments;
	}
	
	public void addEnrolment(Enrolment enrolment) {
		if(!enrolments.contains(enrolment)) {
			enrolments.add(enrolment);
		}
	}
	
	public void removeEnrolment(Enrolment enrolment) {
	//	if(enrolments.contains(enrolment)) {
			enrolments.remove(enrolment);
		//}
	}

	public void setEnrolments(List<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", studentIdCard=" + studentIdCard + ", books=" + books + ", age=" + age + "]";
	}

}
