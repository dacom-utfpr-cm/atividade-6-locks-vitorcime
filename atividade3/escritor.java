



/**
 * escritor
 */
public class escritor extends Thread {

    arrayListThreadSafe listSafe;
    

    public escritor(arrayListThreadSafe listSafe) {
        this.listSafe = listSafe;
        
    }

    @Override
    public void run() {
        while (true) {
            this.listSafe.escrever("mensagem ");
            System.out.println("Escrevi");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    
}