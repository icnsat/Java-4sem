package pract_6.AbstractFactory;


public class Client implements Character {
    public Character character;
    public void play() {
        if (character instanceof Hero) {
            Hero hero = (Hero) character;
            hero.doGood();
        } else {
            Villain villain = (Villain) character;
            villain.doBad();
        }
    }
    public void setCharacter(Character character){
        this.character = character;
    }

    public static void main(String[] args) {
        CharactersFactory factory = new CharactersFactory();

        Client client = new Client();

        Character villain = factory.createVillain();
        Character hero = factory.createHero();

        client.setCharacter(villain);
        client.play();

        client.setCharacter(hero);
        client.play();
    }
}