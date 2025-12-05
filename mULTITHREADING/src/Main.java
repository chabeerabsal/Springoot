import java.util.concurrent.LinkedBlockingQueue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//      Thread t1 = new Thread(new Mytask());
//      Thread t2=new MyThread();
//      t1.start();
//      t2.start();
//    //  System.out.println("main thread is running");
//      for(int i=0;i<10;i++){
//          System.out.println("main thread is running");
//      }

//      RaceCondition raceCondition=new RaceCondition(5);
//      BlockingQueue blockingQueue=new BlockingQueue(5);
//      Thread t3 =new Thread(()->{
//         for(int i=0;i<5;i++){
//             try {
//                 blockingQueue.add(i);
//             } catch (InterruptedException e) {
//                 throw new RuntimeException(e);
//             }
//         }
//      });
//        t3.start();
//        Thread t4 =new Thread(()->{
//            for(int i=0;i<5;i++){
//                try {
//                    System.out.println(blockingQueue.take());
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        t4.start();
        String s1=new String();
        String s2=new String();
        Thread thread1=new Thread(()->{
            synchronized(s1){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized(s2){
                    System.out.println("thread1 is running");
                }
            }
        });
        Thread thread2=new Thread(()->{
            synchronized(s2){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized(s1){
                    System.out.println("thread1 is running");
                }
            }
        });
        thread1.start();
        thread2.start();

    }
}