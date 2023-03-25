package pl.javastart.task;

public class Main {

    public static void main(String[] args) {

        Ticket ticket1 = Ticket.buyTicket();
        Ticket ticket2 = Ticket.buyTicket();

        ticket1.showTicketInfo();
        ticket2.showTicketInfo();
    }
}
