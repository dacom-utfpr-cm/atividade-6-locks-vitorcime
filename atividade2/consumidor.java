public class consumidor extends Thread {

    sharedFifoQueue s;

    public consumidor(sharedFifoQueue s) {
        this.s = s;
    }

    @Override
    public void run() {
        int valor;
        while (true) {
            valor = this.s.getValorLista();
            System.out.println("Valor Removido: "+valor);
            try {
                Thread.sleep(valor);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }

    }



}