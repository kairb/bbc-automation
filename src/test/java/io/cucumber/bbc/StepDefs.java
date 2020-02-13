package io.cucumber.bbc;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class StepDefs {
    private Driver driver;

    @When("the user clicks sign in")
    public void the_user_clicks_sign_in() {
        driver.click(driver.findById("idcta-link"));
    }

    @Then("the user should be shown the login form")
    public void the_user_should_be_shown_the_login_form() {
        assertEquals(true,driver.elementExists("user-identifier-input"));
    }


    @Given("the user loads page {string}")
    public void the_user_loads_page(String url) {
        driver = new Driver(url);
    }

    @Then("the page should render correctly")
    public void the_page_should_render_correctly() {
        assertEquals(true, driver.elementExists("hp-bbc-homepage-content"));
    }

    @Given("the user is on the sign in page {string}")
    public void the_user_is_on_the_sign_in_page(String URL) {
        driver = new Driver(URL);
    }


    @Then("the login should be successful")
    public void the_login_should_be_successful() {
        assertEquals(false, driver.elementExists("form-message-password"));
    }

    @Then("the login should be unsuccessful")
    public void the_login_should_be_unsuccessful() {
        assertEquals(true, driver.elementExists("form-message-password"));
    }

    @When("login details are inserted into the login form {string} {string}")
    public void login_details_are_inserted_into_the_login_form(String username, String password) {
        driver.elementExists("user-identifier-input");
        driver.type(driver.findById("user-identifier-input"), username);
        driver.type(driver.findById("password-input"), password);
    }

    @When("the login button is pressed")
    public void the_login_button_is_pressed() {
        driver.click(driver.findById("submit-button"));
    }



    @After
    public void tearDown(){
        driver.quit();
    }
}
