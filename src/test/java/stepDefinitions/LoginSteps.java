package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.junit.Assert;
import io.cucumber.java.After;
import java.time.Duration;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import io.cucumber.java.en.*;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the browser and navigate to {string}")
    public void i_open_browser(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("I enter Username {string} and Password {string}")
    public void i_enter_credentials(String Text_Input, String password) {
        System.out.println("Entering Username: " + Text_Input);
        System.out.println("Entering Password: " + password);
        WebElement usernameField = driver.findElement(By.id("my-text-id"));  // Locate using ID (update the locator)
        usernameField.sendKeys(Text_Input);

        // Locate the password field and enter text
        WebElement passwordField = driver.findElement(By.name("my-password"));  // Locate using ID (update the locator)
        passwordField.sendKeys(password);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I select {string} from the dropdown menu")
    public void i_select_from_dropdown(String optionText) {
        // Locate the dropdown
        WebElement dropdownElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(optionText);  // Use the parameterized value "optionText"
    }

    @When("I select the Textarea and input as {string}")
    public void i_select_the_textarea_and_input_as(String inputText) {
    // Locate the textarea using its name attribute
    WebElement textarea = driver.findElement(By.name("my-textarea"));

    // Clear any existing text (optional)
    textarea.clear();

    // Enter the input text into the textarea
    textarea.sendKeys(inputText);
}




    @When("I select the color red in the color picker")
    public void i_select_the_color_red_in_the_color_picker() {
    // Locate the color input field
    WebElement colorPicker = driver.findElement(By.name("my-colors"));

    // Change the color value to red (#FF0000)
    colorPicker.sendKeys("#FF0000");
}

    @When("I select the next day in the date picker")
    public void i_select_the_next_day_in_the_date_picker() {
    // Locate the date picker input field
    WebElement datePicker = driver.findElement(By.name("my-date"));

    // Get tomorrow's date in YYYY-MM-DD format
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_YEAR, 1); // Add one day
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String nextDay = dateFormat.format(calendar.getTime());

    // Input the next day's date
    datePicker.clear(); // Clear existing text (optional)
    datePicker.sendKeys(nextDay);
}

   @When("I select {string} from the dropdownlist")
    public void i_select_from_dropdownlist(String optionText) {
    // Locate the input field associated with the datalist
    WebElement datalistInput = driver.findElement(By.name("my-datalist"));

    // Enter the option text (Seattle) into the input field
    datalistInput.sendKeys(optionText);

    // Wait for a moment to allow the browser to populate the datalist
    try {
        Thread.sleep(1000); // Temporary wait to allow the datalist to display (better to use explicit waits)
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // Press ENTER to select the first matching option
    datalistInput.sendKeys(Keys.ENTER);
}

    @Then("I should see the text {string}")
    public void i_should_see_the_text(String expectedText) {
        // Locate the element that contains the text on the new page
        WebElement messageElement = driver.findElement(By.className("display-6"));

        // Get the actual text from the element
        String actualText = messageElement.getText();
        System.out.println("Actual Message on Page: " + actualText);

        // Validate the expected text
        Assert.assertEquals("The text on the page does not match!", expectedText, actualText);
        driver.quit();
    }

    @When("I set the range to {int}")
        public void i_set_the_range_to(int rangeValue) {
            // Locate the range input element
            WebElement rangeInput = driver.findElement(By.name("my-range"));

            // Use JavaScript to set the value of the range input
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = arguments[1];", rangeInput, rangeValue);
    }

    @When("I select the radio button with id {string}")
        public void i_select_the_radio_button(String radioButtonId) {
            // Locate the radio button using its id
            WebElement radioButton = driver.findElement(By.id(radioButtonId));
            
            // Check if it's not already selected, and then click to select it
            if (!radioButton.isSelected()) {
                radioButton.click();  // Click to select the radio button
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @When("I click on the submit button")
    public void i_click_login_button() {
        System.out.println("Clicking submit button");
        // Add Selenium click action here
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Submit']")));
        submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("col-12")));
   
}
    @After
    public void tearDown() {
        // Properly quitting the WebDriver after tests
        if (driver != null) 
        {
            driver.quit();  // Close the browser and end the session
        }
} 
}

