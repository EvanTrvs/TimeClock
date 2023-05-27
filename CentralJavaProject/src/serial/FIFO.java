package serial;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    private Queue<Timeclock> queue;

    public FIFO() {
        queue = new LinkedList<>();
    }

    public void enqueue(Timeclock item) {
        queue.add(item);
    }

    public Timeclock dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La file est vide.");
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
