
/**
 * main
 */
public class main {

    public static void main(String[] args) {
        sharedFifoQueue s = new sharedFifoQueue(10);

        produtor prod = new produtor(s);
        consumidor cons = new consumidor(s);
        
        prod.start();
        cons.start();
    }
}