package org.dalpra.acme.person.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
public class Person extends PanacheEntity {
	
	public String firstname;
	public String lastname;
	public String username;
	public String email;
	
	public Person() {
	}
	
	public Person(String firstname, String lastname, String username, String email) {
		
	}
}