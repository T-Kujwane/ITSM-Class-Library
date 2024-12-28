package za.ac.tut.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public final class Ticket implements Comparable<Ticket>{
    public Ticket(){}

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(this.getTicketId(), o.getTicketId());
    }
    
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
    private User createdBy;
    private User assignedTo;
    private User escalatedTo;
    private Date createdAt;
    private Date updatedAt;
    private TicketPriority priority;
    private List<TicketUpdate> ticketUpdates;
    
    // Constructor
    public Ticket(int ticketId, String title, String description, String status, User createdBy, User assignedTo, User escalatedTo, Date createdAt, Date updatedAt) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, Priority.Level.LOW.toString());
        initializeUpdatesList();
        setEscalatedTo(escalatedTo);
    }

    private void initializeUpdatesList() {
        this.ticketUpdates = new ArrayList<>();
    }

    public Ticket(int ticketId, String title, String description, String status, User createdBy, User assignedTo,User escalatedTo, Date createdAt, Date updatedAt, TicketPriority priority, List<TicketUpdate> ticketUpdates) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = priority;
        this.ticketUpdates = ticketUpdates;
        setEscalatedTo(escalatedTo);
    }
    
    public Ticket(int ticketId, String title, String description, String status, User createdBy, User assignedTo, User escalatedTo, Date createdAt, Date updatedAt, String priority) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = assignedTo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, priority);
        initializeUpdatesList();
        setEscalatedTo(escalatedTo);
    }
    
    public Ticket(String title, String description, String status, User creator) {
        setTitle(title);
        setDescription(description);
        setStatus(status);
        setCreatedBy(creator);
        initializeUpdatesList();
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

    public User getCreatedBy() { return createdBy; }
    public void setCreatedBy(User createdBy) { this.createdBy = createdBy; }

    public User getAssignedTo() { return assignedTo; }
    
    public void setAssignedTo(User assignedTo) {this.assignedTo = assignedTo;}

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.ticketId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        return this.ticketId == other.ticketId;
    }
    
    public void addUpdate(TicketUpdate update){
        this.ticketUpdates.add(update);
    }
    
    public void addUpdate(int ticketID, User updatedBy, String comment, String ticketStatus){
        this.addUpdate(new TicketUpdate(ticketID, updatedBy, comment, ticketStatus));
    }
    
    public void addUpdates(Collection<TicketUpdate> updates){
        this.ticketUpdates.addAll(updates);
    }

    public List<TicketUpdate> getTicketUpdates() {
        return ticketUpdates;
    }

    public User getEscalatedTo() {
        return escalatedTo;
    }

    public void setEscalatedTo(User escalatedTo) {
        this.escalatedTo = escalatedTo;
    }
    
    public String getUserTicketID(){
        return "REP00000" + getTicketId();
    }
    
    public String getJSUpdates(){
        String updates = new String();
        
        //status#who#comment#time
        for (TicketUpdate u : getTicketUpdates()){
            String date = getFormattedUpdatedOnDate(u);
            
            updates = updates.concat(u.getTicketStatus().replace("_", " ").replaceFirst(Character.toString(u.getTicketStatus().charAt(0)), Character.toString(u.getTicketStatus().toUpperCase().charAt(0))).concat("#".concat(u.getUpdatedBy().getFullName().concat("#".concat(u.getComment().concat("#".concat(date.concat("||"))))))));
        }
        return updates;
    }

    public String getFormattedUpdatedOnDate(TicketUpdate u) {
        return getFormattedDate(u.getUpdatedOn());
    }

    public String getFormattedDate(Date d) {
        LocalDateTime dt = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' HH:mm");
        String date = dt.format(f);
        return date;
    }
    
    public boolean isClosed(){
        switch (getStatus().toLowerCase()) {
            case "resolved":
            case "closed":
                return true;
            default:
                return false;
        }
    }
}
