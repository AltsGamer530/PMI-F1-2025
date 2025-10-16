package modelo;

import controlador.Controlador;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Piloto> lista = Controlador.cargarPilotosDeArchivo();
        for(Piloto p : lista){
            System.out.println("---------------------------");
            p.mostrarDatosPi();
        }       
    }
}