import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testhere {

	public static void main(String[] args) {
		
		System.out.println("print this");
		WebDriver driver = new ChromeDriver();
	  //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ghs6kor\\Desktop\\Java\\chromedriver.exe");
	      String url = "https://www.google.com";
	      driver.get(url);
	      String searchbox = "//input[@name='q']";
	      driver.findElement(By.xpath(searchbox)).sendKeys("Manish");;
	      driver.close();

	}

}
