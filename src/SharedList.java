import java.util.LinkedList;
import java.util.List;

public class SharedList {
    private List<Integer> list = new LinkedList<>(); // Região crítica acessada por várias threads
    private final int capacity;

    public SharedList(int capacity) {
        this.capacity = capacity;
    }

    // synchronized garante que somente uma thread pode acessar o método por vez (evita race condition)
    public synchronized void produce(int value) throws InterruptedException {
        while (list.size() == capacity) {
            System.out.println("Lista cheia. Produtor (" + Thread.currentThread().getName() + ") esperando...");
            wait();
        }
        list.add(value);
        System.out.println("Produtor (" + Thread.currentThread().getName() + ") produziu: " + value);
        notifyAll(); // sistema que notifica thread produtora ou consumidora que está esperando
    }

    // synchronized garante que somente uma thread pode acessar o método por vez (evita race condition)
    public synchronized int consume() throws InterruptedException {
        while (list.isEmpty()) {
            System.out.println("Lista vazia. Consumidor (" + Thread.currentThread().getName() + ") esperando...");
            wait();
        }
        int value = list.remove(0);
        System.out.println("Consumidor (" + Thread.currentThread().getName() + ") consumiu: " + value);
        notifyAll(); // sistema que notifica thread produtora ou consumidora que está esperando
        return value;
    }
}
