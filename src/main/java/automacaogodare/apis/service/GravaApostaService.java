package automacaogodare.apis.service;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import automacaogodare.apis.model.gravaaposta.GravaApostaRequest;
import automacaogodare.apis.model.gravaaposta.GravaApostaResponse;

public class GravaApostaService {
	public static GravaApostaResponse execute(String token, String dareId, String alternative) {
		GravaApostaRequest gravaApostaRequest = new GravaApostaRequest(alternative);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		headers.add("Authorization", "Bearer " + token);
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<GravaApostaRequest> entity = new HttpEntity<GravaApostaRequest>(gravaApostaRequest, headers);
		
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}
			
			public void handleError(ClientHttpResponse response) throws IOException {
				System.out.println("Erro: " + response.getBody().toString());
			}
		});
		return restTemplate.exchange("http://52.67.99.123:3000/dare/" + dareId + "/join", HttpMethod.POST, entity,
				GravaApostaResponse.class).getBody();
	}

}
