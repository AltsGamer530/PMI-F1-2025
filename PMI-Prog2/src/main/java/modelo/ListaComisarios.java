package modelo;

import java.util.ArrayList;

public class ListaComisarios {
    private ArrayList<ComisarioDeportivo> lista;

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
        return lista.size();
    }
    
    public ComisarioDeportivo buscarComisarioPorId(int Id){
        for(ComisarioDeportivo c: lista)
            if(c.getID() == Id) return c;
        return null;
    }
    
    public boolean addComisario(ComisarioDeportivo c){
        if(c == null) return false;
        ComisarioDeportivo caux = buscarComisarioPorId(c.getID());
        if(caux == null){
            lista.add(c);
            if(c.getID() == 0) c.setID(lista.size());
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