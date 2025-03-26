package pages;

import base.ProjectSpecificMethods;
import io.cucumber.java.en.When;

public class ViewAccountPage extends ProjectSpecificMethods{
	@When("user verifies account creation")
	public ViewAccountPage viewAccount() {
		String title = getDriver().getTitle();
		System.out.println(title);
		return this;

	}

}
