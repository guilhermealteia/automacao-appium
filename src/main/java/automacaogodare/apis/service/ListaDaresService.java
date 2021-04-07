package automacaogodare.apis.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import automacaogodare.apis.model.listadares.ListaDaresResponse;

public class ListaDaresService {
	public static ListaDaresResponse execute(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		return restTemplate.exchange("http://52.67.99.123:3000/dare?page=1&filters=new", HttpMethod.GET, entity,
				ListaDaresResponse.class).getBody();
	}

}
