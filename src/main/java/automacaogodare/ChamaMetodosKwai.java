package automacaogodare;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy.ByAccessibilityId;

public class ChamaMetodosKwai extends MetodosGenericos {

	public void rodarAutomacao() {
		while (true) {
			try {
				inicializaSessao();
				execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			finalizaSessao();
		}
	}

	public void execute() throws IOException {
		LocalDateTime actualTime = LocalDateTime.now();

		back();
		back();
		clickByAcessibilityId("Kwai");
		waitTime(5000L);

		while (LocalDateTime.now().isBefore(actualTime.plusMinutes(5))) {
			assistirVídeos();
		}
		
		backNoWait();
		backNoWait();
	}

	private void assistirVídeos() {
//		if (isAvailableById("com.kwai.video:id/close_button")) {
//			click(By.id("com.kwai.video:id/close_button"));
//		}
		clickIfAvailable("com.kwai.video:id/iv_home_bottom_icon");
		waitRandomTime(12000L);
		swipeUp(40.0);
	}

	private void verificarRecompensaDiaria() {
		clickIfAvailable("com.kwai.video:id/me_layout");
		clickIfAvailable("com.kwai.video:id/fission_task_entry");

		WebElement we = getByClassNameAndContentDescCointainingText("android.view.View", "Receber  ");
		if (!Objects.isNull(we)) {
			we.click();
		}

		waitForElement(ByAccessibilityId.AccessibilityId("FAQ"), 20);

		waitTime(3000L);

		swipeUp(40.0);

		tapByFixedXAndYPoint(driver.findElementByAccessibilityId("Recompensa diária").getLocation(), 90.0);

		back();
	}
}