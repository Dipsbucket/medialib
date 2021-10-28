package com.application.server.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.application.server.repository.UserRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class DataGenerator {

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	@Bean
	public CommandLineRunner loadData(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		return args -> {
			final Logger logger = LoggerFactory.getLogger(this.getClass());
			if (userRepository.count() != 0L) {
				logger.info("Entity : User > Using existing database");
				return;
			}
		};
	}

	// TODO JT : TEST
	// @Bean
	// public CommandLineRunner loadData(PornstarRepository pornstarRepository) {
	// return args -> {
	// final Logger logger = LoggerFactory.getLogger(this.getClass());
	// if (pornstarRepository.count() != 0L) {
	// logger.info("Entity : Pornstar > Using existing database");
	// return;
	// }
	// };
	// }
	//
	// @Bean
	// public CommandLineRunner loadData(MovieRepository movieRepository) {
	// return args -> {
	// final Logger logger = LoggerFactory.getLogger(this.getClass());
	// if (movieRepository.count() != 0L) {
	// logger.info("Entity : Movie > Using existing database");
	// return;
	// }
	// };
	// }
	//
	// @Bean
	// public CommandLineRunner loadData(DocumentaryRepository documentaryRepository) {
	// return args -> {
	// final Logger logger = LoggerFactory.getLogger(this.getClass());
	// if (documentaryRepository.count() != 0L) {
	// logger.info("Entity : Documentary > Using existing database");
	// return;
	// }
	// };
	// }
	//
	// @Bean
	// public CommandLineRunner loadData(HentaiRepository hentaiRepository) {
	// return args -> {
	// final Logger logger = LoggerFactory.getLogger(this.getClass());
	// if (hentaiRepository.count() != 0L) {
	// logger.info("Entity : Hentai > Using existing database");
	// return;
	// }
	// };
	// }

}