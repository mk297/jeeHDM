package net.jees.ee.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import net.jees.ee.persistence.Ticket;

@ApplicationScoped
public class BookingService {

	/**
	 * Book a seat for a given person.
	 * 
	 * @param seat
	 *            The seat number.
	 * @param row
	 *            The number of the row where the seat is located at.
	 * @param personID
	 *            The id of the person booking the seat.
	 * @return <code>true</code> if the seat was booked successfully, or
	 *         <code>false</code> if the seat was already taken.
	 */
	public boolean bookSeat(int seat, int row, int personID) {
		return false;
	}

	/**
	 *
	 * @return All reservations.
	 */
	public List<Ticket> getReservations() {
		
		return null;
	}
}