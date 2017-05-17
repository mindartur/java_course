package cacheSync;

/**
 * Created by artur on 17/05/17.
 */
public class RunThread  extends Thread{

    private static CacheEngineImpl<Integer, String> cache = new CacheEngineImpl<>(10, 100000,
            100000, false);

    public static int a;
    public String name;

    public RunThread(String name){
        this.name = name;
        super.run();
    }

    public static void example(){
        Thread thread = new RunThread("th 1");
        Thread thread1 = new RunThread("th 2");

        System.out.println("Start th1");
        thread.start();
        System.out.println("Start th2");
        thread1.start();
    }

    public void run() {

        try {

            for (int i = 0; i < 10; i++) {
                RunThread.cache.aquireLock();
                RunThread.cache.put(new MyElement<>(i, "String: " + i));
                System.out.println("String: " + i + " by " + this.name );
                Thread.sleep(1);
                RunThread.cache.releaseLock();
            }
            System.out.println(cache.get(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
