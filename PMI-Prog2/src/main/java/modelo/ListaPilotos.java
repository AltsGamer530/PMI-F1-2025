package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

//Al final de todo estan las consultas de PILOTOS

public class ListaPilotos {
    private ArrayList<Piloto> lista;
    
    public ListaPilotos() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<Piloto> getLista() {
        return lista;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        this.lista = listaPilotos;
    }

    public int getCantPilotos() {
        return lista.size();
    }
    
    public int localizarPiloto(int numeroAuto){
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getNumeroDeAuto() == numeroAuto) return i;
        }
        return -1;
    }

    public Piloto buscarPilotoPorNumero(int numeroAuto) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNumeroDeAuto() == numeroAuto) {
                return lista.get(i);
            }
        }
        return null;
    }
    
    public Piloto buscarPilotoPorID(int id){
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i).getID() == id){
                return lista.get(i);
            }
        }
        return null;
    }
    
    public boolean addPiloto(Piloto p) {
        if (p == null) {
            return false;
        }
        Piloto paux = buscarPilotoPorNumero(p.getNumeroDeAuto());
        if (paux == null) {
            lista.add(p);
            if(p.getID() == 0) p.setID(this.getLista().size());
            return true;
        }
        return false;
    }

    public boolean eliminarPiloto(int numeroAuto) {
        Piloto p = buscarPilotoPorNumero(numeroAuto);
        if (p != null) {
            lista.remove(p);
            return true;
        }
        return false;
    }


    //CONSULTAS

    /* 
    public ListaPilotos filtrarPilotosPorPuntaje(int puntos) {
        ListaPilotos filtrados = new ListaPilotos();
        for (int i = 0; i < this.lista.size(); i++) {
            Piloto p = this.lista.get(i);
            if (p.getPuntos() >= puntos) {
                filtrados.addPiloto(p);
            }
        }
        return filtrados;
    }

    public void mostrarTodosLosPilotos() {
        if (lista.isEmpty()) {
            System.out.println("No hay pilotos cargados.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).mostrarDatosPi();
            System.out.println("--------------------");
        }
    }
    
    public int contarPilotosPorRol(String rolBuscado) {
        int count = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getRol().equalsIgnoreCase(rolBuscado)) {
                count++;
            }
        }
        return count;
    }
public Piloto pilotoConMasPenalizaciones() {
        if (lista.isEmpty()) {
            return null;
        }

        Piloto pilotoMaxPenalizaciones = lista.get(0);
        int maxPenalizaciones = lista.get(0).getPenalizaciones();

        for (int i = 1; i < this.lista.size(); i++) {
            Piloto paux = this.lista.get(i);
            if (paux.getPenalizaciones() > maxPenalizaciones) {
                maxPenalizaciones = paux.getPenalizaciones();
                pilotoMaxPenalizaciones = paux;
            }
        }
        return pilotoMaxPenalizaciones;
    } 
        */
}