package com.restSpring.msscbrewery.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Beer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
	private UUID id;
	
	@Version
	private Integer version;
	
	@CreationTimestamp
	@Column(updatable = false)
	private Timestamp createdDate;
	
	@UpdateTimestamp
	private Timestamp lastModifiedDate;
	
	private String beerName;
	private String beerStyle;
	
	@Column(unique = true)
	private String upc;
	
	private BigDecimal price;
	
	private Integer minOnHand;
	private Integer quantityToBrew;
}
