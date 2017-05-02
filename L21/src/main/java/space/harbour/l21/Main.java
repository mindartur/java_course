package space.harbour.l21;

/**
 * Created by artur on 2/05/17.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        long before, after;

        //int
        before = checkMemoryConsumption();
        int[] array = new int[10000000];
        System.gc();
        Thread.sleep(10);
        after = checkMemoryConsumption();
        System.out.println("Size per one int elem: " + (after-before) / 10000000.0);

        //reference
        before = checkMemoryConsumption();
        Object[] a = new Object[1000000];
        System.gc();
        Thread.sleep(10);
        after = checkMemoryConsumption();
        System.out.println("Size per one reference elem: " + (after-before) / 1000000.0);

        //object
        before = checkMemoryConsumption();
        Object[] b = new Object[1000000];
        for (int i=0; i<1000000; i++){
             b[i] = new Object();
        }

        after = checkMemoryConsumption();
        System.out.println("Size per one Object elem: " + (after-before-4*1000000.0) / 1000000.0);

        System.out.println(array);
        System.out.println(a);
    }

    public static long checkMemoryConsumption() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        long a1, a2;
        a1 = Runtime.getRuntime().totalMemory();
        a2 = Runtime.getRuntime().freeMemory();
        return a1 - a2;
    }
}