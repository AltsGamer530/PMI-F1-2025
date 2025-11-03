package modelo;

/**
 *
 * @author Alts
 */

import java.util.ArrayList;

public class Consultas {
    private ArrayList<Piloto> lista;
    private ArrayList<Equipo> equipo;
    private Equipo[] equipos;
    private int cantidadEquipos;

    public ArrayList<Piloto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Piloto> lista) {
        this.lista = lista;
    }

    public ArrayList<Equipo> getEquipo() {
        return equipo;
    }

    public void setEquipo(ArrayList<Equipo> equipo) {
        this.equipo = equipo;
    }

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        this.equipos = equipos;
    }
    
    
        
    public Consultas(Equipo[] equipos, int cantidadEquipos) {
        this.equipos = equipos;
        this.cantidadEquipos = cantidadEquipos;
    }

    public void mostrarTop3PilotosPuntos() {
    Piloto[] top3 = new Piloto[3];
    for (int i = 0; i < cantidadEquipos; i++) {
        Equipo eq = equipos[i];
        Piloto[] pilotos = eq.getPilotos();
        for (int j = 0; j < eq.getCantidadPilotos(); j++) {
            Piloto actual = pilotos[j];
            for (int k = 0; k < 3; k++) {
                if (top3[k] == null || actual.getPuntos() > top3[k].getPuntos()) {
                    for (int m = 2; m > k; m--) top3[m] = top3[m - 1];
                    top3[k] = actual;
                }
            }
        }
    }
    System.out.println("Top 3 pilotos con más puntos:");
    for (int i = 0; i < 3; i++) {
        if (top3[i] != null)
            System.out.println((i + 1) + ". " + top3[i].getNombre() + " (" + top3[i].getPuntos() + " pets)");
        }
    }

    public void mostrarTop3PilotosPodios() {
        Piloto[] top3 = new Piloto[3];

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo eq = equipos[i];
            Piloto[] pilotos = eq.getPilotos();
            for (int j = 0; j < eq.getCantidadPilotos(); j++) {
                Piloto actual = pilotos[j];
                for (int k = 0; k < 3; k++) {
                    if (top3[k] == null || actual.getPodios() > top3[k].getPodios()) {
                        for (int m = 2; m > k; m--) top3[m] = top3[m - 1];
                        top3[k] = actual;
                        break;
                    }
                }
            }
        }
        
        System.out.println("Top 3 pilotos con más podios:");
        for (int i = 0; i < 3; i++) {
            if (top3[i] != null)
                System.out.println((i + 1) + ". " + top3[i].getNombre() + " (" + top3[i].getPodios() + " ppdios)");
        }
    }   
    
    public void mostrarTop3VueltasRapidas() {
        Piloto[] top3 = new Piloto[3];

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo eq = equipos[i];
            Piloto[] pilotos = eq.getPilotos();

            for (int j = 0; j < eq.getCantidadPilotos(); j++) {
                Piloto actual = pilotos[j];

                for (int k = 0; k < 3; k++) {
                    if (top3[k] == null || actual.getVueltasRapidas() > top3[k].getVueltasRapidas()) {
                        for (int m = 2; m > k; m--) top3[m] = top3[m - 1];
                        top3[k] = actual;
                        break;
                    }
                }
            }
        }

        System.out.println("TOp 3 pilotos con más vueltas rápidas:");
        for (int i = 0; i < 3; i++) {
            if (top3[i] != null)
                System.out.println((i + 1) + ". " + top3[i].getNombre() + " - " + top3[i].getVueltasRapidas() + " vueltas rápidas");
        }
    }

    public void mostrarEquipoConMasPuntos() {
        Equipo mejorEquipo = null;
        int maxPuntos = 0;

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo eq = equipos[i];
            int total = 0;
            Piloto[] pilotos = eq.getPilotos();

            for (int j = 0; j < eq.getCantidadPilotos(); j++) {
                total += pilotos[j].getPuntos();
            }

            if (total > maxPuntos) {
                maxPuntos = total;
                mejorEquipo = eq;
            }
        }

        if (mejorEquipo != null)
            System.out.println("El mejor equipo es " + mejorEquipo.getNombreE() + " con " + maxPuntos + " puntos.");
        else
            System.out.println("No hay equipos cargados"); //No se si esto es rebundante pero meti varios controles por si acaso qsy

    }


    //La saque de lista pilotos a estas
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
            lista.get(i).mostrarDatos();
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


    //A estos los saque de ListaEquipos, creo que estan bien

    public Equipo buscarEquipoPorId(int id) {
    for (int i = 0; i < equipo.size(); i++) {
        Equipo e = equipo.get(i);
        if (e.getId() == id) {
            return e;
        }
    }
    return null;
}
    
    public Equipo buscarEquipoPorNombre(String nombre) {
    for (int i = 0; i < equipo.size(); i++) {
        Equipo e = equipo.get(i);
        if (e.getNombreE().equalsIgnoreCase(nombre)) {
            return e;
        }
    }
    return null;
}


    public void mostrarEquipos() {
        if(equipo.isEmpty()){
            System.out.println("No hay equipos cargados.");
            return;
        }
        for(int i = 0; i < equipo.size(); i++){
            Equipo e = equipo.get(i);
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
    

    public void mostrarEquipoConMasPodios() {
        Equipo mejor = null;
        int maxPodios = 0;

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo eq = equipos[i];
            int totalPodios = 0;

            Piloto[] pilotos = eq.getPilotos();
            for (int j = 0; j < eq.getCantidadPilotos(); j++) {
                totalPodios += pilotos[j].getPodios();
            }

            if (totalPodios > maxPodios) {
                maxPodios = totalPodios;
                mejor = eq;
            }
        }

        if (mejor != null)
            System.out.println("Equipo con más podios combinados: " + mejor.getNombreE() + " (" + maxPodios + " podios)");
        else
            System.out.println("No hay equipos cargados.");
    }

    public void mostrarPilotosPorRol(String rol) {
        System.out.println("Pilotos con rol: " + rol);

        boolean encontrado = false;
        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo eq = equipos[i];
            Piloto[] pilotos = eq.getPilotos();

            for (int j = 0; j < eq.getCantidadPilotos(); j++) {
                Piloto p = pilotos[j];
                if (p.getRol().equalsIgnoreCase(rol)) {
                    System.out.println("- " + p.getNombre() + " (" + eq.getNombreE() + ")");
                    encontrado = true;
                }
            }
        }

        if (!encontrado)
            System.out.println("No se encontraron pilotos con el rol '" + rol + "'.");
    }

    public void mostrarCantidadTotalPilotos() {
        int total = 0;
        for (int i = 0; i < cantidadEquipos; i++) {
            total += equipos[i].getCantidadPilotos();
        }
        System.out.println("👥 Cantidad total de pilotos en el campeonato: " + total);
    }

    //import java.util.chatgpt
    //import java.util.geminisIA

    public void mostrarRankingGeneral() {
    // Un poco de espacio extra, por si acaso... ¡nunca se sabe cuántos pilotos habrá!
    Piloto[] todosLosPilotosDelMundo = new Piloto[2000]; // 1000 era poco, ¡vamos a lo grande!
    int indiceActual = 0; // Para saber dónde vamos metiendo a los pilotos

    // Recorremos los equipos uno por uno, como en la vida real
    for (int i = 0; i < cantidadEquipos; i++) {
        Equipo equipoActual = equipos[i]; // Cogemos el equipo de esta vuelta
        Piloto[] losPilotosDeEsteEquipo = equipoActual.getPilotos(); // Sacamos a todos sus pilotos

        // Ahora, metemos cada piloto en nuestra lista gigante
        for (int j = 0; j < equipoActual.getCantidadPilotos(); j++) {
            todosLosPilotosDelMundo[indiceActual] = losPilotosDeEsteEquipo[j];
            indiceActual++; // ¡Siguiente hueco!
        }
    }

    // Bueno, ahora toca ordenar esto. Con un burbuja se ve más "hecho a mano"
    // (aunque sé que hay cosas más rápidas, ¡pero esto funciona!)
    for (int i = 0; i < indiceActual - 1; i++) {
        for (int j = 0; j < indiceActual - i - 1; j++) {
            // ¡Ojo! Ordenamos de mayor a menor, para que los mejores salgan primeros
            if (todosLosPilotosDelMundo[j].getPuntos() < todosLosPilotosDelMundo[j + 1].getPuntos()) {
                // Hacemos el "swap", ¡a intercambiar posiciones!
                Piloto pilotoTemporalParaIntercambio = todosLosPilotosDelMundo[j];
                todosLosPilotosDelMundo[j] = todosLosPilotosDelMundo[j + 1];
                todosLosPilotosDelMundo[j + 1] = pilotoTemporalParaIntercambio;
            }
        }
    }

    // ¡Listo! Ahora a imprimir el ranking bien bonito
    System.out.println("----------------------------------------");
    System.out.println("🏁🏁🏁 Ranking General de Pilotos 🏁🏁🏁");
    System.out.println("----------------------------------------");

    for (int i = 0; i < indiceActual; i++) {
        // Formateamos un poco para que quede claro
        System.out.println((i + 1) + ". " + todosLosPilotosDelMundo[i].getNombre() + " ===> " + todosLosPilotosDelMundo[i].getPuntos() + " puntos");
    }
    System.out.println("----------------------------------------");
    
}



}