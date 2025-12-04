package Homework;

public class TicketDispensedState implements State {
    private TicketMachine machine;

    public TicketDispensedState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Ожидайте следующего клиента.");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Ожидайте следующего клиента.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Билет уже выдан.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Невозможно отменить, билет уже выдан.");
    }
}
