package stepDef;

import base.GlobalTestData;
import base.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;

public class StepDef extends Setup {
	 HomePage HOME; 

	@Given("I am on Protractor Practice website home page")
	public void i_am_on_protractor_practice_website_home_page() throws InterruptedException {
		driver = initDriver(); 
        driver.get(GlobalTestData.url);
        HOME = new HomePage(driver);
		HOME.validatePageTitle("Protractor practice website - WebTables");
	}

	@When("I click on {string} Button")
	public void i_click_on_button(String btnName) {
		HOME.click(btnName);
		}

	@When("I enter {string} as {string}")

	public void i_enter_as(String value, String textbox) {
		HOME.enterText(textbox, value);
	}

	@When("I select {string} radio button")
	public void i_select(String string) {
		HOME.selectRadioButton(string);
	}

	@When("I select role as {string}")
	public void i_select_role_as(String role) {
		HOME.selectRole(role);
	}


	@Then("I should see user with {string} email is added to the list")
	public void i_should_be_able_to_see_the_new_user_added_to_the_list(String email) {
		HOME.validateUserExists(email, true);
	}

	@When("I delete user with name {string}")
	public void i_delete_user_with_name(String name) {
		HOME.deleteUser(name);
	}

	@When("I click ok on confirmation pup up")
	public void i_click_ok_on_confirmation_pup_up() {
		HOME.acceptConfirmation();
	}

	@Then("I do not see {string} in the user list")
	public void i_do_not_see_in_the_user_list(String name) {
		HOME.validateUserExists(name, false);
	}
}
	
