
public class Main {
    public static void main(String[] args) {
        SharedList sharedList = new SharedList(5);

        new Producer(sharedList);
        new Consumer(sharedList);

        System.out.println("Threads Produtora e Consumidora iniciadas.");
    }
}
