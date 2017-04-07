package net.jees.ee.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.jees.ee.persistence.Ticket;

//Testklasse um Datenbankfunktionalität zu überprüfen
public class MainTest {
	private static final String PERSISTENCE_UNIT_NAME = "eclipselink";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) {
		System.out.println("start");
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("Select s from Ticket s");
		List<Ticket> allTickets = q.getResultList();			
		System.out.println(" -- ID -- ROWNUMBER -- SEATNUMBER");
		for(Ticket ticket : allTickets){
			if(ticket.getRow() == 1 && ticket.getSeat() == 1){
			System.out.println("    " + ticket.getId() + "        " + ticket.getRow() + "            " + ticket.getSeat());
			}
		}
		System.out.println("Size: " + allTickets.size());
		em.getTransaction().begin();
		em.flush();
		//create seats (rather cinema with 10x10 seats)
		for (int i = 1; i < 11; i++){
			for(int j = 1; j < 11; j++){
				Ticket ticket = new Ticket();
				ticket.setRow(i);
				ticket.setSeat(j);
				em.persist(ticket);
			}
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
