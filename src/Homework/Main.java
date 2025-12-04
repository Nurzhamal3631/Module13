package Homework;

public class Main {
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine();

        machine.selectTicket();
        machine.insertMoney(100);
        machine.dispenseTicket();
        machine.selectTicket();
    }
}
