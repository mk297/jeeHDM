package net.jees.ee.persistence.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a unique Person identified by the pre- and surname.
 *
 */
public class Person {
	private int id;

	private String preName;
	private String surName;

	private List<Ticket> tickets = new ArrayList<>();
	
	public Person() {}
	
	public Person(String preName, String surName) {
		this.preName = preName;
		this.surName = surName;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPreName() {
		return preName;
	}

	public void setPreName(String preName) {
		this.preName = preName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

}
