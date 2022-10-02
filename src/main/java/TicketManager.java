public class TicketManager {
    TicketRepository repo = new TicketRepository();

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] tmp = new Ticket[getCountMatchedTicketForArgs(from, to)];
        int index = 0;
        for (Ticket ticket : repo.getAllTicket()) {
            if (matches(ticket, from, to)) {
                tmp[index] = ticket;
                index++;
            }
        }
        return tmp;
    }

    public int getCountMatchedTicketForArgs(String from, String to) { // Получение количества найденных продуктов по имени для создания массива.
        int index = 0;
        for (Ticket ticket : repo.getAllTicket()) {
            if (matches(ticket, from, to)) {
                index++;
            }
        }
        return index;

    }


    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getAerOut().contains(from) & ticket.getAerIn().contains(to)) {
            return true;
        } else {
            return false;
        }
    }


}
