/**
 * Created by xavi on 8/03/17.
 */
public class Barra {

    public static final int MAXIMO_PLATOS = 100;
    private Plato[] barra = new Plato[MAXIMO_PLATOS];
    private int proximoPlato = 0;
    private int ultimoPlato = 0;

    public synchronized Plato proximoPlato(){
        return proximoPlato < ultimoPlato ? barra[proximoPlato++] : null;
    }

    public synchronized void dejarPlato(Plato plato){
        if (ultimoPlato < MAXIMO_PLATOS ){
            barra[ultimoPlato++] = plato;
        }
    }


    public Integer platosEnEspera() {
        return ultimoPlato - proximoPlato;
    }
}
