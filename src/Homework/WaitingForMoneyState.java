package Homework;

public class WaitingForMoneyState implements State {
    private TicketMachine machine;

    public WaitingForMoneyState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет уже выбран.");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Получены деньги: " + amount);
        machine.setState(machine.getMoneyReceivedState());
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Сначала внесите деньги.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция отменена.");
        machine.setState(machine.getTransactionCanceledState());
    }
}
