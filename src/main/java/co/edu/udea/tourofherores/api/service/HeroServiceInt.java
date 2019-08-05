package co.edu.udea.tourofherores.api.service;

import co.edu.udea.tourofherores.api.model.Hero;

import java.util.List;

public interface HeroServiceInt {

    public List<Hero> getHeroes();
    public Hero getHero(String id);
    public Hero getHeroByName(String name);
    public Hero addHero(Hero hero);
    public Hero deleteHero(String id );
    public Hero updateHero(Hero hero);
    public List<Hero> searchHeroes(String term);
}
