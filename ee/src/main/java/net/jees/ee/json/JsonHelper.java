package net.jees.ee.json;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import net.jees.ee.persistence.Ticket;

public class JsonHelper {
	/**
	 * Encodes the reserved ticket into a JSON format as follows: <br>
	 * It contains an array called "reservations". Each array element represents
	 * a reserved seat in a row.
	 * <p>
	 * Example: <code>
	 * {"reservations": [{"row": 7,"seat": 1}, 
	 * 					 {"row": 2,"seat": 3},
	 *                    ...]}
	 * </code>
	 *
	 * @param reservedTickets
	 *            The list of all reservations.
	 * @return The JSON form of the reservations.
	 */
	public static String jsonfyReservations(List<Ticket> reservedTickets) {
		final JsonObjectBuilder jsonContainerBuilder = Json.createObjectBuilder();
		final JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

		for (final Ticket ticket : reservedTickets) {
			final JsonObjectBuilder jsonReservationBuilder = Json.createObjectBuilder();

			jsonReservationBuilder.add("row", ticket.getRow());
			jsonReservationBuilder.add("seat", ticket.getSeat());

			jsonArrayBuilder.add(jsonReservationBuilder);
		}

		jsonContainerBuilder.add("reservations", jsonArrayBuilder);

		return jsonContainerBuilder.build().toString();
	}

	/**
	 * Encodes the reserved ticket into a JSON format as follows: <br>
	 * <p>
	 * Returns a single key - value mapping, whereas the key is "success" and
	 * the value the given boolean parameter.
	 * <p>
	 * Example: <code>{"success", true}</code>
	 * 
	 * @param hadSuccess
	 *            <code>true</code> if the operation succeeded, else
	 *            <code>false</code>
	 * @return The JSON form of the success indicator.
	 */
	public static String jsonfySuccessAnswer(boolean hadSuccess) {
		final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

		jsonBuilder.add("success", hadSuccess);

		return jsonBuilder.build().toString();
	}
}
