package com.aruparking.Dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PARKING_USERS")
@NamedQuery(name = "ParkingUsers.findAll", query = "SELECT t FROM ParkingUsers t")
public class ParkingUsers {
	
	 
		@Id
		@Column(name = "USER_ID")
		private long userId;
		
		@Column(name = "FIRST_NAME")
		private String firstName;
	
		@Column(name = "LAST_NAME")
		private String lastName;

		@Column(name = "EMAIL_ID")
		private String emailId;
		
		@Column(name = "GENDER")
		private String gender;
	
		@Column(name = "DOB")
		private Date dob;
		
		@Column(name = "BALANCE")
		private BigDecimal balance;

		
		
		public ParkingUsers() {
			super();
			
		}

		public long getUserId() {
			return userId;
		}

		public void setUserId(long userId) {
			this.userId = userId;
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

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		
		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public BigDecimal getBalance() {
			return balance;
		}

		public void setBalance(BigDecimal balance) {
			this.balance = balance;
		}

		
		
		
		
		
		

}
