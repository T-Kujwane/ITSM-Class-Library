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
        if(o.getTicketId() == this.getTicketId()){
            return 0;
        }else{
            if(o.getTicketId() > getTicketId()){
                return 1;
            }
        }
        return -1;
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
    private int createdBy;
    private User assignedTo;
    private Date createdAt;
    private Date updatedAt;
    private TicketPriority priority;
    private List<TicketUpdate> ticketUpdates;
    
    // Constructor
    public Ticket(int ticketId, String title, String description, String status, int createdBy, int assignedTo, Date createdAt, Date updatedAt) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = new User(assignedTo);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, Priority.Level.LOW.toString());
        initializeUpdatesList();
    }

    private void initializeUpdatesList() {
        this.ticketUpdates = new ArrayList<>();
    }

    public Ticket(int ticketId, String title, String description, String status, int createdBy, User assignedTo, Date createdAt, Date updatedAt, TicketPriority priority, List<TicketUpdate> ticketUpdates) {
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
    }
    
    public Ticket(int ticketId, String title, String description, String status, int createdBy, int assignedTo, Date createdAt, Date updatedAt, String priority) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.assignedTo = new User(assignedTo);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.priority = new TicketPriority(ticketId, priority);
        initializeUpdatesList();
    }
    
    public Ticket(String title, String description, String status, int userId) {
        setTitle(title);
        setDescription(description);
        setStatus(status);
        setCreatedBy(userId);
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

    public int getCreatedBy() { return createdBy; }
    public void setCreatedBy(int createdBy) { this.createdBy = createdBy; }

    public User getAssignedTo() { return assignedTo; }
    public void setAssignedTo(int assignedTo) { this.assignedTo = new User(assignedTo); }
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
    
    public String getUserTicketID(){
        return "REP00000" + getTicketId();
    }
    
    public String getJSUpdates(){
        String updates = new String();
        
        //status#who#comment#time
        for (TicketUpdate u : getTicketUpdates()){
            LocalDateTime dt = u.getUpdatedOn().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            DateTimeFormatter f = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' HH:mm");
            String date = dt.format(f);
            
            updates = updates.concat(u.getTicketStatus().replace("_", " ").replaceFirst(Character.toString(u.getTicketStatus().charAt(0)), Character.toString(u.getTicketStatus().toUpperCase().charAt(0))).concat("#".concat(u.getUpdatedBy().getFullName().concat("#".concat(u.getComment().concat("#".concat(date.concat("||"))))))));
        }
        return updates;
    }
}
