package me.benoithubert.angulartoh;

class HeroNotFoundException extends RuntimeException {

  HeroNotFoundException(Long id) {
    super("Could not find hero " + id);
  }
}