import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class main {
    public static void main(String[] args){

        String chromeDriverPath = "C:\\Yung\\ST_Lab5\\chromedriver.exe"; // You must to change this to your chrome Driver
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();

        /* Requirement a. in Lab5 */
        System.out.println("\nRequirement 1:");
        // navigate to NYCU home page
        driver.get("https://www.nycu.edu.tw/");
        // Maximize current window
        driver.manage().window().maximize();
        // click NEWs
        driver.findElement(By.linkText("消息")).click();
        // click first news
        driver.findElement(By.cssSelector(".eael-tabs-content > div:first-child ul > li:first-child > a")).click();
        // print title and content
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".single-post-title"))); // wait for loading
        WebElement post_title = driver.findElement(By.cssSelector(".single-post-title"));
        WebElement post_content = driver.findElement(By.cssSelector(".entry-content"));
        System.out.println("title:\n" + post_title.getText());
        System.out.println("content:\n" + post_content.getText());


        /* Requirement b. in Lab5 */
        System.out.println("\nRequirement 2:");
        // open a new tab and switch to it
        ((JavascriptExecutor)driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        // navigate to google
        driver.get("https://www.google.com");
        // input your student number and submit
        WebElement google_search_input = driver.findElement(By.cssSelector("input"));
        google_search_input.sendKeys("0856167");
        google_search_input.submit();
        // print the title of second result
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".g:nth-child(2) h3"))); // wait for loading
        WebElement second_search_result_title = driver.findElement(By.cssSelector(".g:nth-child(2) h3"));
        System.out.println(second_search_result_title.getText());
        // close the browser
        driver.quit();
    }

}
