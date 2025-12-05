public class Mytask implements Runnable{
    @Override
    public void run() {
        System.out.println("Running thread using interface");
        for(int i=0;i<10;i++){
            System.out.println(" thread2 is running");
        }
    }
}
