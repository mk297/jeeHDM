package net.jees.ee.rest;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.jees.ee.json.JsonHelper;
import net.jees.ee.service.BookingService;

@Path(value = "/booking")
public class BookingEndpoint {
	@Inject
	private BookingService bookingService;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String bookSeat(@FormParam(value = "seat") int seat, @FormParam(value = "row") int row,
			@FormParam(value = "personID") int personID) {
		return JsonHelper.jsonfySuccessAnswer(bookingService.bookMovie(seat, row, personID));
	}

	@POST
	@Path(value="/person")
	@Produces(MediaType.APPLICATION_JSON)
	public String createPerson(@FormParam(value= "preName") String preName, @FormParam(value="surName") String surName) {
		return JsonHelper.jsonfySuccessAnswer(bookingService.createPerson(preName, surName));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getReservations() {
		System.out.println("get");
		return JsonHelper.jsonfyReservations(bookingService.getReservations());
	}
}
