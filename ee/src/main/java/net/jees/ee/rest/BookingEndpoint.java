package net.jees.ee.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.jees.ee.json.JsonHelper;
import net.jees.ee.service.BookingService;

@Path(value = "/booking")
public class BookingEndpoint {
	@Inject
	private BookingService bookingService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String bookSeat(@QueryParam(value = "seat") int seat, @QueryParam(value = "row") int row,
			@QueryParam(value = "personID") int personID) {
		return JsonHelper.jsonfySuccessAnswer(bookingService.bookSeat(seat, row, personID));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getReservations() {
		return JsonHelper.jsonfyReservations(bookingService.getReservations());
	}
}
