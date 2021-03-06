package mooltipass.automatedTests.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import junit.framework.Assert;
import mooltipass.automatedTests.config.WebDriverFactory;
import mooltipass.automatedTests.pageObjects.GitHub;
public class GitHubSteps {
	
	GitHub github= new GitHub(WebDriverFactory.get());
	
	@Given("I navigate to '(.*)'")
	public void navigateToURL(String url){
		WebDriverFactory.get().get(url);
		github.sleep(1000);
	}
	

	@When("I login GitHub with '(.*)'")
	public void login(String username){
		github.goToLogin();
		github.enterEmail(username);
		String password ="p5AG9elmrJt9tKSdsleA";
		github.enterPassword(password);
		github.submit();
		
	}
	@When("I go to GitHub login page")
	public void pressLogin(){
		github.goToLogin();
		Assert.assertTrue("Expected to be at login page", github.checkAtLoginPage());
		
	}
	@Then("I should be logged in GitHub")
	public void checkLogin(){
		Assert.assertTrue("Expected User to be logged in",github.checkLogin());
	}
	
	@When("I logout GitHub")
	public void pressLogout(){
		github.goTodDashboard();
		github.logout();
	}
}
