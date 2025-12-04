package practice;

import java.util.*;

public class Main {
    private static List<Event> events = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();

    private static int bookingCounter = 1;

    public static void main(String[] args) {

        events.add(new Event(1, "Java Meetup", "2025-02-10", "Алматы"));
        events.add(new Event(2, "Design Bootcamp", "2025-03-01", "Астана"));

        users.add(new User(1, "Гость", Role.GUEST));
        users.add(new User(2, "Алия", Role.USER));
        users.add(new User(3, "Админ", Role.ADMIN));

        Scanner sc = new Scanner(System.in);
        User currentUser = login(sc);

        while (true) {
            showMenu(currentUser);

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    viewEvents();
                    break;

                case 2:
                    if (currentUser.getRole() == Role.USER)
                        bookEvent(sc, currentUser);
                    else
                        System.out.println("Только зарегистрированные пользователи могут бронировать!");
                    break;

                case 3:
                    if (currentUser.getRole() == Role.USER)
                        cancelBooking(sc, currentUser);
                    else
                        System.out.println("Только зарегистрированные пользователи могут отменять!");
                    break;

                case 4:
                    if (currentUser.getRole() == Role.ADMIN)
                        manageEvents(sc);
                    else
                        System.out.println("Только администратор может управлять мероприятиями!");
                    break;

                case 5:
                    if (currentUser.getRole() == Role.ADMIN)
                        viewAllBookings();
                    else
                        System.out.println("Только администратор может просматривать все бронирования!");
                    break;

                case 0:
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }

    private static User login(Scanner sc) {
        System.out.println("Выберите пользователя:");

        for (User u : users) {
            System.out.println(u);
        }

        System.out.print("Введите ID: ");
        int id = sc.nextInt();

        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(users.get(0));
    }

    private static void showMenu(User user) {
        System.out.println("\nВы вошли как: " + user);

        System.out.println("1. Просмотреть мероприятия");

        if (user.getRole() == Role.USER) {
            System.out.println("2. Забронировать мероприятие");
            System.out.println("3. Отменить бронирование");
        }

        if (user.getRole() == Role.ADMIN) {
            System.out.println("4. Управление мероприятиями");
            System.out.println("5. Просмотр всех бронирований");
        }

        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private static void viewEvents() {
        System.out.println("\n--- Список мероприятий ---");
        events.forEach(System.out::println);
    }

    private static void bookEvent(Scanner sc, User user) {
        System.out.print("Введите ID мероприятия: ");
        int id = sc.nextInt();

        Event event = events.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

        if (event == null) {
            System.out.println("Мероприятие не найдено!");
            return;
        }

        bookings.add(new Booking(bookingCounter++, user, event, "Активно"));
        System.out.println("Бронирование создано!");
    }

    private static void cancelBooking(Scanner sc, User user) {
        System.out.print("Введите ID бронирования: ");
        int id = sc.nextInt();

        Booking b = bookings.stream()
                .filter(x -> x.getId() == id && x.getUser().getId() == user.getId())
                .findFirst().orElse(null);

        if (b == null) {
            System.out.println("Бронирование не найдено!");
            return;
        }

        b.setStatus("Отменено");
        System.out.println("Бронирование отменено.");
    }
    private static void manageEvents(Scanner sc) {
        System.out.println("1. Добавить");
        System.out.println("2. Редактировать");
        System.out.println("3. Удалить");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                System.out.print("Название: ");
                String title = sc.nextLine();
                System.out.print("Дата: ");
                String date = sc.nextLine();
                System.out.print("Место: ");
                String loc = sc.nextLine();

                events.add(new Event(events.size() + 1, title, date, loc));
                System.out.println("Добавлено!");
                break;

            case 2:
                System.out.print("ID мероприятия: ");
                int id = sc.nextInt();
                sc.nextLine();

                Event e = events.stream().filter(ev -> ev.getId() == id).findFirst().orElse(null);

                if (e == null) {
                    System.out.println("Не найдено!");
                    return;
                }

                System.out.print("Новое название: ");
                e.setTitle(sc.nextLine());
                System.out.print("Новая дата: ");
                e.setDate(sc.nextLine());
                System.out.print("Новое место: ");
                e.setLocation(sc.nextLine());

                System.out.println("Изменено!");
                break;

            case 3:
                System.out.print("ID мероприятия: ");
                int delId = sc.nextInt();

                events.removeIf(ev -> ev.getId() == delId);
                System.out.println("Удалено!");
                break;

            default:
                System.out.println("Ошибка!");
        }
    }

    private static void viewAllBookings() {
        System.out.println("\n--- Все бронирования ---");
        bookings.forEach(System.out::println);
    }
}
