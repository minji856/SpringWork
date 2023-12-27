package io.acorn.model; 

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {
	@Builder
	public Users(String username, String password, String email, String role, Timestamp createDate, String provider,
			String providerId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.createDate = createDate;
		this.provider = provider;
		this.providerId = providerId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
	private Timestamp createDate;
	private String provider;
	private String providerId;
}
