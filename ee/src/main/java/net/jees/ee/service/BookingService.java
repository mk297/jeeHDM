package net.jees.ee.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.jees.ee.persistence.PersistenceManager;
import net.jees.ee.persistence.entities.Person;

@Named(value = "bookingService")
@ApplicationScoped
public class BookingService {
	@Inject
	private PersistenceManager persistenceManager;

	/**
	 * @return All persons in the cinema system.
	 */
	public Collection<Person> getPersons() {
		return persistenceManager.loadAll(Person.class);
	}
}