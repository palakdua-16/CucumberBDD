package org.example;


import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SearchWashingMachineSteps {
    WebDriver driver;
    WebDriverWait wait;
    int amazonCount = 0;
    int flipkartCount = 0;

    @Given("I open Google homepage")
    public void i_open_google_homepage() {
        WebDriver driver=new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @When("I search for {string}")
    public void i_search_for(String query) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
    }

    @Then("I should see the search results")
    public void i_should_see_the_search_results() {
        List<WebElement> results = driver.findElements(By.cssSelector("div#search .g"));
        assertFalse(results.isEmpty());
    }

    @And("I count the number of Amazon and Flipkart links")
    public void i_count_the_number_of_amazon_and_flipkart_links() {
        List<WebElement> results = driver.findElements(By.cssSelector("div#search .g"));
        for (WebElement result : results) {
            String link = result.findElement(By.tagName("a")).getAttribute("href");
            if (link.contains("amazon.in")) {
                amazonCount++;
            } else if (link.contains("flipkart.com")) {
                flipkartCount++;
            }
        }
        System.out.println("Amazon links: " + amazonCount);
        System.out.println("Flipkart links: " + flipkartCount);
    }

    @And("I verify the titles and number of results on each Amazon and Flipkart link")
    public void i_verify_the_titles_and_number_of_results_on_each_amazon_and_flipkart_link() {
        List<WebElement> results = driver.findElements(By.cssSelector("div#search .g"));
        List<String> amazonFlipkartLinks = results.stream()
                .map(result -> result.findElement(By.tagName("a")).getAttribute("href"))
                .filter(link -> link.contains("amazon.in") || link.contains("flipkart.com"))
                .collect(Collectors.toList());

        for (String link : amazonFlipkartLinks) {
            driver.get(link);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("title")));
            String title = driver.getTitle();
            assertFalse(title.isEmpty());

            List<WebElement> items;
            if (link.contains("amazon.in")) {
                items = driver.findElements(By.cssSelector(".s-result-item"));
            } else {
                items = driver.findElements(By.cssSelector("._1AtVbE"));
            }
            assertTrue(items.size() > 0);
        }
        driver.quit();
    }
}
