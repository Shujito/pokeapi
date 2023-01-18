package org.shujito.pokeapi;

import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class PokeApiController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{pokemon}/abilities")
	public ResponseEntity<JsonNode> abilities(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("abilities"));
	}

	@GetMapping("/{pokemon}/base-experience")
	public ResponseEntity<JsonNode> baseExperiences(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("base_experience"));
	}

	@GetMapping("/{pokemon}/held-items")
	public ResponseEntity<JsonNode> heldItems(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("held_items"));
	}

	@GetMapping("/{pokemon}/id")
	public ResponseEntity<JsonNode> id(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("id"));
	}

	@GetMapping("/{pokemon}/name")
	public ResponseEntity<JsonNode> name(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("name"));
	}

	@GetMapping("/{pokemon}/location-area-encounters")
	public ResponseEntity<JsonNode> locationAreaEncounters(@PathVariable("pokemon") String pokemon) {
		Optional<JsonNode> response = Optional.ofNullable(restTemplate.getForObject(pokemon, JsonNode.class));
		return ResponseEntity.ok(response.orElseThrow().get("location_area_encounters"));
	}
}
