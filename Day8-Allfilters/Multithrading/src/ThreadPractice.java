public class ThreadPractice implements Runnable {

    private int a=0;
    @Override
    public void run() {

    }

    public void change()
    {
        a=10;
        System.out.println("a"+a/0);
    }
    public void change1()
    {
        a=0;
    }

}
