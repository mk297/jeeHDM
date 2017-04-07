package net.jees.ee.service;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import net.jees.ee.persistence.PersistenceManager;
import net.jees.ee.persistence.entities.Person;
import net.jees.ee.persistence.entities.Ticket;

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
	public boolean reservateSeat(int seat, int row, int personID) {
		final Person person = persistenceManager.loadObject(Person.class, personID);

		final Ticket ticket = new Ticket(row, seat);

		if (persistenceManager.persistObject(ticket)) {
			person.getTickets().add(ticket);

			return true;
		}

		return false;
	}

	/**
	 *
	 * @return All reservations.
	 */
	public Collection<Ticket> getReservations() {
		return persistenceManager.loadAll(Ticket.class);
	}
}