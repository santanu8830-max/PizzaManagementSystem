package com.pizzamanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

	private String customerName;
	private Long customerMobile;
	private String customerEmail;
	private String customerAddress;
}
