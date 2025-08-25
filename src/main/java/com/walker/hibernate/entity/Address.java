package com.walker.hibernate.entity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Address {

	private String city;
	private String state;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "number", column = @Column(name = "address_street_number")),
	    @AttributeOverride(name = "name", column = @Column(name = "address_street_name"))
	})
	private Street street;

}
