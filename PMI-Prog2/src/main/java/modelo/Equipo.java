package modelo;
import java.util.Scanner;

/*Todo piloto pertenece a un equipo. De cada equipo se debe conocer:
 Nombre del equipo (Constructor)
o Condiciones:
 Los equipos ya están establecidos.
 Cantidad de equipos participantes: 10.
 Pilotos por equipo: al menos 2 titulares y como máximo 4 (para 
contemplar piloto(s) de reserva). */
//todo piloto pertenece a un equipo, piloto pertenece a equipos, con herencia?
//los equipos tienen pilotos, pero son clases separadas

public class Equipo {
    private int id; // Solo hay 10 equipos
    private String nombreE; 
    private String pais;
    private Piloto pilotos[] = new Piloto[4];
    private final int MAX_COMISARIOS = 4;
    private int cantidadPilotos; //maximo 4 pilotos y 2 comisarios
    private int puntosTotales;

        public Equipo(){
            cantidadPilotos = 0;
        }

        public Equipo(int id, String nombreE, String pais){
            this.id = id;
            this.nombreE = nombreE;
            this.pais = pais;
            this.cantidadPilotos = 0;
            this.puntosTotales = 0;
        }

        //metodos

        public int getPuntosTotales(){
            int sum = 0;
            for(int i=0; i<cantidadPilotos; i++){
                sum += pilotos[i].getPuntos();
            }
            return sum;
        }
        
        public void mostrarDatos(){
        System.out.println(id + "-" + nombreE + "(" + pais + ")" + " Pilotos: "+ cantidadPilotos + " Puntos totales: "+ puntosTotales);
        } //Mostrar datos
        
        public int getCantidadPilotos(){
            return this.cantidadPilotos;
        }
        
        public int localizarPiloto(int numeroDeAuto){
            if(this.cantidadPilotos == 0) return -1; //no hay pilotos
            for(int i=0; i<this.cantidadPilotos; i++){
                if(this.pilotos[i].getNumeroDeAuto() == numeroDeAuto) return i; //encontrado
            }
            return -2; // no esta
        }
        
        public boolean agregarPiloto(Piloto p) {
            int pos;
            if(this.cantidadPilotos == 4){
                System.out.println("Tontito no se puede mas de 4 (Te pusieron)"); //"No se puede agregar más pilotos al equipo " + nombre
                return false;
            }
            pos = this.localizarPiloto(p.getNumeroDeAuto());
            if(pos < 0){
                this.pilotos[cantidadPilotos] = p;
                this.puntosTotales += p.getPuntos();
                this.cantidadPilotos++;
                return true;
            }
            System.out.println("No se pudo agregar el piloto");
            return false;
        }       //Para agregar pilotos


        public void mostrarPilotos(){
            System.out.println("Pitos del equipo" + nombreE + ":");
            for (int i = 0; i < cantidadPilotos; i++){
                pilotos[i].mostrarDatos();
            }
        }

        public boolean elimarPiloto(int id) { //Siento que me voy a olvidar de algo de aca que es importante
            int pos = this.localizarPiloto(id);
            int puntos = pilotos[pos].getPuntos();
            if(pos >= 0){
                for(int i = pos; i < cantidadPilotos - 1; i++){
                   pilotos[i] = pilotos[i + 1];
                    cantidadPilotos--;
                    puntosTotales -= puntos;
                    System.out.println("Piloto eliminado excitantemente");
                    return true;
                }
            }
               
            System.out.println("No se encontro el piloto...");
            return false; 
        }


        public boolean modificarPiloto(int numeroAuto){
            Scanner sc = new Scanner(System.in);
            int i = this.localizarPiloto(numeroAuto);
            if(i >= 0){
                System.out.println("Piloto enocontrado: ");
                pilotos[i].mostrarDatos();

                System.out.println("Que desea modificar?: ");
                System.out.println("1.Numero de Auto");
                System.out.println("2.Rol");
                System.out.println("3.Puntos");
                System.out.println("4.Podios");
                System.out.println("5.Poles");
                System.out.println("6.Vueltas Rapidas");
                System.out.println("7.Penalizaciones");
                System.out.println("8.Abandonos(DNF)");
                    
                int opcion = sc.nextInt();
                    
                switch (opcion) {
                    case 1:
                        System.out.println("Nuevo numero de auto: ");
                        pilotos[i].setNumeroDeAuto(sc.nextInt());
                        break;
                    case 2:
                        System.out.println("Nuevo Rol: ");
                        pilotos[i].setRol(sc.nextLine());
                        break;
                        case 3:
                            System.out.println("Nuevos puntos: ");
                            pilotos[i].setPuntos(sc.nextInt());
                            break;
                        case 4:
                            System.out.println("Nuevo podio: ");
                            pilotos[i].setPodios(sc.nextInt());
                            break;
                        case 5:
                            System.out.println("Nuevo Pole: ");
                            pilotos[i].setPoles(sc.nextInt());
                            break;
                        case 6:
                            System.out.println("Vueltas Rapidas Actuales: ");
                            pilotos[i].setVueltasRapidas(sc.nextInt());
                            break;
                        case 7:
                            System.out.println("Nuevas Penalizaciones: ");
                            pilotos[i].setPenalizaciones(sc.nextInt());
                            break;
                        case 8:
                            System.out.println("Nuevos Abandonos");
                            pilotos[i].setAbandonos(sc.nextInt());
                            break;
                        default:
                            System.out.println("Opción inválida");
                            return false;
                }
            }
            System.out.println("No se encontró el piloto con ese número de auto");
            sc.close();
            return false;
        }

