package modelo;
import java.util.ArrayList;
/**
 *
 * @author arctan
 */
public class ListaPilotos {
    private ArrayList<Piloto> listaPilotos;
    private int cantPilotos;

    public ListaPilotos() {
        this.listaPilotos = new ArrayList<Piloto>();
    }

    public ArrayList<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public int getCantPilotos() {
        return cantPilotos;
    }

    public void setCantPilotos(int cantPilotos) {
        this.cantPilotos = cantPilotos;
    }
    
    
}
