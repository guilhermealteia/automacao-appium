package automacaogodare;

import java.io.IOException;

import org.openqa.selenium.By;

public class ChamaMetodosKwai extends MetodosGenericos {

	public void rodarAutomacao() {
		while (true) {
			try {
				inicializaSessao();
				execute();
			} catch (Exception e) {
				finalizaSessao();
				e.printStackTrace();
			}
		}
	}

	public void execute() throws IOException {

		backNoWait();
		backNoWait();
		clickByAcessibilityId("Kwai");
		waitTime(3000L);

		click(By.id("com.kwai.video:id/iv_home_bottom_icon"));

		while (true) {
			assistirVídeos();
		}

//		
//		
//		while (true) {
//			swipeUp(10.0);
//		}

//			tap(Elements.getBotaoIniciarJogo(), 300);
//			waitTime(5000L);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			tapAndHold(Elements.getBotaoAcelerar(), 500);
//			tapAndHold(Elements.getBotaoFrear(), 500);
//			
//			System.out.println("Acabou sequência");
//			
//			tapAndHold(Elements.getBotaoFrear(), 4000);
//			waitTime(12000L);
//			tap(Elements.getBotaoIniciarJogo(), 300);
//			waitTime(1000L);
//		}
	}

	private void assistirVídeos() {
		swipeUp(40.0);
		waitRandomTime(12000L);
	}
}