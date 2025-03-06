package org.lessons.lesson19;

public class Main {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();
        int searchId = 1;

        repository.addUser(new User(1, "Mykola", "mykola@gmail.com"));
        repository.addUser(new User(2, "Elon", "elon@gmail.com"));

        repository.findUserById(searchId)
                .ifPresentOrElse(
                        user -> System.out.println("Знайдено користувача за id: " + user),
                        () -> System.out.println("Користувача з id " + searchId + " не знайдено.")
                );

        String searchEmail = "mykola@gmail.com";
        repository.findUserByEmail(searchEmail)
                .ifPresentOrElse(
                        user -> System.out.println("Знайдено користувача за email: " + user),
                        () -> System.out.println("Користувача з email " + searchEmail + " не знайдено.")
                );

        repository.findAllUsers()
                .ifPresentOrElse(
                        userList -> System.out.println("Кількість користувачів: " + userList.size()),
                        () -> System.out.println("Список користувачів порожній.")
                );
    }
}
