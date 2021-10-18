package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.*;

public class ScenarioTest {

    String actualPrice;
    WebDriver driver;

        @Given("I add four different products to my wish list")
        public void add_four_products () throws InterruptedException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\carly\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("https://testscriptdemo.com/");
            driver.manage().window();
            driver.findElement(linkText("Bikini")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            driver.findElement(linkText("Modern")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(1000);
            driver.navigate().back();
            driver.findElement(linkText("Single Shirt")).click();
            Thread.sleep(1000);
            driver.findElement(xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(1000);
            driver.get("https://testscriptdemo.com/?product=black-trousers");
            Thread.sleep(1000);
            driver.findElement(xpath("//span[contains(text(), 'Add to wishlist')]")).click();
            Thread.sleep(1000);
        }

        @When("I view my wishlist table")
        public void wishlist_table () {
            driver.get("https://testscriptdemo.com/?page_id=233&wishlist-action");
        }

        @Then("I find total four selected items in my Wishlist")
        public void four_products_wishlist () {
           int wishlist = driver.findElements(By.className("product-thumbnail")).size();
           int actualAnswer = wishlist -1;
           int answer = 4;
            assertEquals(answer, actualAnswer);
        }

        @When("I search for lowest price product")
        public void search_lowest_price_product () {

            List<WebElement> price = driver.findElements(xpath("//td[@class='product-price']/ins/span/bdi"));
            List<String> prices = new ArrayList<String>();
            for (WebElement e : price)
            {
                prices.add(e.getText());
            }

            List<String> sortedPrices = new ArrayList<String>(prices);

            Collections.sort(sortedPrices);
            actualPrice = sortedPrices.get(0);
            String answer = "£19.00";
            assertEquals(answer, actualPrice);
        }

        @And("I am able to add the lowest price item to my cart")
        public void add_lowest_price_product_to_cart () throws InterruptedException {
            Thread.sleep(1000);
            String lowestPrice = actualPrice.replace("£", "");
            WebElement addToCart = driver.findElement(xpath("//bdi[contains(text(), '" + lowestPrice +"')]//following::td[2]/a[1]"));
            addToCart.click();
            Thread.sleep(1000);
        }

        @Then("I am able to verify the item in my cartRequirements")
        public void verify_cart () {
            String cart = driver.findElement(xpath("//span[@class='count']")).getText();
            String answer = "1";
            assertEquals(answer, cart);
        }

}
