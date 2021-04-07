package automacaogodare.apis;

import java.util.Base64;
import java.util.Calendar;

import javax.swing.JOptionPane;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class APICaller {

	private static String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YWNhYzU4NDg1ZmVlZDAwMGY5ZjRhMmQiLCJncm91cCI6InVzZXIiLCJpYXQiOjE1NTE5MDU0ODB9.3Tdh_Pj4MNT8zk0Qf_2M_MLmUT06v088vrq_zTdnWvw";
	private static int actualTime = 0;

	public static void main(String[] args) {
		System.out.println(getActualTimeUnix());

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> result = null;
		boolean retry = true;
		while (retry) {
			try {
				result = restTemplate.exchange("http://52.67.99.123:3000/coin/info", HttpMethod.GET, setHeaders(),
						String.class);
				retry = false;
				JOptionPane.showInputDialog("Ok", token);
			} catch (Exception e) {
				try {
					Thread.sleep(10);
				} catch (Exception e2) {
				}
			}
			System.out.println(result);

		}
		System.out.println(result);
	}

	public static long getActualTimeUnix() {
		String time = Calendar.getInstance().getTimeInMillis() + "";
		return Long.parseLong(time.substring(0, time.length() - 3));
	}

	public static String getUpdatedToken(String token) {
		String[] tokenParts = token.split("\\.");
		tokenParts[1] = new String(Base64.getDecoder().decode(tokenParts[1]));

		String timeInString = tokenParts[1].split("\"iat\":")[1];
		if (actualTime == 0) {
			actualTime = (int) (getActualTimeUnix() - 1);
		} else {
			actualTime--;
		}
		tokenParts[1] = tokenParts[1].replaceAll("\"iat\"\\:.*}", "\"iat\":" + actualTime + "}");
		tokenParts[1] = Base64.getEncoder().encodeToString(tokenParts[1].getBytes());
		token = tokenParts[0] + "." + tokenParts[1] + "." + tokenParts[2];
		System.out.println(token);
		return token;
	}

	public static HttpEntity setHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", getUpdatedToken(token));
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		return new HttpEntity<String>("header", headers);
	}
}