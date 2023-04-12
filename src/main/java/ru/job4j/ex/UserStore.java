package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int index = 0;
        boolean examination = false;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername().equals(login)) {
                examination = true;
                index = i;
                break;
            }
        }
        if (!examination) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return users[index];
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean res = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        return res;
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