

/**
 * threadCont
 */
public class threadCont extends Thread{

    contador c;
    boolean aumentaoudiminui;

    threadCont(contador c, boolean aumentaoudiminui){
        this.c = c;
        this.aumentaoudiminui = aumentaoudiminui;
    }

    @Override
    public void run() {
        while (true) {
            c.aumentaDiminiu(aumentaoudiminui);
            System.out.println(c.num);
        }
    }
}