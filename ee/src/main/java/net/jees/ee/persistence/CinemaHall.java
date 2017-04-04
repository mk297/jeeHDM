package net.jees.ee.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representation of a cinema hall.
 *
 */
@Entity
@Table
public class CinemaHall {
	@Id
	private int id;

	/**
	 * The matrix of all seats in a hall.
	 */
	private Person[][] seats;

	/**
	 * Obtains the current {@link Person} at the specified seat number on the
	 * given row.
	 * 
	 * @param row
	 *          The row the seat is located at, starting with 0.
	 * @param seatNumber
	 *          The number of the seat, starting with 0.
	 * @return The person at the specified position.
	 * @throws IllegalArgumentException
	 *           If a invalid seat position was specified.
	 */
	public synchronized Person getPersonAtSeat(int row, int seatNumber) {
		if (1 > row && row > seats.length)
			throw new IllegalArgumentException("There is no row " + row);
		if (1 > seatNumber && seatNumber > seats[0].length)
			throw new IllegalArgumentException("There is no seat " + seatNumber + " in given row " + row);

		return seats[row][seatNumber];
	}

	/**
	 * Places a {@link Person} on a seat in a given row.
	 * 
	 * @param row
	 *          The row the seat is located at, starting with 0.
	 * @param seatNumber
	 *          The number of the seat, starting with
	 * @param person
	 *          The person to place.
	 * @return <code>true</code> if the person was successfuly placed, or
	 *         <code>false</code> if the place was already occupied.
	 */
	public synchronized boolean placePerson(int row, int seatNumber, Person person) {
		if (1 > row && row > seats.length)
			throw new IllegalArgumentException("There is no row " + row);
		if (1 > seatNumber && seatNumber > seats[0].length)
			throw new IllegalArgumentException("There is no seat " + seatNumber + " in given row " + row);

		if (null != seats[row][seatNumber])
			return false;

		seats[row][seatNumber] = person;
		return true;
	}
}
