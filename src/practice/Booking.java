package practice;

public class Booking {
    private int id;
    private User user;
    private Event event;
    private String status;

    public Booking(int id, User user, Event event, String status) {
        this.id = id;
        this.user = user;
        this.event = event;
        this.status = status;
    }

    public int getId() { return id; }
    public User getUser() { return user; }
    public Event getEvent() { return event; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "practice.Booking #" + id + " | " + user.getName() + " → " + event.getTitle()
                + " | Status: " + status;
    }
}
