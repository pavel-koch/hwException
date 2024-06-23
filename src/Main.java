import exeption.WrongLoginException;
import exeption.WrongPasswordException;

public class Main {
    private static final String VALID_SIMBOLS="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890_";
    public static void main(String[] args) {
        try {
            dataChecking("qw_asfasfasfasf23", "123", "123");
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void dataChecking(String login, String password, String confirmPassword) {
        loginChecking(login);
        passwordChecking(password);
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }

    public static void loginChecking(String login) {
        if (login.length() > 20) {
            throw new WrongLoginException("Логин больше 20 символов, попробуйте более короткий");
        }
        for (int i = 0; i < login.length(); i++) {
            if (!VALID_SIMBOLS.contains(Character.toString(login.charAt(i)))) {
                throw new WrongLoginException("В логине используются недопустимые символы");
            }
        }
    }
    public static void passwordChecking(String password) {
        if (password.length() > 20) {
            throw new WrongLoginException("Пароль больше 20 символов, попробуйте более короткий");
        }
        for (int i = 0; i < password.length(); i++) {
            if (!VALID_SIMBOLS.contains(Character.toString(password.charAt(i)))) {
                throw new WrongLoginException("В пароле используются недопустимые символы");
            }
        }
    }
}
