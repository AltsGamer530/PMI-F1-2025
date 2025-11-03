package modelo;

import java.util.ArrayList;

//Cambie el nombre a ListaEquipos !!!!!!ANOTAR PARA QUE EL TANSI SEPA!!!!!!!!!!!!
//nashe
public class ListaEquipos {
    private ArrayList<Equipo> equipos;

    public ListaEquipos() {
        this.equipos = new ArrayList<>();
        inicializarEquiposPredefinidos();
    }
    
    private void inicializarEquiposPredefinidos() {
        equipos.add(new Equipo(1, "Alfa Romeo",      "Italia"));        
        equipos.add(new Equipo(2, "Alpine",          "Francia"));
        equipos.add(new Equipo(3, "Aston Martin",    "Reino Unido"));
        equipos.add(new Equipo(4, "Ferrari",         "Italia"));
        equipos.add(new Equipo(5, "Haas",            "Estados Unidos"));
        equipos.add(new Equipo(6, "McLaren",         "Reino Unido")); 
        equipos.add(new Equipo(7, "Losco F1",        "Italia"));
        equipos.add(new Equipo(8, "Williams",        "Reino Unido"));
        equipos.add(new Equipo(9, "Red Bull Racing", "Austria"));
        equipos.add(new Equipo(10,"Magios Racists",  "Alemania")); 
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Equipo buscarEquipoPorId(int id) {
    for (int i = 0; i < equipos.size(); i++) {
        Equipo e = equipos.get(i);
        if (e.getId() == id) {
            return e;
        }
    }
    return null;
}

    
    public Equipo buscarEquipoPorNombre(String nombre) {
        System.out.println("buscando equipo: "+nombre);
        for(Equipo e : equipos){
            if(e == null) System.out.println("el equipo es null");
            else{
                System.out.println("equipo "+e.getNombreE());
                if(e.getNombreE().equalsIgnoreCase(nombre)){
                   return e;
                }
            }
            
        }
        System.out.println("no se encontro el equipo "+nombre);
        return null;
    }


    public void mostrarEquipos() {
        if(equipos.isEmpty()){
            System.out.println("No hay equipos cargados.");
            return;
        }
        for(int i = 0; i < equipos.size(); i++){
            Equipo e = equipos.get(i);
            e.mostrarDatos();
        }
    }
    
    //Cantidad de pilotos por equipo
    public int cantidadPilotosPorEquipo(String nombreEquipo){
        Equipo e = buscarEquipoPorNombre(nombreEquipo);
        if(e != null){
            return e.getCantidadPilotos();
        }
        return 0;
    }
    
   //arreglado
    public Equipo equipoConMasPuntos(){
        if(equipos.isEmpty()){
            return null;
        }
        Equipo equipoGanador = null;
        int maxPuntos = 0; //capaz haya que ponerlo en -1 no se
        
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipoActual = equipos.get(i);
            equipoActual.mostrarPilotos();
            int puntosDelEquipo = 0;
            Piloto[] listaPilotos = equipoActual.getPilotos(); 
            for (int j = 0; j < equipoActual.getCantidadPilotos(); j++) {
                Piloto pilotoActual = listaPilotos[j];
                if(pilotoActual == null) System.out.println("el piloto "+j+" del equipo "+equipoActual.getNombreE()+" es null");
                else puntosDelEquipo += pilotoActual.getPuntos();
            }
            if (puntosDelEquipo > maxPuntos) {
                maxPuntos = puntosDelEquipo;
                equipoGanador = equipoActual;
            }
            System.out.println("maximo de puntos: "+maxPuntos);
        }
        return equipoGanador;
    }   
    
    public Equipo equipoConMasPilotos(){
        if(equipos.isEmpty()){
            return null;
        }
        Equipo equipoGanador = null;
        int maxPilotos = 0; //capaz haya que ponerlo en -1 no se
        
        for (int i = 0; i < equipos.size(); i++) {
            Equipo equipoActual = equipos.get(i);
            
            if (equipoActual.getCantidadPilotos() > maxPilotos) {
                maxPilotos = equipoActual.getCantidadPilotos();
                equipoGanador = equipoActual;
            }
            System.out.println("maximo de pilotos: "+maxPilotos);
        }
        return equipoGanador;
    }   
    
}