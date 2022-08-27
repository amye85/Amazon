package com.amazon.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonBasePage {
 protected WebDriver driver;

public AmazonBasePage(WebDriver driver) {
	this.driver = driver;
}

public WebElement getWebElement(By locator) {
  return driver.findElement(locator);
}
 public WebElement getSendKey(By locator, String input) {
      WebElement element= getWebElement(locator);
      element.sendKeys(input);
	return element;


 }
 public WebElement getClear(By locator) {
WebElement element= getWebElement(locator);
element.clear();
return element;


}
 public WebElement getClick(By locator) {
	 WebElement element= getWebElement(locator);
	 element.click();
	return element;
	 
 }
 public String getText(By locator) {
	 String text= null;
	 text= driver.findElement(locator).getText();
	return text;
}
}