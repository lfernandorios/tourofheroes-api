package co.edu.udea.tourofherores.api.controller;

import co.edu.udea.tourofherores.api.model.Hero;
import co.edu.udea.tourofherores.api.service.HeroServiceInt;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tour-heroes")
public class HeroController {

    private HeroServiceInt heroService;

    public HeroController (HeroServiceInt heroService){
        this.heroService = heroService;
    }

    @GetMapping
        public ResponseEntity<List<Hero>> getHeroes(){
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") String id){
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Hero> getHeroByName(@PathVariable("name") String name){
        return ResponseEntity.ok(heroService.getHeroByName(name));
    }

    @PostMapping("")
    public ResponseEntity<Hero> addHero(Hero hero){
        return ResponseEntity.ok(heroService.addHero(hero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hero> deleteHero(@PathVariable("id") String id){
        return ResponseEntity.ok(heroService.deleteHero(id));
    }

    //@PostMapping("/actualizar")
    @PutMapping()
    public ResponseEntity<Hero> updateHero(Hero hero){
        return ResponseEntity.ok(heroService.updateHero(hero));
    }

    @GetMapping("/buscar/{term}")
    public ResponseEntity<List<Hero>> searchHeroes(@PathVariable("term") String term){
        return ResponseEntity.ok(heroService.searchHeroes(term));
    }

}
