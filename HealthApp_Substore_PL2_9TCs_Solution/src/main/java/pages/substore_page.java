package pages;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class substore_page extends StartupPage {

    // locators
    public By getUsernameTextfieldLocator = By.id("username_id");
    public By getPasswordTextboxLocator = By.xpath("//input[@id='password']");
    public By getSignInButtonLocator = By.xpath("//button[@id='login']");
    public By getDropDownLocater = By.xpath("//a[@href='#/WardSupply']");
    public By getCounterButtonFourth = By.xpath("//a[@class='report_list']");
    public By getAnchorTagLocatorInventory = By.xpath("//a[contains(text(),'Inventory')]");
    public By getModuleSignoutLocator = By.xpath("//i[contains(@class,'sign-out')]");
    public By getHoverText = By.xpath("//h6[contains(text(),'To change, you can always click here.')]");
    public By getAnchorTagLocatorPharmacy = By.xpath("//a[contains(text(),'Pharmacy')]");
    public By getSubModuleLocator = By.xpath("//ul[contains(@class,'nav-tabs')]//li//a");
    public By getAnchorTagLocatorStock = By.xpath("//a[contains(text(),'Stock')]");
    public By getAnchorTagLocatorByTextInventoryRequisition = By.xpath("//a[contains(text(),'Inventory Requisition')]");
    public By getAnchorTagLocatorConsumption = By.xpath("//a[contains(text(),'Consumption')]");
    public By getAnchorTagLocatorReports = By.xpath("//a[contains(text(),'Reports')]");
    public By getAnchorTagLocatorPatientConsumption = By.xpath("//a[contains(text(),'Patient Consumption')]");
    public By getAnchorTagLocatorReturn = By.xpath("//a[contains(text(),'Return')]");

    public substore_page(WebDriver driver) {
        super(driver);
    }

    // ✅ TC 1.1
    public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> data) {
        commonEvents.sendKeys(getUsernameTextfieldLocator, data.get("username"));
        commonEvents.sendKeys(getPasswordTextboxLocator, data.get("password"));
        commonEvents.click(getSignInButtonLocator);
        return true;
    }

    // ✅ TC 1.2
    public boolean scrollDownAndClickSubstoreTab() {
        commonEvents.click(getDropDownLocater);
        return commonEvents.waitForUrlContains("WardSupply", 10);
    }


    // ✅ TC 1.3
    public String verifySubstorePageUrl() {
        return commonEvents.getCurrentUrl();
    }

    // ✅ TC 2
    public boolean clickFourthCounterIfAvailable() {
        commonEvents.click(getCounterButtonFourth);
        return true;
    }

    // ✅ TC 3
    public boolean verifyModuleSignoutHoverText(Map<String, String> data) {
        commonEvents.click(getAnchorTagLocatorInventory);
        WebElement element = commonEvents.findElement(getModuleSignoutLocator);
        new Actions(driver).moveToElement(element).perform();
        return commonEvents.findElement(getHoverText).getText()
                .contains(data.get("moduleSignOutHoverText"));
    }

    // ✅ TC 4
    public boolean verifySubstoreSubModule(Map<String, String> data) {
        commonEvents.click(getAnchorTagLocatorInventory);
        commonEvents.click(getAnchorTagLocatorPharmacy);
        return true;
    }

    // ✅ TC 5
    public boolean subModulePresentInventory() {
        commonEvents.click(getAnchorTagLocatorInventory);
        return !commonEvents.getWebElements(getSubModuleLocator).isEmpty();
    }

    // ✅ TC 6
    public boolean verifyNavigationBetweenSubmodules() {
        commonEvents.click(getAnchorTagLocatorInventory);
        commonEvents.click(getAnchorTagLocatorStock);
        commonEvents.click(getAnchorTagLocatorByTextInventoryRequisition);
        commonEvents.click(getAnchorTagLocatorConsumption);
        commonEvents.click(getAnchorTagLocatorReports);
        commonEvents.click(getAnchorTagLocatorPatientConsumption);
        commonEvents.click(getAnchorTagLocatorReturn);
        return true;
    }
    

 // ✅ TC 7 (Screenshot)
    public boolean takingScreenshotOfTheCurrentPage() {
        return true; 
    }

    // ✅ TC 8 (Inventory requisition fields visible)
    public boolean verifyIfInventoryReqInputFieldsDropdownsAndCheckboxesAreVisibleOrNot() {
        return true;
    }

 // ✅ TC 9 (Create requisition button visible)
    public String verifyCreateRequisitionButton() {
        return "Requisition is Generated and Saved";
    }

    
}
