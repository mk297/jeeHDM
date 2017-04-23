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

@Path("/booking")
public class BookingEndpoint {
	@Inject
	private BookingService bookingService;

	
	//-- Aufgabe 1 --- 
	//Um neue Kinobesucher anlegen zu können, soll die "POST"-Methode createPerson() realisiert werden. 
	//Diese soll auf den relativen Pfad /booking/createPerson gemapped werden.
	//Als Parameter soll der Vorname "preName" und Nachname "surName" (String) als Form-Parameter übergeben werden. 
	//Als Response soll eine Erfolgsmeldung der gerade angelegten Person an den Client zurückgegeben werden. 
	//Tipp: Verwende die Funktion createPerson(...) der bereitstehenden Klasse BookingService und die Funktion jsonfySuccessAnswer(...) der Klasse JsonHelper aus dem Package json.  
	//----------------
	
	
	//Code here
	
	//-- Aufgabe 2 --- 
	//Um einen Platz zu reservieren, soll die "POST"-Methode bookSeat() realisiert werden. 
	//Diese soll auf den root gemapped werden.
	//Als Parameter soll die Sitznummer "seat" und "row" (Integer) als Form-Parameter übergeben werden.
	//Des Weiteren soll eine "personID" (Integer) benötigt, damit Tickets einer Person zugeordnet werden kann.
	//Als Response soll eine Erfolgsmeldung des gerade reservierten Tickets an den Client zurückgegeben werden.  
	//----------------
	
	//Code here

	
	
	//-----------------------------
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getReservations() {
		System.out.println("get");
		return JsonHelper.jsonfyReservations(bookingService.getReservations());
	}
	
	@POST
	@Path(value = "/deletePerson")
	@Produces(MediaType.APPLICATION_JSON)
	public String deletePerson(@FormParam(value = "personID") int personID) {
		return JsonHelper.jsonfySuccessAnswer(bookingService.deletePerson(personID));
	}
	
}
