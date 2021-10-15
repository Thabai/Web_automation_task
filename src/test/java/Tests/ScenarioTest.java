package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioTest {

    WebDriver driver;

        @Given("I add four different products to my wish list")
        public void add_four_products () throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\carly\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://testscriptdemo.com/");
            driver.manage().window();
            driver.findElement(By.linkText("Black pants")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(3000);
            driver.navigate().back();
            driver.findElement(By.linkText("Modern")).click();
            driver.findElement(By.xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            driver.navigate().back();
            driver.findElement(By.linkText("Single Shirt")).click();
            driver.findElement(By.xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            driver.navigate().back();
            driver.findElement(By.linkText("Top pants upper")).click();
            driver.findElement(By.xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(3000);
        }

        @When("I view my wishlist table")
        public void wishlist_table () throws InterruptedException  {
            driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");
        }

        @Then("I find total four selected items in my Wishlist")
        public void four_products_wishlist () {

        }

        @When("I search for lowest price product")
        public void search_lowest_price_product () {

        }

        @And("I am able to add the lowest price item to my cart")
        public void add_lowest_price_product_to_cart () {

        }

        @Then("I am able to verify the item in my cartRequirements")
        public void verify_cart () {

        }

}
