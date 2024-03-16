package sem_4.pract_8.Mediator;

public class TestChat {
    public static void main(String[] args) {
        TextChat textChat = new TextChat();
        Client client1 = new User(textChat, "Клиент1");
        Client client2 = new User(textChat, "Клиент2");
        Client client3 = new User(textChat, "Клиент3");

        textChat.addClient(client1);
        textChat.addClient(client2);
        textChat.addClient(client3);

        client1.sendMessage("Всем привет!");
    }
}

