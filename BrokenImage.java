import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImage {

	 public static void main(String[] args) {
	       
	       //System.setProperty("webdriver.chrome.driver", "/Users/zenarate/Downloads/chromedriver");
            
		   //WebDriverManager.chromedriver().setup();
		    WebDriver driver = new ChromeDriver();

	        String brokenImageURL = "https://practice.expandtesting.com/broken-images";
	        driver.get(brokenImageURL);

	        List<WebElement> images = driver.findElements(By.tagName("img"));

	        System.out.println("Total images found: " + images.size());

	        int brokenImageCount = 0;

	        for (WebElement img : images) {
	            if (img.getAttribute("naturalWidth").equals("0") || img.getAttribute("width").equals("0")) {
	                System.out.println("Broken image found: " + img.getAttribute("src"));
	                brokenImageCount++;
	            }
	        }

	        System.out.println("Total broken images: " + brokenImageCount);

	        driver.quit();
	    }
	}
