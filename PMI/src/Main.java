import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Piloto> lista = GestorArchivos.cargarPilotos();
        for(Piloto p : lista){
            System.out.println("---------------------------");
            p.mostrarDatosPi();
        }



        
    }
}