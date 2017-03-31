

/**
 * Created by xavi on 8/03/17.
 */
public class Camarero implements Runnable {

    public static final int MINIMO_COMENSALES = 12;
    public static final int MINIMO_SERVIR_PLATO = 6;
    public static final int INCREMENTO_SERVIR_PLATO = 18;
    public static final int INCREMENTO_COMENSALES = 48;
    private Barra barra;
    private boolean trabajar = true;
    private long tiempoAtendiendo;
    private int contadorLog;

    public void run() {

        message("Hola, soy camarero!");

        while (trabajar){

            Plato plato = barra.proximoPlato();

            if (plato == null){
                atenderComensales();
            } else {
                servirPlato(plato);
            }

        }

    }

    private void servirPlato(Plato plato) {
        double time = MINIMO_SERVIR_PLATO + (Math.random() * INCREMENTO_SERVIR_PLATO);
        try {
            Thread.sleep((long) time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        message("Tiempo plato: " + (System.currentTimeMillis() - plato.getInstanteEnLaBarra())/1000 );

    }

    private void atenderComensales() {
        double time = MINIMO_COMENSALES + (Math.random() * INCREMENTO_COMENSALES);
        try {
            Thread.sleep((long) time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tiempoAtendiendo += time;
        contadorLog +=1;
        message(" Tiempo Atendiendo: " + tiempoAtendiendo);
    }

    private void  message(String str){
        System.out.println(Thread.currentThread().getName() + " " + str);
    }

    public void setBarra(Barra barra) {
        this.barra = barra;
    }

    public void setTrabajar(boolean trabajar) {
        this.trabajar = trabajar;
    }
}
