package net.jees.ee.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.jees.ee.persistence.PersistenceManager;
import net.jees.ee.persistence.entities.Person;
import net.jees.ee.persistence.entities.Ticket;

@Named(value = "bookingService")
@ApplicationScoped
public class BookingService {
	@Inject
	private PersistenceManager persistenceManager;

	/**
	 * Reservate a seat for a given person.
	 * 
	 * @param seat
	 *          The seat number.
	 * @param row
	 *          The number of the row where the seat is located at.
	 * @param personID
	 *          The id of the person booking the seat.
	 * @return <code>true</code> if the seat was booked successfully, or
	 *         <code>false</code> if the seat was already taken.
	 */
	public boolean bookMovie(int seat, int row, int personID) {
		final Person person = persistenceManager.loadObject(Person.class, personID);

		final Ticket ticket = new Ticket(row, seat);

		if (null != person) {
			person.getTickets().add(ticket);

			persistenceManager.persistObject(person);

			return true;
		}

		return false;
	}

	public boolean createPerson(String preName, String surName) {
		final Person person = new Person(preName, surName);

		return persistenceManager.persistObject(person);
	}

	public boolean deletePerson(int personID) {
		final Person person = persistenceManager.loadObject(Person.class, personID);

		if (null == person)
			return false;

		return persistenceManager.deleteObject(person);
	}

	/**
	 *
	 * @return All reservations.
	 */
	public Collection<Ticket> getReservations() {
		List<Ticket> reservations = (List<Ticket>) persistenceManager.loadAll(Ticket.class);

		sortForRowsAndSeats(reservations);

		return reservations;
	}

	/**
	 * 
	 * @return All persons in the cinema system.
	 */
	public Collection<Person> getPersons() {
		return persistenceManager.loadAll(Person.class);
	}

	/**
	 * Sorts the list such that the tickets with the smallest row are at top. As
	 * the row equals the smallest seat will be the highest.
	 * 
	 * @param reservations
	 *          The list of reservations to sort.
	 */
	private void sortForRowsAndSeats(List<Ticket> reservations) {
		Collections.sort(reservations, new Comparator<Ticket>() {
			@Override
			public int compare(Ticket o1, Ticket o2) {
				if (o1.getRow() > o2.getRow())
					return 1;
				else if (o1.getRow() == o2.getRow())
					if (o1.getSeat() > o2.getSeat())
						return 1;
					else if (o1.getSeat() == o2.getSeat())
						return 0;
					else
						return -1;
				else
					return -1;
			}

		});
	}
}