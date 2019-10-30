

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * main
 */
public class main {

    
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        int num = 0;
        
        contador c = new contador(l, num);

        
        threadCont t1 = new threadCont(c, true);
        threadCont t2 = new threadCont(c, false);
        threadCont t3 = new threadCont(c, true);

        t1.start();
        t2.start();
        t3.start();
    }
}