package cacheSync;

/**
 * Created by artur on 17/05/17.
 */
public class Boolean {
    private boolean lock = false;

    public boolean get(){
        return lock;
    }

    public void set(boolean state){
        lock = state;
    }

}
