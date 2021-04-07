package automacaogodare;

public class Elements extends MetodosGenericos {

	public static Double x = driver.manage().window().getSize().getWidth() * 1.0;
	public static Double y = driver.manage().window().getSize().getHeight() * 1.0;

	public static int[] getBotaoEntrarPricipal() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 90.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 90.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 90.0) };
		}
	}

	public static int[] getCampoUsuario() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 48.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 48.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 48.0) };
		}
	}
	
	public static int[] getNumero5TelaBloqueio() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 60.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 60.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 60.0) };
		}
	}
	
	public static int[] getBotaoOKTelaBloqueio() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 80.0), porcentagem((double) y, 80.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 80.0), porcentagem((double) y, 80.0) };
		} else {
			return new int[] { porcentagem((double) x, 80.0), porcentagem((double) y, 80.0) };
		}
	}

	public static int[] getCampoSenha() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 52.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 52.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 52.0) };
		}
	}

	public static int[] getBotaoLogar() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 60.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 60.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 65.0) };
		}
	}

	public static int[] getCheckBoxTermos() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 20.0), porcentagem((double) y, 76.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 20.0), porcentagem((double) y, 76.0) };
		} else {
			return new int[] { porcentagem((double) x, 15.0), porcentagem((double) y, 81.0) };
		}
	}

	public static int[] getBotaoOkTermos() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 85.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 85.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 85.0) };
		}
	}

	public static int[] getBotaoAcessarRecargas() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 3.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 3.0) };
		} else {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 3.0) };
		}
	}

	public static int[] getBotaoRecargaMoedas() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 50.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 50.0) };
		} else {
			return new int[] { porcentagem((double) x, 47.0), porcentagem((double) y, 50.0) };
		}
	}
	
	public static int[] getBotaoRecargaMoedasComVideo() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 50.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 50.0) };
		} else {
			return new int[] { porcentagem((double) x, 50.0), porcentagem((double) y, 47.0) };
		}
	}
	
	public static int[] getBotaoSairVideo() {
		String deviceManufacturer = driver.getCapabilities().getCapability("deviceManufacturer").toString();
		if ("LENOVO".equals(deviceManufacturer) || "asus".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 5.0) };
		} else if ("acer".equals(deviceManufacturer)) {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 5.0) };
		} else {
			return new int[] { porcentagem((double) x, 90.0), porcentagem((double) y, 5.0) };
		}
	}
	
	public static int[] getBotaoIniciarJogo() {
		return new int[] { 1660, 750 };
	}
	
	public static int[] getBotaoAcelerar() {
		return new int[] { 1962, 874 };
	}
	
	public static int[] getBotaoFrear() {
		return new int[] { 250, 920 };
	}
}