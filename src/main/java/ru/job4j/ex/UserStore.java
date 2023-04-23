package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        boolean examination = false;
        User res =  new User(login, false);
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                examination = true;
                res = user;
                break;
            }
        }
        if (!examination) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return res;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    }
}