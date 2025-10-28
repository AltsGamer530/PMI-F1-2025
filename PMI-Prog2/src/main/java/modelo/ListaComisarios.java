package modelo;
import java.util.ArrayList;

/**
 *
 * @author arctan
 */
public class ListaComisarios {
    private ArrayList<ComisarioDeportivo> lista;
    private int cantComisarios;

    public ListaComisarios() {
        this.lista = new ArrayList<ComisarioDeportivo>();
    }

    public ArrayList<ComisarioDeportivo> getLista() {
        return lista;
    }

    public void setListaComisarios(ArrayList<ComisarioDeportivo> lista) {
        this.lista = lista;
    }

    public int getCantComisarios() {
        return cantComisarios;
    }

    public void setCantComisairos(int cantComisarios) {
        this.cantComisarios = cantComisarios;
    }
    
    
    
    public ComisarioDeportivo buscarComisarioPorId(int Id){
        for(ComisarioDeportivo c: lista)
            if(c.getId() == Id) return c;
        return null;
    }
    
    public boolean addComisario(ComisarioDeportivo c){
        ComisarioDeportivo caux = buscarComisarioPorId(c.getId());
        if(caux == null){
            lista.add(c);
            return true;
        }
        return false;
    }
    
    public boolean eliminarComisario(int Id){
        ComisarioDeportivo c = buscarComisarioPorId(Id);
        if(c != null){
            lista.remove(c);
            return true;
        }
        return false;
    }
    
    
}
