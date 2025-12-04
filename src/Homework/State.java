package Homework;

public interface State {
    void selectTicket();
    void insertMoney(int amount);
    void dispenseTicket();
    void cancelTransaction();
}
