

import java.util.Random;

public class produtor extends Thread {

    sharedFifoQueue s;
    Random gerador;

    public produtor(sharedFifoQueue s) {
        this.gerador = new Random();
        this.s = s;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.gerador.nextInt(9) + 1;
            s.setValorLista(valor);
            System.out.println("Valor Inserido: " + valor);
            try {
                Thread.sleep(valor);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
    


}