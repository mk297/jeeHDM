package net.jees.ee.persistence.entities.pk;

/**
 * A composite key for the {@link Ticket}-entity.
 *
 */
public class TicketId implements CompositePrimaryKey {
	private static final long serialVersionUID = 2281346042009842443L;
	
	private int row;
	private int seat;

	public TicketId() {}

	public TicketId(int row, int seat) {
		this.row = row;
		this.seat = seat;
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
		TicketId other = (TicketId) obj;
		if (row != other.row)
			return false;
		if (seat != other.seat)
			return false;
		return true;
	}
}
