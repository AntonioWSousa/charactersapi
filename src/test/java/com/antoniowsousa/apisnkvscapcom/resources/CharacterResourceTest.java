package com.antoniowsousa.apisnkvscapcom.resources;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.antoniowsousa.apisnkvscapcom.repositories.CharacterRepository;
import static com.antoniowsousa.apisnkvscapcom.constants.CharacterConstant.CHARACTERS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class CharacterResourceTest {
	
	@Autowired
	WebTestClient webTestClient;

	@Autowired
	CharacterRepository characterRepository;

	@Test
	public void shouldReturnOneCharacterByTheInformedId() {
		webTestClient.get().uri(CHARACTERS_ENDPOINT_LOCAL.concat("/{id}"), "2").exchange().expectStatus().isOk()
				.expectBody();

	}

	@Test
	public void shouldReturnNotFoundWhenACharacterDoesntExists() {
		webTestClient.get().uri(CHARACTERS_ENDPOINT_LOCAL.concat("/{id}"), "30").exchange().expectStatus().isNotFound();

	}

	@Test
	public void shouldDeleteACharacter() {
		webTestClient.delete().uri(CHARACTERS_ENDPOINT_LOCAL.concat("/{id}"), "1").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isNotFound().expectBody(Void.class);

	}

}
