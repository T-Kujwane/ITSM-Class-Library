package za.ac.tut.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Thato Keith Kujwane
 */
public class TicketUpdate implements Serializable{
    private int updateID;
    
    private int ticketID;
    
    private User updatedBy;
    
    private String comment;
    
    private Date updatedOn;
    
    private String ticketStatus;

    public TicketUpdate() {
    }

    public TicketUpdate(int updateID, int ticketID, User updatedBy, String comment, Date updatedOn, String ticketStatus) {
        this.updateID = updateID;
        this.ticketID = ticketID;
        this.updatedBy = updatedBy;
        this.comment = comment;
        this.updatedOn = updatedOn;
        setTicketStatus(ticketStatus);
    }

    public TicketUpdate(int ticketID, User updatedBy, String comment, String ticketStatus) {
        this.ticketID = ticketID;
        this.updatedBy = updatedBy;
        this.comment = comment;
        setTicketStatus(ticketStatus);
    }

    public int getUpdateID() {
        return updateID;
    }

    public void setUpdateID(int updateID) {
        this.updateID = updateID;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public final void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    
}
