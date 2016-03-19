package andersTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.Select;


public class seleniumWrapper {

	protected WebDriver driver = new FirefoxDriver();
	
	public WebElement getElement(String locator)
	{
		WebElement elt = driver.findElement(By.xpath(locator));
		return elt;
		
	}
	public void clickXpath(String locator)
	{
		driver.findElement(By.xpath(locator)).click();
 		
	}
	
	public void clickCSS(String locator)
	{
		driver.findElement(By.cssSelector(locator)).click();
 		
	}
	
	protected void homePage()
	{
		driver.get("https://demo2.shoop.io/");
		driver.manage().window().maximize();
	}
	
	protected void login()
	{
		driver.get("https://demo2.shoop.io/sa/");
		driver.findElement(By.xpath(".//*[@id='id_username']")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='id_password']")).sendKeys("admin");		
		clickCSS(".btn.btn-primary.btn-lg.btn-block");
	}
	
	public void addtoCart(String preview) throws Exception
	{
		String addToCart = ".//*[@id='add-to-cart-button']";
		clickXpath(preview);
		Thread.sleep(2000);
		clickXpath(addToCart);
		Thread.sleep(2000);
	}
	
	public void clickMenu(String locator) throws Exception
	{
		clickXpath(".//*[@id='menu-button']");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));	
		clickXpath(locator);
	}
	
	public void close()
	{
		driver.close();
	}
	
	public String getText(String locator)
	{
		String text = driver.findElement(By.xpath(locator)).getText();
		return text;
	}
	
	public void createShipment()
	{
		clickXpath(".//*[@id='main-content']/div[1]/div/div/div/div/form/div/a");
		clickXpath(".//*[@id='create_shipment']/table/tfoot/tr/th[2]/button");
		clickXpath(".//*[@id='main-content']/div[1]/div/div/div/div/form/div/button");
		
	}
	
	public void checkout() throws InterruptedException
	{
		Actions act = new Actions(driver);
		act.moveToElement(getElement(".//*[@id='navigation-basket-partial']/li/a")).click().perform();
		Thread.sleep(2000);
		clickXpath(".//*[@id='navigation-basket-partial']/li/div/a");
		clickXpath("html/body/main/div/div/div[3]/a[2]");
		getElement(".//*[@id='id_billing-name']").sendKeys("john dow");
		getElement(".//*[@id='id_billing-street']").sendKeys("123 main st");
		getElement(".//*[@id='id_billing-city']").sendKeys("burbank");
		
		Select sel = new Select(getElement(".//*[@id='id_billing-country']"));
		sel.selectByValue("US");
		
		clickXpath(".//*[@id='addresses']/div[3]/button");
		clickXpath("html/body/main/div/div[2]/button");

		clickXpath("//label[contains(@for, 'id_accept_terms')]");
		Thread.sleep(2000);
		getElement("html/body/main/div/div/form/button").submit();
		
	}
	
	
}
