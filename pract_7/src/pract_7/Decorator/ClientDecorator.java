package pract_7.Decorator;

public class ClientDecorator implements Client{
    Client client;
    public ClientDecorator(Client client) {
        this.client = client;
    }
    @Override
    public String eat(){
        return client.eat();
    }
}