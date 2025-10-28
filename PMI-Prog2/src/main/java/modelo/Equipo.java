package modelo;
import java.util.Arrays;

//todo piloto pertenece a un equipo, piloto pertenece a equipos, con herencia?
//los equipos tienen pilotos, pero son clases separadas

public class Equipo {
    private int id; // Solo hay 10 equipos
    private String nombreE; 
    private String pais;
    private Piloto pilotos[];
    private final int MAX_PILOTOS = 4;
    private int cantidadPilotos; //maximo 4 piolotos y 2 comisarios

        public Equipo(){
            pilotos = new Piloto[MAX_PILOTOS];
            cantidadPilotos = 0;
        }

        public Equipo(int id, String nombreE, String pais){
            this.id = id;
            this.nombreE = nombreE;
            this.pais = pais;
            this.pilotos = new Piloto[MAX_PILOTOS];
            this.cantidadPilotos = 0;
        }

        //metodos

        
        
        public int localizarPiloto(int numeroDeAuto){
            if(this.cantidadPilotos == 0) return -1; //no hay pilotos
            for(int i=0; i<this.cantidadPilotos; i++){
                if(this.pilotos[i].getNumeroDeAuto() == numeroDeAuto) return i; //encontrado
            }
            return -1; // no esta
        }
        
        public boolean agregarPiloto(Piloto p) {
           
            if(cantidadPilotos == MAX_PILOTOS){ 
                return false; //Esta en el maximoo
            }

            //Por si hay duplicados, tira false(Evita duplicados basicamente)
            if (localizarPiloto(p.getNumeroDeAuto()) != -1)
            return false;
            
            pilotos[cantidadPilotos] = p;
            cantidadPilotos++;
            return true;
        }


        

        public boolean eliminarPiloto(int numeroAuto){
            int pos = localizarPiloto(numeroAuto);
            if (pos == -1) return false;

            for(int i = pos; i < cantidadPilotos - 1; i++){
                pilotos[i] = pilotos[i +1];
            }

            pilotos[cantidadPilotos - 1] = null;
            cantidadPilotos--;
            return true;
        }

       
        //Tengo que hacer un verificador para que no se repita el id pero alta paja ya estoy cansado
        //Que se encargue el boludo del Alts del futuro
        //eso se soluciona con una clase lista y un metodo para buscar
        //HECHO
        
        // lpm tengo que hacer para eliminar y mostrar los comisarios, acordate
        
        //getters

        public Piloto[] getPilotos() {
        return Arrays.copyOf(pilotos, cantidadPilotos);
    }

        public int getCantidadPilotos() {
        return cantidadPilotos;
    }

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
        public void mostrarDatos(){
            System.out.println(id + "-" + nombreE + "(" + pais + ")");
        }
        
    }
