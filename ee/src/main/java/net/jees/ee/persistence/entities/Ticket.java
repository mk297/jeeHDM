package net.jees.ee.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + row;
		result = prime * result + seat;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (row != other.row)
			return false;
		if (seat != other.seat)
			return false;
		return true;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
}
