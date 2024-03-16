package sem_4.pract_7.Decorator;

public class TestDecorator {
    public static void main(String[] args) {
        Client cafeClient = new CafeClient();
        System.out.println(cafeClient.eat());

        Client critic = new Critic(cafeClient);
        System.out.println(critic.eat());
    }
}