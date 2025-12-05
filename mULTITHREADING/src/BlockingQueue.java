import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> q;
    int capacity;
    BlockingQueue(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<>();

    }

    public synchronized  void add(int data) throws InterruptedException {
        while(capacity==q.size()){
            wait();
        }
        q.add(data);
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        while(capacity==0){
            wait();
        }
        int data = q.poll();
        notifyAll();
        return data;
    }
}
