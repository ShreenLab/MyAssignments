package pages;

import base.ProjectSpecificMethods;

public class ViewAccountPage extends ProjectSpecificMethods{

	public ViewAccountPage viewAccount() {
		String title = driver.getTitle();
		System.out.println(title);
		return this;

	}

}
