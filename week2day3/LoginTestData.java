package week2.week2day3;

public class LoginTestData extends TestData {
	public void enterUsername() {
		System.out.println("username entered");
	}
	public void enterPassword() {
		System.out.println("password entered");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create method and calling class TestData
		LoginTestData test = new LoginTestData();
		test.enterUsername();
		test.enterPassword();
		test.enterCredentials();
		test.navigateToHomePage();

	}

}
