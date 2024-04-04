package pract_6.AbstractFactory;

public class CharactersFactory implements AbstractCharactersFactory {
    public Hero createHero(){
        return new Hero();
    }
    public Villain createVillain(){
        return new Villain();
    }
}
