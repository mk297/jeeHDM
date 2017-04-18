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

	public Ticket() {
	};

	public Ticket(int row, int seat) {
		this.row = row;
		this.seat = seat;
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
