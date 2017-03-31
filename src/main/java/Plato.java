/**
 * Created by xavi on 8/03/17.
 */
public class Plato {

    private String nombre;
    private Long instanteEnLaBarra;
    private Long tiempoDeEsperaEnBarra;

    public Long getTiempoDeEsperaEnBarra() {
        return tiempoDeEsperaEnBarra;
    }

    public void setTiempoDeEsperaEnBarra(Long tiempoDeEsperaEnBarra) {
        this.tiempoDeEsperaEnBarra = tiempoDeEsperaEnBarra;
    }

    public Long getInstanteEnLaBarra() {
        return instanteEnLaBarra;
    }

    public void setInstanteEnLaBarra(Long instanteEnLaBarra) {
        this.instanteEnLaBarra = instanteEnLaBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
