package me.benoithubert.angulartoh;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
class HeroController {

  private final HeroRepository repository;

  HeroController(HeroRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
	@CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/heroes")
  List<Hero> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

	@CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/heroes")
  Hero newHero(@RequestBody Hero newHero) {
    return repository.save(newHero);
  }

  // Single item

	@CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/heroes/{id}")
  Hero one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new HeroNotFoundException(id));
  }

	@CrossOrigin(origins = "http://localhost:4200")
  @PutMapping("/heroes/{id}")
  Hero replaceHero(@RequestBody Hero newHero, @PathVariable Long id) {

    return repository.findById(id)
      .map(hero -> {
        hero.setName(newHero.getName());
        return repository.save(hero);
      })
      .orElseGet(() -> {
        newHero.setId(id);
        return repository.save(newHero);
      });
  }

	@CrossOrigin(origins = "http://localhost:4200")
  @DeleteMapping("/heroes/{id}")
  void deleteHero(@PathVariable Long id) {
    repository.deleteById(id);
  }
}