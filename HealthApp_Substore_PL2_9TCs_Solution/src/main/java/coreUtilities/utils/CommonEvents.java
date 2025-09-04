package coreUtilities.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CommonEvents {
    WebDriver driver;
    public CommonEvents(WebDriver d) { this.driver = d; }

    // find element
    public WebElement findElement(By loc) { 
        return driver.findElement(loc); 
    }

    // click
    public void click(By loc) { 
        driver.findElement(loc).click(); 
    }

    // sendKeys
    public void sendKeys(By loc, String val) { 
        driver.findElement(loc).sendKeys(val); 
    }

    // get multiple elements
    public List<WebElement> getWebElements(By loc) { 
        return driver.findElements(loc); 
    }

    // get current URL
    public String getCurrentUrl() { 
        return driver.getCurrentUrl(); 
    }

    // wait for URL
    public boolean waitForUrlContains(String part, int sec) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(sec))
                    .until(ExpectedConditions.urlContains(part));
        } catch (Exception e) {
            return false;
        }
    }

	public void navigateTo(String url) {
		driver.get(url);
	}
}






















//package coreUtilities.utils;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//import java.util.List;
//
//public class CommonEvents {
//    WebDriver driver;
//    public CommonEvents(WebDriver d) { this.driver = d; }
//
//    // find element
//    public WebElement findElement(By loc) { return driver.findElement(loc); }
//
//    // click methods
//    public CommonEvents click(By loc) {
//        driver.findElement(loc).click();
//        return this;
//    }
//
//    public CommonEvents click(WebElement el) { el.click(); return this; }
//    public CommonEvents clickElement(WebElement el) { el.click(); return this; }
//
//    // sendKeys
//    public CommonEvents sendKeys(By loc, String val) {
//        driver.findElement(loc).sendKeys(val);
//        return this;
//    }
//    public CommonEvents sendKeys(WebElement el, String val) { el.sendKeys(val); return this; }
//
//    // get multiple elements
//    public List<WebElement> getWebElements(By loc) { return driver.findElements(loc); }
//
//    // highlight (dummy for exam)
//    public CommonEvents highlight(WebElement el) { return this; }
//    public CommonEvents highlightElement(WebElement el) { return this; }
//
//    // wait functions (Selenium 4 style)
//    public boolean waitForUrlContains(String part, int sec) {
//        try {
//            return new WebDriverWait(driver, Duration.ofSeconds(sec))
//                    .until(ExpectedConditions.urlContains(part));
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//    public void waitTillElementVisible(WebElement el, int ms) {
//        new WebDriverWait(driver, Duration.ofMillis(ms))
//                .until(ExpectedConditions.visibilityOf(el));
//    }
//
//    // util
//    public boolean isDisplayed(WebElement el) { return el.isDisplayed(); }
//    public String getCurrentUrl() { return driver.getCurrentUrl(); }
//
//    // screenshot (stub)
//    public void takeScreenshot(String name) { }
//
//	public void navigateTo(String url) {
//		driver.get(url);
//	}
//}
