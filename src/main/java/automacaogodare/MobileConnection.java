package automacaogodare;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MobileConnection {

	static AppiumDriver<WebElement> driver;

	public AppiumDriver<WebElement> getNewDriverInstance(String platform) {

		int tries = 1;

		while (tries < 5) {
			try {
				killDriver();
				
				System.out.println("Tentativa nº" + tries);
				driver = getAndroid();
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
				System.out.println(driver.getSessionId());
				
				return driver;
			} catch (WebDriverException e) {
				System.out.println("Erro na tentativa nº" + tries);
				tries++;
			}
		}
		System.out.println("Connection was failed");
		return null;
	}

	private AndroidDriver<WebElement> getAndroid() {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "4100772d5f6e4000");
//		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
//		capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("relaxedSecurityEnabled" , true);
		
		try {
			return new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void killDriver(){
		try {
		driver.close();
		System.out.println("INFO: Connection closed");
		driver.quit();
		System.out.println("INFO: Connection quited");
		} catch (Exception e) {
			System.out.println("ERROR: Error trying to kill connection");
		}
	}
}