        public boolean modificarComisario(ComisarioDeportivo[] comisarios, int cantidad){
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el ID del comisario a modificar: ");
            int idBuscado = sc.nextInt();

            for(int i = 0; i < cantidad; i++){
                if (comisarios[i].getID() == idBuscado) {
                    System.out.println("Comisario encontrado: ");
                    comisarios[i].mostrarDatos();

                    System.out.println("Que desea modificar?");
                    System.out.println("1. Sanciones aplicadas: ");
                    System.out.println("2. Fia Internacional(True/False): ");

                    int opcion = sc.nextInt();
                    sc.nextLine();

                    switch (opcion) {
                        case 1:
                            System.out.print("Nuevo valor de sanciones: ");
                        int nuevasSanciones = sc.nextInt();
                        comisarios[i].setSancionesAplicadas(nuevasSanciones);
                            break;
                        case 2:
                            System.out.print("¿Es internacional FIA? (true/false): ");
                        boolean nuevoValor = sc.nextBoolean();
                        comisarios[i].setFia(nuevoValor);
                            break;
                        default:
                            System.out.println("Opcion invalida (La opcion es down)");
                            return false;
                    }
                    System.out.println("Comisario modificado con sexito");
                    return true;
                }
            }

            System.out.println("No se encontro el comisario boludo de mierda...");
            return false;
        }

        public int buscarComisarioPorId(ComisarioDeportivo[] comisarios, int cantidad, int idBuscado){
            for (int i = 0; i < cantidad; i++){
                if(comisarios[i].getID() == idBuscado) return i;
            }
            return -1;
        }


        public int agregarComisario(ComisarioDeportivo[] comisarios, int cantidad, ComisarioDeportivo nuevo) {
            if(cantidad == MAX_COMISARIOS){
                System.out.println("No hay mas espacio para comisarios");
                return cantidad;
            }

            if (buscarComisarioPorId(comisarios, cantidad, nuevo.getID()) != -1){
                System.out.println("Ya existe un comisario con el ID " + nuevo.getID());
                return cantidad;
            }

            comisarios[cantidad-1] = nuevo;
            System.out.println("Comisario agregado (ID " + nuevo.getID() + ").");
            return cantidad + 1;
        //Tengo que hacer un verificador para que no se repita el id pero alta paja ya estoy cansado
        //Que se encargue el boludo del Alts del futuro
        //eso se soluciona con una clase lista y un metodo para buscar
        //HECHO
        }
        // lpm tengo que hacer para eliminar y mostrar los comisarios, acordate
        public int eliminarComisario(ComisarioDeportivo[] comisarios, int cantidad, int idBuscado) {
        int idx = buscarComisarioPorId(comisarios, cantidad, idBuscado);
        if (idx == -1) {
            System.out.println("No se encontró comisario con ID " + idBuscado + ".");
            return cantidad;
        }
        // compactar: correr a la izquierda
        for (int i = idx; i < cantidad - 1; i++) {
            comisarios[i] = comisarios[i + 1];
        }
        
        System.out.println("Comisario con ID " + idBuscado + " eliminado.");
        return cantidad - 1;
    }

    public void mostrarComisarios(ComisarioDeportivo[] comisarios, int cantidad) {
        if (cantidad == 0) {
            System.out.println("No hay comisarios cargados.");
            return;
        }
        for (int i = 0; i < cantidad; i++) {
            comisarios[i].mostrarDatos();
        }
    }
        //getters
        public int getId(){
            return id;
        }

        
        public String getNombreE(){
            return nombreE;
        }

        
        public String getPais(){
            return pais;
        }   
        //setters
        public void setId(int id){
            this.id = id;
        }
        
        public void setNombreE(String nombreE){
            this.nombreE = nombreE;
        }
        
        public void setPais(String pais){
            this.pais = pais;
        }
        
        public Piloto[] getPilotos(){
            return this.pilotos;
        }
    

}
