/**
 * Created by xavi on 8/03/17.
 */
public class Cocinero implements Runnable {

    private static final int NUMERO_MAX_PLATOS = 100;
    public static final int MINIMO_COCCION = 6;
    public static final int INCREMENTO_COCCION = 3;
    private Barra barra;

    public void run() {

        message("Preparo cuchillos");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int numPlatos = 0; numPlatos < NUMERO_MAX_PLATOS; numPlatos++) {

            Plato plato = new Plato();
            //Cocinamos
            message(" Cocinando...");
            double coccion = MINIMO_COCCION + (Math.random() * INCREMENTO_COCCION);
            try {
                Thread.sleep((long) (coccion * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            message("********************************* Cocinado!");
            plato.setInstanteEnLaBarra(System.currentTimeMillis());
            barra.dejarPlato(plato);

            message(">>>> Platos en espera: " + barra.platosEnEspera());
        }

    }

    private void message(String str) {
        System.out.println(Thread.currentThread().getName() + str);
    }

    public Barra getBarra() {
        return barra;
    }

    public void setBarra(Barra barra) {
        this.barra = barra;
    }
}
