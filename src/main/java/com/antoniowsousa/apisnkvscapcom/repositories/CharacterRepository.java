package com.antoniowsousa.apisnkvscapcom.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableScan
public interface CharacterRepository extends CrudRepository<Character, String>{

}
