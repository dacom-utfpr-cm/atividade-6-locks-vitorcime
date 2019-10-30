

/**
 * leitor
 */
public class leitor extends Thread {

    arrayListThreadSafe listSafe;
  

    leitor(arrayListThreadSafe listSafe) {
        this.listSafe = listSafe;
    
    }

    @Override
    public void run() {
        while (true) {
            String str = listSafe.ler();
            System.out.println("Leitor: " + str);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}