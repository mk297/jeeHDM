package net.jees.ee.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import net.jees.ee.persistence.entities.pk.TicketId;

@Entity
@IdClass(TicketId.class)
public class Ticket {
	@Id
	private int row;
	@Id
	private int seat;

	private String movieName;

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Ticket() {
	};

	public Ticket(int row, int seat, String movieName) {
		this.row = row;
		this.seat = seat;
		this.movieName = movieName;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
}
