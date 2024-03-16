package sem_4.pract_8.Mediator;

public class User implements Client{
    private Chat chat;
    String name;
    public User(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }

    @Override
    public void sendMessage(String text) {
        chat.sendMessage(text, this);
    }
    @Override
    public void getMessage(String text) {
        System.out.println(this.name + " получил(а): " + text);
    }
}
