package me.learning.mybeerclient.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import me.learning.mybeerclient.web.model.BeerDTO;

@Component
@ConfigurationProperties(value = "mybrewery", ignoreUnknownFields = false)
public class BreweryClient {

	public final String BEER_PATH_V1 = "/api/v1/beer/";
	private String apiHost;

	public final RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}

	public BeerDTO getBeerById(UUID uuid) {
		return restTemplate.getForObject(apiHost + BEER_PATH_V1 + uuid.toString(), BeerDTO.class);
	}

	public void setApiHost(String apiHost) {
		this.apiHost = apiHost;
	}
}
