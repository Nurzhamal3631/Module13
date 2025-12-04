package Homework;

public class MoneyReceivedState implements State {
    private TicketMachine machine;

    public MoneyReceivedState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет уже выбран.");
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Деньги уже внесены.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Билет выдан.");
        machine.setState(machine.getTicketDispensedState());
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция отменена. Возврат денег.");
        machine.setState(machine.getTransactionCanceledState());
    }
}
