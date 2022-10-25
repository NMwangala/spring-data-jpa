package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "Enrolment")
@Table(name = "enrolment")
public class Enrolment {

	@EmbeddedId
	private EnrolmentId id;

	@ManyToOne
	@MapsId("studentId")
	@JoinColumn(name = "student_id",foreignKey = @ForeignKey(name="enrolment_student_id_fk"))
	private Student student;

	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id",foreignKey = @ForeignKey(name="enrolment_course_id_fk"))
	private Course course;

	@Column(nullable = false, name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime createdAt;

	public Enrolment() {

	}

	public Enrolment(EnrolmentId id, Student student, Course course, LocalDateTime createdAt) {
		this.createdAt = createdAt;
		this.id = id;
		this.student = student;
		this.course = course;
	}

	public Enrolment(Student student, Course course, LocalDateTime createdAt) {
		this.createdAt = createdAt;
		this.student = student;
		this.course = course;
	}

	public EnrolmentId getId() {
		return id;
	}

	public void setId(EnrolmentId id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	
}
