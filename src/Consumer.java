
// thread consumidora que remove números da lista
public class Consumer extends ThreadModel {
    public Consumer(SharedList sharedList) {
        super("T2-Consumidor", 2000, sharedList);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                sharedList.consume();
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}