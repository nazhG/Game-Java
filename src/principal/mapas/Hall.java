package principal.mapas;

/**
 *
 * @author nazh_G
 */
public class Hall {
    
    public int inicio;
    public int fin;

    Hall(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Hall{" + "inicio=" + inicio + ", fin=" + fin + '}';
    }
    
}
