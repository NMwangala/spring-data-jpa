package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Course")
@Table(name = "course")
public class Course {
	@Id
	@SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	@Column(name = "id", updatable = false)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "TEXT",name = "course_name")
	private String courseName;
	
	@Column(nullable = false, columnDefinition = "TEXT",name = "department")
	private String department;
	
	@OneToMany(mappedBy = "course",cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Enrolment> enrolments = new ArrayList<Enrolment>();

	public Course(String courseName, String department) {
		
		this.courseName = courseName;
		this.department = department;
	}

	public Course() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	
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
		return "Course [id=" + id + ", courseName=" + courseName + ", department=" + department + "]";
	}
	
	
}
