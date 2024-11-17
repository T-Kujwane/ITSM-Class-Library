package za.ac.tut.model;

import java.util.Date;

public final class Ticket {
    public Ticket(){}
    
    public enum Status {
        OPEN,
        IN_PROGRESS,
        ESCALATED,
        RESOLVED,
        CLOSED
    }

    private int ticketId;
    private String title;
    private String description;
    private String status;
    private int createdBy;
    private int assignedTo;
    private Date createdAt;
    private Date updatedAt;
    private TicketPriority priority;
    
    // Constructor
    public Ticket(int ticketId, String title, String description, String status, int createdBy, int assignedTo, Date createdAt, Date updatedAt) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, Priority.Level.LOW.toString());
    }
    
    public Ticket(int ticketId, String title, String description, String status, int createdBy, int assignedTo, Date createdAt, Date updatedAt, String priority) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, priority);
    }
    
    public Ticket(String title, String description, String status, int userId) {
        setTitle(title);
        setDescription(description);
        setStatus(status);
        setCreatedBy(userId);
    }

    // Getters and Setters
    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }

    public int getAssignedTo() { return assignedTo; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = assignedTo; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }
    
}
