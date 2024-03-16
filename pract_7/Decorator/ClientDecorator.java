package sem_4.pract_7.decorator;

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
