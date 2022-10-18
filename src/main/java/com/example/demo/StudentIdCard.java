package com.example.demo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "StudentIdCard")
@Table(name = "student_id_card", uniqueConstraints = {
		@UniqueConstraint(columnNames = "card_number", name = "student_id_card_Number_unique") })
public class StudentIdCard {

	@Id
	@SequenceGenerator(name = "student_id_card_sequence", sequenceName = "student_id_card_sequency", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_card_sequence")
	@Column(name = "id", updatable = false)
	private Long id;

	@Column(name = "card_number", nullable = false, length = 15)
	private String cardNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id",referencedColumnName = "id")
	private Student student;

	public StudentIdCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public StudentIdCard() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "StudentIdCard [id=" + id + ", cardNumber=" + cardNumber + "]";
	}
	

}
