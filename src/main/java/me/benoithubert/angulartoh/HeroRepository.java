package me.benoithubert.angulartoh;

import org.springframework.data.jpa.repository.JpaRepository;

interface HeroRepository extends JpaRepository<Hero, Long> {

}