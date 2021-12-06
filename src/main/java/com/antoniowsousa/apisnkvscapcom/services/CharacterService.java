package com.antoniowsousa.apisnkvscapcom.services;

import org.springframework.stereotype.Service;
import com.antoniowsousa.apisnkvscapcom.repositories.CharacterRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CharacterService {
	
	private final CharacterRepository characterRepository;
	
	public CharacterService(CharacterRepository characterRepository) {
		this.characterRepository = characterRepository;
	}

	public Flux<Character> findAll(){
		return Flux.fromIterable(this.characterRepository.findAll());
	}
	
	public Mono<Character> findByIdCharacter(String id){
		return Mono.justOrEmpty(this.characterRepository.findById(id));
	}
	
	public Mono<Character> save(Character character){
		return Mono.justOrEmpty(this.characterRepository.save(character));
	}
	
	public Mono<Boolean> deleteByIDCharacter(String id){
		characterRepository.deleteById(id);
		return Mono.just(true);
	}
	
}
