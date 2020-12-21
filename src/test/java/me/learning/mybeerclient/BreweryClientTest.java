package me.learning.mybeerclient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

}
