/*
 * Ü B U N G  
 * 1. Annotiere die Klasse Person als Entität.
 * 2. Erstelle eine ID-Variable, die du als Primary Key definierst und die automatisch inkrementiert wird.
 * 3. Erstelle je eine Variable, die den Vor- bzw. den Nachnamen der Person hält
 *    und lege einen Konstruktor an, der Vor- und Nachname als Parameter entgegennimmt.
 * 4. Lege eine OneToMany Relation zu einer Ticketliste an.
 * 5. Erstelle alle benötigten Getter und Setter.
 */

package net.jees.ee.persistence.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Represents a unique Person identified by the pre- and surname.
 *
 */

//1

public class Person {
	//2
	
	//3
	
	//4
	
	public Person() {
		// Required for JPA
	}
	
	//5 
	


}
