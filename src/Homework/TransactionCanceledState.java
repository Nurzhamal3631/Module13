package Homework;

public class TransactionCanceledState implements State {
    private TicketMachine machine;

    public TransactionCanceledState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Начало новой транзакции.");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Транзакция отменена. Сначала выберите билет.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Транзакция отменена. Нет билета для выдачи.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Транзакция уже отменена.");
    }
}
