import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavi on 8/03/17.
 */
public class Jefe implements Runnable{

    private List<Thread> cocineros = new ArrayList<Thread>();
    private List<Thread> camareros = new ArrayList<Thread>();

    public static void main(String[] args) {
        Thread thread = new Thread(new Jefe());

        thread.start();
    }


    public void run() {

        Barra barra = new Barra();

        Cocinero cocinero1 = new Cocinero();
        cocinero1.setBarra(barra);

        Cocinero cocinero2 = new Cocinero();
        cocinero2.setBarra(barra);

        cocineros.add(new Thread(cocinero1));
        cocineros.add(new Thread(cocinero2));

        Camarero camarero1 = new Camarero();
        camarero1.setBarra(barra);

        Camarero camarero2 = new Camarero();
        camarero2.setBarra(barra);

        Camarero camarero3 = new Camarero();
        camarero3.setBarra(barra);

        Camarero camarero4 = new Camarero();
        camarero4.setBarra(barra);

        camareros.add(new Thread(camarero1));
        camareros.add(new Thread(camarero2));
        camareros.add(new Thread(camarero3));
        camareros.add(new Thread(camarero4));

        //arrancamos cocineros
        for (Thread t : cocineros){
            t.start();
        }

        //arrancamos camareros
        for (Thread t : camareros){
            t.start();
        }

        //esperamos a que los cocineros terminen
        for (Thread t : cocineros){
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        camarero1.setTrabajar(false);
        camarero2.setTrabajar(false);
        camarero3.setTrabajar(false);
        camarero4.setTrabajar(false);


    }

}
