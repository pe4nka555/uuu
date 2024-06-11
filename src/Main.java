public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkCredentials("pe4nka", "123", "123");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Проверка не пройдена");
            e.printStackTrace();
        }

    }

    public static void checkCredentials(String login, String password, String confirmPassword) {

        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20");
        }

        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине недопустимые символы");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20");
        }

        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("В пароле недопустимые символы");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }

}