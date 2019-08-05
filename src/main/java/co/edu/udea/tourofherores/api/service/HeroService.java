package co.edu.udea.tourofherores.api.service;

import co.edu.udea.tourofherores.api.model.Hero;
import co.edu.udea.tourofherores.api.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService implements HeroServiceInt {

    private HeroRepository heroRepository;

    public HeroService (HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> getHeroes() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHero(String id){
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if (posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            return null;
        }

    }

    @Override
    public Hero getHeroByName(String name){
        Optional<Hero> posibleHero = heroRepository.findByName(name);
        if (posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            return null;
        }

    }

    @Override
    public Hero addHero(Hero hero){
        return heroRepository.save(hero);
    }

    @Override
    public Hero deleteHero(String id){
        Optional<Hero> deleteHero = heroRepository.findById(id);
        if (deleteHero.isPresent()){
            heroRepository.deleteById(id);
            return deleteHero.get();
        }else {
            return null;
        }
    }

    @Override
    public Hero updateHero(Hero hero){
        Optional<Hero> updateHero = heroRepository.findById(hero.getId());
        if (updateHero.isPresent()){
            heroRepository.save(hero);
            return updateHero.get();
        }else {
            return null;
        }
    }

    @Override
    public  List<Hero> searchHeroes(String term){
        List<Hero> findedHeroes =  heroRepository.findByNameLike("%"+term+"%");
        return findedHeroes;
    }



}
