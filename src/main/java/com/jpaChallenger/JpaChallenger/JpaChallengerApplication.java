package com.jpaChallenger.JpaChallenger;

import com.jpaChallenger.JpaChallenger.Service.Menu;
import com.jpaChallenger.JpaChallenger.repository.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaChallengerApplication implements CommandLineRunner {
	@Autowired
	SingerRepository singerRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaChallengerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu=new Menu(singerRepository);
		menu.menu();
	}
}
