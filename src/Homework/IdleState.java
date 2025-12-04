package Homework;

public class IdleState implements State {
    private TicketMachine machine;

    public IdleState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectTicket() {
        System.out.println("Билет выбран. Ожидаем внесения денег.");
        machine.setState(machine.getWaitingForMoneyState());
    }

    @Override
    public void insertMoney(int amount) {
        System.out.println("Сначала выберите билет.");
    }

    @Override
    public void dispenseTicket() {
        System.out.println("Нет билета для выдачи.");
    }

    @Override
    public void cancelTransaction() {
        System.out.println("Нет активной транзакции для отмены.");
    }
}
