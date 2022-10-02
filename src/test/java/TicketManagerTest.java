import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 6000, "OMS", "VKO", 3);
    Ticket ticket2 = new Ticket(2, 3500, "OMS", "VKO", 3);
    Ticket ticket3 = new Ticket(3, 3600, "OMS", "SVO", 5);
    Ticket ticket4 = new Ticket(4, 4000, "OMS", "VKO", 3);
    Ticket ticket5 = new Ticket(5, 7000, "OMS", "SVO", 4);
    Ticket ticket6 = new Ticket(6, 5500, "OMS", "SVO", 3);

    @Test
    public void FindTest() {

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        TicketByWayTime comporator = new TicketByWayTime();
        Ticket[] expected = {ticket6, ticket5, ticket3};

        Ticket[] actual = manager.findAll("OMS", "SVO");
        Arrays.sort(actual, comporator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
