package io.acorn.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
	// Oracle에선 SEQUENCE라고 지정
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userId;
	private String firstname;
	private String lastname;
	private int age;	
	private LocalDateTime startDate;
	private boolean active;
}
