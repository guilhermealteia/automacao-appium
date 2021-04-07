package automacaogodare.apis.service;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

public class CommonService {

	public static <T> Object exchange(HttpHeaders headers, String url, Object objectRequest, HttpMethod httpMethod) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> entity = new HttpEntity<Object>(objectRequest, headers);
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}

			public void handleError(ClientHttpResponse response) throws IOException {
				System.out.println("Erro: " + response.getBody().toString());
			}
		});
		return restTemplate.exchange(url, httpMethod, entity, Object.class).getBody();
	}

}
