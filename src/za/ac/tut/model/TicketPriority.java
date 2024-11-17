package za.ac.tut.model;

public class TicketPriority extends Priority {
    private int ticketID;

    public TicketPriority(int ticketID, int priorityId, String priorityName, int slaTime) {
        super(priorityId, priorityName, slaTime);
        this.ticketID = ticketID;
    }

    public TicketPriority(int ticketID, String priorityName, int sla) {
        super(priorityName, sla);
        this.ticketID = ticketID;
    }

    public TicketPriority(int ticketID, String name) {
        super(name);
        this.ticketID = ticketID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
}