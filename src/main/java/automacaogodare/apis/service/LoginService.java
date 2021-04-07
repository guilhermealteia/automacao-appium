package automacaogodare.apis.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import automacaogodare.apis.model.login.LoginRequest;
import automacaogodare.apis.model.login.LoginResponse;

public class LoginService {
	public static LoginResponse execute(String username, String password) {
		LoginRequest loginRequest = new LoginRequest(username, password);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<LoginRequest> entity = new HttpEntity<LoginRequest>(loginRequest, headers);
		return restTemplate.exchange("http://52.67.99.123:3000/auth", HttpMethod.POST, entity, LoginResponse.class)
				.getBody();
	}

}
