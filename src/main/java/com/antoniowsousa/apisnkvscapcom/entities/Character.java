package com.antoniowsousa.apisnkvscapcom.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@DynamoDBTable(tableName = "tb_character")
public class Character implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@DynamoDBHashKey(attributeName = "id")
	private String id;
	@DynamoDBAttribute(attributeName = "name")
	private String name;
	@DynamoDBAttribute(attributeName = "universe")
	private String universe;
	@DynamoDBAttribute(attributeName = "games")	
	private int games;
	
	public Character() {
	}

	public Character(String id, String name, String universe, int games) {
		this.id = id;
		this.name = name;
		this.universe = universe;
		this.games = games;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUniverse() {
		return universe;
	}

	public void setUniverse(String universe) {
		this.universe = universe;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}