package net.jees.ee.persistence;

import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import net.jees.ee.persistence.entities.Person;
import net.jees.ee.persistence.entities.Ticket;

@RequestScoped
public class PersistenceManager {
	/**
	 * Database stub. Returns a list of persons. 
	 * 
	 * @param domainClass The class to load. Only {@link Person}.class is allowed.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> Collection<T> loadAll(Class<T> domainClass) {
		if (Person.class.equals(domainClass) == false)
			throw new IllegalArgumentException("Accepting only persons, you've provided a " + domainClass.getSimpleName());
		
		final Collection<T> persons = new ArrayList<>();
		
		final Person ePerson = new Person("Elisabeth","Blumenbeet");
		ePerson.setId(1);
		ePerson.getTickets().add(new Ticket(2, 4));
		ePerson.getTickets().add(new Ticket(3,4));
		persons.add((T) ePerson);
		
		final Person sPerson = new Person("San","Eisenbahn");
		sPerson.setId(2);
		sPerson.getTickets().add(new Ticket(5,4));
		persons.add((T) sPerson);
		
		final Person mPerson = new Person("Max","Keinmustermann");
		mPerson.setId(3);
		mPerson.getTickets().add(new Ticket(1,2));
		persons.add((T) mPerson);
		
	 return persons;
	}
}
