
/*Todo piloto pertenece a un equipo. De cada equipo se debe conocer:
 Nombre del equipo (Constructor)
o Condiciones:
 Los equipos ya están establecidos.
 Cantidad de equipos participantes: 10.
 Pilotos por equipo: al menos 2 titulares y como máximo 4 (para 
contemplar piloto(s) de reserva). */
//todo piloto pertenece a un equipo, piloto pertenece a equipos, con herencia?
public class Equipos {
    private int id; // Solo hay 10 equipos
    private String nombreE; 
    private String pais;
    

        public Equipos(int id, String nombreE, String pais){
            this.id = id;
            this.nombreE = nombreE;
            this.pais = pais;
        }

}
