package com.example.demo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnrolmentId implements Serializable{

	@Column(name = "student_id")
	private Long studentId;
	@Column(name ="course_id")
	private Long courseId;
	
	
	public EnrolmentId() {
		
	}


	public EnrolmentId(Long studentId, Long courseId) {
		
		this.studentId = studentId;
		this.courseId = courseId;
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public Long getCourseId() {
		return courseId;
	}


	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(courseId, studentId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrolmentId other = (EnrolmentId) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(studentId, other.studentId);
	}
	
	
	
}
