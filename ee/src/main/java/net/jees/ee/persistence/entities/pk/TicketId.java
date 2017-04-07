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
}
