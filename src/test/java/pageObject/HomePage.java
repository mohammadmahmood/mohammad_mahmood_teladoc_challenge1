package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.util.Strings;

import base.GlobalTestData;
import base.Setup;

public class HomePage extends Setup {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    
    Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    // Elements
    @FindBy(how = How.XPATH, using = "//button[text()=' Add User']")
    public WebElement ADD_USER;
    @FindBy(how = How.XPATH, using = "//button[text()='Save']")
    public WebElement SAVE;
    @FindBy(how = How.XPATH, using = "(//*[@name='optionsRadios'])[1]")
    public WebElement COMPANYAAA;
    @FindBy(how = How.XPATH, using = "(//*[@name='optionsRadios'])[1]")
    public WebElement COMPANYBBB;
    @FindBy(how = How.XPATH, using = "//*[text()='OK']")
    public WebElement OK;
    @FindBy(how = How.NAME, using = "RoleId")
    public WebElement ROLE;
	
    // Dynamic Element identifiers
    // for dynamic xpath replace 'replaceValue' with the element text
    public String dynam = "//button[text()=' Add User']";
	
    public void validatePageTitle(String title){
    	Assert.assertEquals(driver.getTitle(), title);
    }

    
    public void click(String btnName) {
    	try {
    		switch(btnName) {
    		case "Add User":
    			ADD_USER.click();;
    			break;
    		case "Save":
    			SAVE.click();;
    			break;
    		}
    	}catch(Exception e) {
            Assert.fail("Unable to click element");
    	}
    }
    
    public void enterText(String value, String textbox) {
    	String textboxName = "";
    	try {
    		switch(textbox) {
    		case "First Name":
    			textboxName = "FirstName"; 
    			break;
    		case "Last Name":
    			textboxName = "LastName";
    			break;
    		case "User Name":
    			textboxName = "UserName";
    			break;
    		case "Password":
    			textboxName = "Password";
    			break;
    		case "email":
    			textboxName = "Email";
    			break;
    		case "Cell Phone":
    			textboxName = "Mobilephone";
    			break;
    		}
    		driver.findElement(By.name(textboxName)).sendKeys(value);
    	}catch(Exception e) {
            Assert.fail("Unable to enter text in "+textbox);
    	}
    }
    
    public void selectRadioButton(String radioBtn) {
    	try {
    		switch(radioBtn) {
    		case "company AAA": 
    			COMPANYAAA.click();
    			break;
    		case "company BBB":
    			COMPANYBBB.click();
    			break;
    		}
    	}catch(Exception e) {
            Assert.fail("Unable to select "+radioBtn);
    	}
    }
    
    public void selectRole(String role) {
    	try {
    		Select roleDropDown = new Select(ROLE);
    		roleDropDown.selectByVisibleText(role);
    	}catch(Exception e) {
            Assert.fail("Unable to select role ");
    	}
    }
    
    
    public void validateUserExists(String email, boolean exists) {
    	try {
    		boolean check = false;
    		try {
    			WebElement ele = driver.findElement(By.xpath("//*[text()='"+email+"']"));
    			if(ele.isDisplayed()) {
    				check = true;
    			}
    		}catch(NoSuchElementException e) {
    			check = false;
    		}
    		Assert.assertEquals(exists, check);
    	}catch(Exception e) {
            Assert.fail("Unable to validate if user exists");
    	}
    }
    
    
    public void deleteUser(String name) {
    	try {
    		driver.findElement(By.xpath("//*[text()='"+name+"']//following-sibling::td[8]/button")).click();		
    	}catch(Exception e) {
            Assert.fail("Unable to delete user");
    	}
    }
    
    public void acceptConfirmation() {
    	try {
    		OK.click();		
    	}catch(Exception e) {
            Assert.fail("Unable to accept confirmation");
    	}
    }
    
    
    
}

