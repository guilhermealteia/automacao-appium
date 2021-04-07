package automacaogodare;

import java.io.IOException;

public class ChamaMetodosHillClimb extends MetodosGenericos {

	public void rodarAutomacao() {
		try {
			inicializaSessao();
			execute();
		} catch (Exception e) {
			finalizaSessao();
			e.printStackTrace();
		}
	}

	public void execute() throws IOException {
		

		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		System.out.println(deviceManufacturer);
		
		waitTime(5000L);
		swipeDown(30.0);
		waitTime(1000L);
		swipeRight(10.0);
		waitTime(1000L);
		swipeRight(10.0);
		clickByAcessibilityId("Hill Climb Racing");
		waitTime(10000L);
		
		while (true) {
			tap(Elements.getBotaoIniciarJogo(), 300);
			waitTime(5000L);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			tapAndHold(Elements.getBotaoAcelerar(), 500);
			tapAndHold(Elements.getBotaoFrear(), 500);
			
			System.out.println("Acabou sequência");
			
			tapAndHold(Elements.getBotaoFrear(), 4000);
			waitTime(12000L);
			tap(Elements.getBotaoIniciarJogo(), 300);
			waitTime(1000L);
		}
	}
}