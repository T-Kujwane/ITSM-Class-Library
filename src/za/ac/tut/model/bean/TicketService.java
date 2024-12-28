package za.ac.tut.model.bean;

import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;
import za.ac.tut.model.Ticket;
import za.ac.tut.model.TicketPriority;

@Remote
public interface TicketService {

    public List<Ticket> getTicketsByUser(int userId) throws ClassNotFoundException, SQLException;

    public Ticket createTicket(Ticket ticket) throws ClassNotFoundException, SQLException;

    public boolean updateTicketStatus(int ticketId, String status, int updatedBy, String comment) throws ClassNotFoundException, SQLException;

    public boolean updateTicketStatus(int ticketId, String title, String description, String status, String priority, int assignedTO) throws ClassNotFoundException, SQLException;

    public List<Ticket> getTicketsByStatus(String status) throws SQLException, ClassNotFoundException;

    public List<Ticket> getAllTickets() throws SQLException, ClassNotFoundException;

    int getTotalTickets() throws SQLException, ClassNotFoundException;

    List<Ticket> getTicketsByPriority(String priority) throws SQLException, ClassNotFoundException;

    public Ticket getTicketById(int ticketId) throws SQLException, ClassNotFoundException;    
    
    public List<Ticket> getTicketsByUserId(int userId) throws ClassNotFoundException, SQLException;
    
    List<Ticket> getTicketsAssignedTo(int userID) throws SQLException, ClassNotFoundException;

    public boolean update(int ticketID, String comment, String status, int updatedBy) throws SQLException, ClassNotFoundException;

    public boolean escalateTicket(int ticketID, int escalatedTO, String status, int updatedBy, String comment) throws SQLException, ClassNotFoundException;
    
    public List<Ticket> getTicketsEscalatedTo(int userID) throws SQLException, ClassNotFoundException;
}
