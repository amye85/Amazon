package com.amazon.base;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBaseTest {
	public static WebDriver driver;
	public static ChromeOptions chromCaps;
	public static EdgeOptions edgeCaps;
	private static final long Long_Five = 5;
    private static final long Long_NINTY = 90;
    private static final int PROXY_PORT_INT=8080;
    private static final String PROXY_SERVER= "www.amazon.ad.bd.sandbox";
    private static final String gridServerURL="www.amazon.ad.bd.sandbox";
    private static final String APPURL= "https://www.amazon.com/";
    
    public static WebDriver chrome() {
     chromCaps= new ChromeOptions();
     chromCaps.setCapability("EnableNativeEvent", false);
     chromCaps.setCapability("ignoreZoomSetting", true);
     chromCaps.setCapability("ignoreProtectedMoodSetting", false);
     chromCaps.addArguments("enable-automation");
     chromCaps.addArguments("-- disable-extentions");
     chromCaps.addArguments("--dns-prefetch-disable");
     chromCaps.addArguments("--disable-gpu");
     chromCaps.addArguments("--long-level=3");
     chromCaps.addArguments("--silent");
     chromCaps.setPageLoadStrategy(PageLoadStrategy.EAGER);
     
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver(chromCaps);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long_Five));
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long_NINTY));
     driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(Long_Five));
     driver.get(APPURL);
     driver.manage().window().maximize();
     return driver;
    }
    
    public static WebDriver chromeRemoteServer()throws MalformedURLException{
    Proxy proxy=new Proxy();
    proxy.setSslProxy(PROXY_SERVER+ ":" + PROXY_PORT_INT);
    proxy.setHttpProxy(PROXY_SERVER+ ":" +PROXY_PORT_INT );
    proxy.setFtpProxy(PROXY_SERVER+ ":" + PROXY_PORT_INT);
     ChromeOptions options= new ChromeOptions();
     options.setCapability("proxy", proxy);
     driver= new RemoteWebDriver(new URL(gridServerURL),options);
     ((RemoteWebDriver)driver).setFileDetector(new LocalFileDetector());    
   
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long_Five));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long_NINTY));
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(Long_Five));
		driver.get(APPURL);
		driver.manage().window().maximize();
		return driver;
    }
		public static WebDriver edge() {
			edgeCaps = new EdgeOptions();
			edgeCaps.setCapability("EnableNativeEvent", false);
			edgeCaps.setCapability("ignoreZoomSetting", true);
			edgeCaps.setCapability("ignoreProtectedMoodSetting", false);
			edgeCaps.addArguments("enable-automation");
			edgeCaps.addArguments("--disable-extentions");
			edgeCaps.addArguments("--dns-prefetch-disable");
			edgeCaps.addArguments("--disable-gpu");
			edgeCaps.addArguments("--long-level=3");
			edgeCaps.addArguments("--silent");
			edgeCaps.setPageLoadStrategy(PageLoadStrategy.EAGER);
			

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeCaps);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long_Five));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long_NINTY));
			driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(Long_Five));
			driver.get(APPURL);
			driver.manage().window().maximize();
			return driver;
           
		}
		public boolean isDriverNull() {
			if (driver== null) {
				System.out.println("driver null");
				return true;
			}else {
				System.out.println("driver exist");
				return false;
			}
		}
		
		public void closeApplication() {
			
		    if(isDriverNull()==false) {
		    	driver.quit();
		    }
		
		}	
	
    
    
    
    
    
    
    
    
}
