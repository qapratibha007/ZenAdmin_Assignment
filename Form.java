import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Form {
    public static void main(String[] args) {
    	
      //System.setProperty("webdriver.chrome.driver", ".chromedriver");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        String url = "https://automationintesting.com/selenium/testpage/";
        driver.get(url);

        fill_First_Name(driver, "Pratibha");
        fill_Surname(driver, "Rana");
        select_Gender(driver, "Female");
        choose_Favorite_Color(driver, "Red");
        enter_Comment(driver, "Thrilled about the opportunity to work @ ZenAdmin!");
        selectContinent(driver, "Asia");
        choose_Contact_Method(driver, "checkbox1");
        submit_Form(driver);

        driver.quit();
    }

    private static void fill_First_Name(WebDriver driver, String firstName) {
        WebElement firstNameElement = driver.findElement(By.id("firstname"));
        firstNameElement.sendKeys(firstName);
    }

    private static void fill_Surname(WebDriver driver, String surname) {
        WebElement lastNameElement = driver.findElement(By.id("surname"));
        lastNameElement.sendKeys(surname);
    }

    private static void select_Gender(WebDriver driver, String gender) {
        Select genderSelect = new Select(driver.findElement(By.id("gender")));
        genderSelect.selectByVisibleText(gender);
    }

    private static void choose_Favorite_Color(WebDriver driver, String color) {
        String xpath = "//input[@value='" + color + "']";
        WebElement colorEle = driver.findElement(By.xpath(xpath));
        colorEle.click();
    }

    private static void enter_Comment(WebDriver driver, String comment) {
        WebElement commentEle = driver.findElement(By.xpath("//textarea[@placeholder='Tell us some fun stuff!']"));
        commentEle.sendKeys(comment);
    }

    private static void selectContinent(WebDriver driver, String continent) {
        Select continentSelect = new Select(driver.findElement(By.id("continent")));
        continentSelect.selectByVisibleText(continent);
    }

    private static void choose_Contact_Method(WebDriver driver, String contactId) {
        WebElement contactMethod = driver.findElement(By.id(contactId));
        contactMethod.click();
    }

    private static void submit_Form(WebDriver driver) {
        WebElement submitButton = driver.findElement(By.id("submitbutton"));
        submitButton.click();
    }
}
