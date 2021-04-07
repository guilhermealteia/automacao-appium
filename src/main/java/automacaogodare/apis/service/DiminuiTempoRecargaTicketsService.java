package automacaogodare.apis.service;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import automacaogodare.apis.model.detalhadare.DetalhaDareResponse;

public class DiminuiTempoRecargaTicketsService {
	public static void execute(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		RestTemplate restTemplate = new RestTemplate();
		
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			
			public boolean hasError(ClientHttpResponse response) throws IOException {
				// TODO Auto-generated method stub
				return false;
			}
			
			public void handleError(ClientHttpResponse response) throws IOException {
				// TODO Auto-generated method stub
				
			}
		});
		
		HttpEntity<String> entity = new HttpEntity<String>("", headers);
		restTemplate.exchange("http://52.67.99.123:3000/ticket/reduce-recharge-time", HttpMethod.POST, entity,
				DetalhaDareResponse.class).getBody();
	}

}
