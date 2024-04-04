package pract_8.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat{
    private List<Client> clients = new ArrayList<>();
    public void addClient(Client client){
        this.clients.add(client);
    }
    @Override
    public void sendMessage(String text, Client client) {
        for (Client c: clients){
            if (c != client)
                c.getMessage(text);
        }
    }
}
