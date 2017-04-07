package net.jees.ee.persistence.entities.pk;

public class TicketId implements CompositePrimaryKey {
	private int row;
	private int seat;

	public TicketId() {}

	public TicketId(int row, int seat) {
		this.row = row;
		this.seat = seat;
	}
}
