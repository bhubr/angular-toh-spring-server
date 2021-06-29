package me.benoithubert.angulartoh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(HeroRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Hero("Dr Nice")));
      log.info("Preloading " + repository.save(new Hero("Narco")));
      log.info("Preloading " + repository.save(new Hero("Bombasto")));
      log.info("Preloading " + repository.save(new Hero("Celeritas")));
      log.info("Preloading " + repository.save(new Hero("Magneta")));
      log.info("Preloading " + repository.save(new Hero("RubberMan")));
      log.info("Preloading " + repository.save(new Hero("Dynama")));
      log.info("Preloading " + repository.save(new Hero("Dr IQ")));
      log.info("Preloading " + repository.save(new Hero("Magma")));
      log.info("Preloading " + repository.save(new Hero("Tornado")));
    };
  }
}