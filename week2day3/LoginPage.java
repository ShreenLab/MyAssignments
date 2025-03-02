package week2.week2day3;

public class LoginPage extends BasePage {

    @Override
    public void performCommonTask() 
    { 
        System.out.println("Performing common tasks in LoginPage");
    }

    public static void main(String[] args) {
        BasePage base = new BasePage();
        base.performCommonTask(); // calls BasePage version

        LoginPage login = new LoginPage();
        login.performCommonTask(); // calls LoginPage version
    }
}