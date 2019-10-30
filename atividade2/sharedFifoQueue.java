import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * sharedFifoQueue
 */
public class sharedFifoQueue {

    ArrayList<Integer> lista;
    int tamLista;
    Lock lock;
    Condition notFull;
    Condition notEmpty;

    public sharedFifoQueue(int tamLista) {
        this.lista = new ArrayList<>();
        this.tamLista = tamLista;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public int getValorLista() {
        int valor=-1;
        this.lock.lock();
        
        try {
            while(this.lista.size() <= 0){
                System.out.println("Thread Consu. Esperando...");
                this.notEmpty.await();
            }
            
            valor = this.lista.get(0);
            this.lista.remove(0);
            this.tamLista--;
            this.notFull.signal();
            
        } catch (InterruptedException ex) {
            System.out.println("Erro para o consumidor");
        } finally {
            this.lock.unlock();
        }
        return valor; 
    }

    public void setValorLista(int valor) {
        this.lock.lock();
        try {
            while (this.lista.size() >= this.tamLista) {
                System.out.println("Thread Prod. Esperando...");
                this.notFull.await();
            }

            this.tamLista++;
            this.lista.add(valor);
            this.notEmpty.signal();

        } catch (InterruptedException ex) {
            System.out.println("Erro para o produtor");
        } finally {
            this.lock.unlock();
        }
    }
    
    
}