package org.shujito.pokeapi;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@Configuration
public class PokeApiRestTemplate {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
			.setConnectTimeout(Duration.ofSeconds(5))
			.setReadTimeout(Duration.ofSeconds(5))
			.uriTemplateHandler(new DefaultUriBuilderFactory("https://pokeapi.co/api/v2/pokemon/"))
			.build();
	}
}
