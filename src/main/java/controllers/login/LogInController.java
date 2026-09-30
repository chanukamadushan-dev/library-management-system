package controllers.login;

public class LogInController {
    public boolean checkUserNameAndPasswor(String name, String password) {
        if (name.equals("pamodmadushan") && password.equals("200401")){
            return true;
        }
        return false;
    }
}
