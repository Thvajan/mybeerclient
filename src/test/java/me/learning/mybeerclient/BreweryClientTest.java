package me.learning.mybeerclient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.learning.mybeerclient.web.client.BreweryClient;
import me.learning.mybeerclient.web.model.BeerDTO;

@SpringBootTest
public class BreweryClientTest {

	@Autowired
	BreweryClient breweryClient;

	@Test
	void getBeerById() {
		BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
		assertNotNull(beerDTO);
	}

	@Test
	void saveBeer() {
		BeerDTO beerDTO = BeerDTO.builder().beerName("TestBeer").build();
		URI uri = breweryClient.saveBeer(beerDTO);
		assertNotNull(uri);
		try {
			System.out.println(uri.toURL().toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
