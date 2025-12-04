package practice;

public class Event {
    private int id;
    private String title;
    private String date;
    private String location;

    public Event(int id, String title, String date, String location) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getLocation() { return location; }

    public void setTitle(String title) { this.title = title; }
    public void setDate(String date) { this.date = date; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return id + ". " + title + " | " + date + " | " + location;
    }
}
