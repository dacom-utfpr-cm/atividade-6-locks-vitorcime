

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * contador
 */
public class contador {

    Lock l = new ReentrantLock();
    int num;
   

    contador(Lock l, int num){
        this.l = l;
        this.num = num;
        
    }

    public void aumentaDiminiu(boolean contador){
        this.l.lock();
        try{
            if (contador){
                this.num++;
            }
            else{
                this.num--;
            }
        }
        finally{
            this.l.unlock();
        }
    }
}