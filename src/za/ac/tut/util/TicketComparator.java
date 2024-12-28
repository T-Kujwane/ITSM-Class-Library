package za.ac.tut.util;

import java.util.Comparator;
import za.ac.tut.model.Ticket;

/**
 *
 * @author Thato Keith Kujwane
 */
public class TicketComparator implements Comparator<Ticket>{

    @Override
    public int compare(Ticket o1, Ticket o2) {
        return Integer.compare(o1.getTicketId(), o2.getTicketId());
    }
}
