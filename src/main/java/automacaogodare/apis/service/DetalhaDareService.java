package automacaogodare.apis.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import automacaogodare.apis.model.detalhadare.DetalhaDareResponse;

public class DetalhaDareService {
	public static DetalhaDareResponse execute(String token, String dareId) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		return restTemplate.exchange("http://52.67.99.123:3000/dare/" + dareId, HttpMethod.GET, entity,
				DetalhaDareResponse.class).getBody();
	}

}
