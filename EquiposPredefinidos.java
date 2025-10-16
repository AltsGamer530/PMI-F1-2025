package modelo;

public class EquiposPredefinidos{

    Equipo[] equipos = new Equipo[10];

    public EquiposPredefinidos() {
        equipos[0] = new Equipo(1, "Losco F1",        "Argentina");
        equipos[1] = new Equipo(2, "Glep Racing",     "Estados Unidos");
        equipos[2] = new Equipo(3, "McLaren",         "Italia");
        equipos[3] = new Equipo(4, "Miskatonic Race", "Alemania");
        equipos[4] = new Equipo(5, "Los Nazis",       "Peru");
        equipos[5] = new Equipo(6, "Fiumba",          "Ecuadown");
        equipos[6] = new Equipo(7, "Nashe",           "Bulgaria");
        equipos[7] = new Equipo(8, "Full Races",      "Polonia");
        equipos[8] = new Equipo(9, "Tito Calderon",   "Sicilia");
        equipos[9] = new Equipo(10,"Magios Racists",  "Bolivia");
    
    }

    public void mostrarEquipos() {
        for(int i=0; i < equipos.length; i++){
            equipos[i].mostrarDatos();
        }
    }
}