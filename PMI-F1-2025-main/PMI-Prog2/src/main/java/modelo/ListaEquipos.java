package modelo;

import java.util.ArrayList;

//Cambie el nombre a ListaEquipos !!!!!!ANOTAR PARA QUE EL TANSI SEPA!!!!!!!!!!!!
public class ListaEquipos {
    private ArrayList<Equipo> equipos;

    public ListaEquipos() {
        this.equipos = new ArrayList<>();
        inicializarEquiposPredefinidos();
    }

    private void inicializarEquiposPredefinidos() {
        equipos.add(new Equipo(1, "Ferrar",          "Italia"));
        equipos.add(new Equipo(2, "Red Bull Racing", "Austria"));
        equipos.add(new Equipo(3, "McLaren",         "Reino Unido"));
        equipos.add(new Equipo(4, "Haas",            "Estados Unidos"));
        equipos.add(new Equipo(5, "Los Na",          "Peru")); 
        equipos.add(new Equipo(6, "Alpine",          "Francia"));
        equipos.add(new Equipo(7, "Racing Bulls",    "Italia"));
        equipos.add(new Equipo(8, "Willians",        "Reino Unido"));
        equipos.add(new Equipo(9, "Aston Martin",    "Reino Unido"));
        equipos.add(new Equipo(10,"Magios Racing",   "Alemania")); 
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
    for (int i = 0; i < equipos.size(); i++) {
        Equipo e = equipos.get(i);
        if (e.getNombreE().equalsIgnoreCase(nombre)) {
            return e;
        }
    }
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
    
   
    public Equipo equipoConMasPuntos(){
        if(equipos.isEmpty()){
            return null;
        }
        Equipo equipoGanador = null;
        int maxPuntos = 0; //capaz haya que ponerlo en -1 no se

        for (int i = 0; i < equipos.size(); i++) {
    Equipo equipoActual = equipos.get(i);
    int puntosDelEquipo = 0;

    Piloto[] listaPilotos = equipoActual.getPilotos(); 
        for (int j = 0; j < listaPilotos.length; j++) {
            Piloto pilotoActual = listaPilotos[j];
            puntosDelEquipo += pilotoActual.getPuntos();
        }
    if (puntosDelEquipo > maxPuntos) {
        maxPuntos = puntosDelEquipo;
        equipoGanador = equipoActual;
    }
}
        return equipoGanador;
    }
    
    
}