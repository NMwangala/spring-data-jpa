package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

	@Id
	@SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
	@Column(name = "id", updatable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "student_id",referencedColumnName = "id",foreignKey = @ForeignKey(name="student_book_fk"),nullable = false)
	private Student student;
	@Column(name="book_name",nullable = false)
	private String bookName;
	@Column(nullable = false,name="created_at",columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private LocalDateTime createdAt;
	public Book() {
		
	}
	public Book(Student student, String bookName, LocalDateTime createdAt) {

		this.student = student;
		this.bookName = bookName;
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", student=" + student + ", bookName=" + bookName + ", createdAt=" + createdAt + "]";
	}
	
	
}
