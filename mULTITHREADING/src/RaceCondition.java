public class RaceCondition {
    private int count;
    private int[] arr;
    String s;
    Object lock;

    public RaceCondition(int capacity) {
        arr = new int[capacity];
        count = -1;
        s = new String();
        lock = new Object();
    }

    public synchronized void modify(int data) {

        if (count < arr.length) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            System.out.println(count);
            arr[count] = data;
        }
    }

    public synchronized void delete() {

        if (count == -1) {
            System.out.println("nothing to delete");
        } else {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count--;
        }
    }
};

