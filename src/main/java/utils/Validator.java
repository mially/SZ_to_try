package utils;

public class Validator {

    public boolean loginValidation(String login){
        return login.length() >= 3;
    }

    public boolean passwordValidation(String password){
        return (password.length()>=5 && password.matches(".*\\d.*"));
    }

    public boolean passwordMatch(String password1, String password2){
        return password1.equals(password2);
    }
}
