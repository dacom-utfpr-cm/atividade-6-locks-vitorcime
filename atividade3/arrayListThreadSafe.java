
import java.util.concurrent.locks.ReentrantReadWriteLock;
/**
 * arrayListThreadSafe
 */
public class arrayListThreadSafe {
    String text;
    ReentrantReadWriteLock readWriteLock;

    arrayListThreadSafe() {
        this.text = "";
        this.readWriteLock = new ReentrantReadWriteLock();
    
    }
    
    public void escrever(String text){
        this.readWriteLock.writeLock().lock();
        try {
            this.text += text;
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }
    
    
    public String ler(){
        this.readWriteLock.readLock().lock();
        try {
            return this.text;
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }
    
    
    
}