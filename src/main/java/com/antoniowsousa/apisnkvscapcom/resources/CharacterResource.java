package com.antoniowsousa.apisnkvscapcom.resources;

import static com.antoniowsousa.apisnkvscapcom.constants.CharacterConstant.CHARACTERS_ENDPOINT_LOCAL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.antoniowsousa.apisnkvscapcom.services.CharacterService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@Slf4j
public class CharacterResource {
	
	@Autowired
	CharacterService characterService;
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CharacterResource.class);
	
	public CharacterResource(CharacterService characterService) {
		this.characterService = characterService;
	}
	
	//busca por todos os persoangens
	@GetMapping(CHARACTERS_ENDPOINT_LOCAL)
	@ResponseStatus(HttpStatus.OK)
	public Flux<Character> getAllItems(){
		log.info("Requesting list of all characters");
		return characterService.findAll();
	}
	
	//busca um personagem por id
	@GetMapping(CHARACTERS_ENDPOINT_LOCAL + "/{id}")
	public Mono<ResponseEntity<Character>> findByIdCharacter(@PathVariable String id){
		log.info("Requesting character by ID: {}", id);
		return characterService.findByIdCharacter(id)
				.map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//cria um novo personagem
    @PostMapping(CHARACTERS_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Character> createCharacter(@RequestBody Character character) {
    	log.info("A new character was created");
        return characterService.save(character);

    }

    //deleta um personagem
    @DeleteMapping(CHARACTERS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public Mono<HttpStatus> deletebyIDCharacter(@PathVariable String id) {
    	log.info("Deleting the character with id {}", id);
        characterService.deleteByIDCharacter(id);
        return Mono.just(HttpStatus.CONTINUE);
    }

}
