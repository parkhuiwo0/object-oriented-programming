package domain;

public class Bag {

    private Long amount;
    private Ticket ticket;

    public boolean hasInvitation() {
        return false;
    }

    public void setTicket(Ticket ticket) {

    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }


}
