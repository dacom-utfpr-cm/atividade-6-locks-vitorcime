

/**
 * main
 */
public class main {

    public static void main(String[] args) {
        arrayListThreadSafe listSafe = new arrayListThreadSafe();

        leitor l1 = new leitor(listSafe);
        leitor l2 = new leitor(listSafe);
        leitor l3 = new leitor(listSafe);

        escritor e1 = new escritor(listSafe);
        escritor e2 = new escritor(listSafe);
        escritor e3 = new escritor(listSafe);

        l1.start();
        l2.start();
        l3.start();

        e1.start();
        e2.start();
        e3.start();
    }
}