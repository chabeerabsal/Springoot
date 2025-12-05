public class MyThread extends Thread{
    public void run(){
        System.out.println("Running thread using extend");
        for(int i=0;i<10;i++){
            System.out.println(" thread1 is running");
        }
    }
}
