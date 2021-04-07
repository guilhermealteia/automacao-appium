package automacaogodare;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MetodosGenericos extends MobileConnection {

	private static final int DEFAULT_TIME_TO_WAIT_FOR_ELEMENT = 2;
	public static AppiumDriver<WebElement> driver;

	public void inicializaSessao() {
		System.out.println("Iniciando sessão: " + getActualTime());
		MobileConnection mobileConnection = new MobileConnection();
		driver = mobileConnection.getNewDriverInstance("Android");
		setContextName();
		System.out.println("deviceManufacturer: " + driver.getCapabilities().getCapability("deviceManufacturer"));
	}

	public static void println(String text) {
		Date date = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println(sdf.format(date) + " - " + text);
	}

	public void finalizaSessao() {
		try {
			driver.quit();
			driver.close();
		} catch (Exception e) {
		}
	}

	public void lockScreen() {
		try {
			Runtime.getRuntime().exec("adb shell input keyevent 26");
		} catch (Exception e) {
			try {
				Runtime.getRuntime().exec("/Users/guilhermealteia/Android/platform-tools/adb shell input keyevent 26");
			} catch (Exception e2) {
			}
		}
		waitTime(1000);
	}

	public static void waitTime(long time) {
		try {
			Thread.sleep((long) time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void waitRandomTime(long time) {
		try {
			long leftLimit = 4000L;
		    long rightLimit = time;
		    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		    System.out.println(generatedLong);
			Thread.sleep((long) generatedLong);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int porcentagem(Double value, Double percentual) {
		return (int) (value * (percentual / 100));
	}

	public boolean isAvailableByClassNameAndContentDesc(String className, String contentDesc) {

		List<WebElement> arrayOfProperties2 = driver.findElementsByClassName("android.widget.TextView");

		for (WebElement w : arrayOfProperties2) {
			try {
				if (contentDesc.equals(w.getAttribute("content-desc"))) {
					return true;
				}
			} catch (NoSuchElementException e) {
			}
		}
		return false;
	}

	public void back() {
		driver.navigate().back();
		waitTime(3000);
	}

	public void backNoWait() {
		driver.navigate().back();
		waitTime(3000);
	}

	public void click(By by) {
		driver.findElement(by).click();
	}

	public void clickByAcessibilityId(String by) {
		driver.findElementsByAccessibilityId(by).get(0).click();
	}

	@SuppressWarnings("rawtypes")
	public void tap(int[] position) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(position[0], position[1])).perform();
		waitTime(2000);
	}

	@SuppressWarnings("rawtypes")
	public void tap(int[] position, int velocity) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(position[0], position[1])).perform();
		waitTime(velocity);
	}

	@SuppressWarnings("rawtypes")
	public void tapAndHold(int[] position, int velocity) {
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(LongPressOptions.longPressOptions()
				.withPosition(PointOption.point(position[0], position[1])).withDuration(Duration.ofMillis(velocity)))
				.perform();
		touchAction.release();
	}

	@SuppressWarnings("rawtypes")
	public void swipeDown(Double percent) {

		TouchAction swipe = new TouchAction(driver)
				.press(PointOption.point(porcentagem(Elements.x, 50.0), porcentagem(Elements.x, 10.0)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L)))
				.moveTo(PointOption.point(porcentagem(Elements.x, 50.0), porcentagem(Elements.x, percent))).release();
		swipe.perform();
	}

	@SuppressWarnings("rawtypes")
	public void swipeUp(Double percent) {
		
		long timeBeteweenActions = 200L;

		new TouchAction(driver)
				.press(PointOption.point(porcentagem(Elements.x, 50.0), porcentagem(Elements.y, 80.0)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeBeteweenActions)))
				.moveTo(PointOption.point(porcentagem(Elements.x, 50.0), porcentagem(Elements.y, 10.0)))
				.release().perform();
		System.out.println();
	}

	@SuppressWarnings("rawtypes")
	public void swipeRight(Double percent) {

		TouchAction swipe = new TouchAction(driver)
				.press(PointOption.point(porcentagem(Elements.x, 50.0), porcentagem(Elements.y, 50.0)))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L)))
				.moveTo(PointOption.point(porcentagem(Elements.x, percent), porcentagem(Elements.y, 50.0))).release();
		swipe.perform();
	}

	public void writeText(String text) {
		try {
			Runtime.getRuntime().exec("adb shell input text " + text);
		} catch (Exception e) {
			try {
				Runtime.getRuntime().exec("/Users/guilhermealteia/Android/platform-tools/adb shell input text " + text);
			} catch (Exception e2) {
			}
		}
		waitTime(1000);
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		for (int i = 0; i < 2; i++) {
			try {
				FluentWait<WebDriver> wait = new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT_FOR_ELEMENT);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				System.out.println("Elemento encontrado");
			} catch (Exception e) {
				System.out.println("Elemento não encontrado. Tentando novamente");
			}
		}
		return element;
	}

	public WebElement waitForElementToBeSelectable(WebElement element, String text) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT_FOR_ELEMENT);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		return element;
	}

	public static void setContextName() {
		Set<String> contextNames = driver.getContextHandles();
		for (String s : contextNames) {
			driver.context("NATIVE_APP");
			System.out.println(s);
		}
	}

	public static long ramdomTime(int bound) {
		int i = new Random().nextInt(bound);
		if (i < 0) {
			i = i * -1;
		}
		return i;
	}

	private String getActualTime() {
		Calendar c = Calendar.getInstance(Locale.forLanguageTag("pt"));
		return c.getTime().toString();
	}

}
