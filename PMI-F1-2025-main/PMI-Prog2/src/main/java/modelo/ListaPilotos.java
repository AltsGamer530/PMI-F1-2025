package modelo;
import java.util.ArrayList;
/**
 *
 * @author arctan
 */
public class ListaPilotos {
    private ArrayList<Piloto> lista;
    private int cantPilotos;

    public ListaPilotos() {
        this.lista = new ArrayList<Piloto>();
    }

    public ArrayList<Piloto> getLista() {
        return lista;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        this.lista = listaPilotos;
    }

    public int getCantPilotos() {
        return cantPilotos;
    }

    public void setCantPilotos(int cantPilotos) {
        this.cantPilotos = cantPilotos;
    }
    
    public Piloto buscarPilotoPorNumero(int numeroAuto){
        for(Piloto p: lista)
            if(p.getNumeroDeAuto() == numeroAuto) return p;
        return null;
    }
    
    public boolean addPiloto(Piloto p){
        Piloto paux = buscarPilotoPorNumero(p.getNumeroDeAuto());
        if(paux == null){
            lista.add(p);
            return true;
        }
        return false;
    }
    
    public boolean eliminarPiloto(int numeroAuto){
        Piloto p = buscarPilotoPorNumero(numeroAuto);
        if(p != null){
            lista.remove(p);
            return true;
        }
        return false;
    }
    
    public ListaPilotos filtrarPilotosPorPuntaje(int puntos){
        ListaPilotos filtrados = new ListaPilotos();
        for(Piloto p : this.lista){
            if(p.getPuntos() >= puntos) filtrados.addPiloto(p);
        }
        return filtrados;
    }
    
    public Piloto pilotoConMasPenalizaciones(){
        Piloto p;
        int max = 0;
        for(Piloto paux : this.lista){
            if(p.getPenalizaciones() > max) p = paux;
        }
        if(max == 0) return null;
        return p;
    }
    
}
