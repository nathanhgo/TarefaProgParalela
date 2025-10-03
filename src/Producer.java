import java.util.Random;

// thread produtora que adiciona números a lista
public class Producer extends ThreadModel {
    public Producer(SharedList sharedList) {
        super("T1-Produtor", 1000, sharedList);
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            try {
                int valueToProduce = random.nextInt(100);
                sharedList.produce(valueToProduce);
                Thread.sleep(time);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}