package pract_7.Decorator;

public class Critic extends ClientDecorator{
    public Critic(Client client) {
        super(client);
    }
    public String makeReview(){
        return " Making review about food...";
    }
    @Override
    public String eat(){
        return super.eat() + this.makeReview();
    }
}