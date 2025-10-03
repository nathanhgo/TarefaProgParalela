public class ThreadModel implements Runnable {

    protected String message = "Thread";
    protected int time = 1000;
    protected SharedList sharedList;

    public ThreadModel(String message, int time, SharedList sharedList) {
        this.message = message;
        this.time = time;
        this.sharedList = sharedList;
        new Thread(this, message).start();
    }

    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {
            System.out.println(message + ": " + i);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                
            }
            
        }
    }
}