import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 6000, "OMS", "VKO", 3);
    Ticket ticket2 = new Ticket(2, 3500, "OMS", "VKO", 3);
    Ticket ticket3 = new Ticket(3, 3600, "OMS", "SVO", 3);
    Ticket ticket4 = new Ticket(4, 4000, "OMS", "VKO", 3);
    Ticket ticket5 = new Ticket(5, 7000, "OMS", "SVO", 3);
    Ticket ticket6 = new Ticket(6, 5500, "OMS", "SVO", 3);

    @Test
    public void FindSomeTest(){

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket3,ticket6,ticket5};
        Ticket[] actual = manager.findAll("OMS","SVO");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void FindOneTicketTest(){

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("OMS","SVO");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void FindZeroTicketTest(){

        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("OMS","SVO");
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected,actual);
    }
}
