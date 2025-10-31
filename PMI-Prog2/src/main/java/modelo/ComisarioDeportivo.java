package modelo;

public class ComisarioDeportivo extends Persona{
    
    private int sancionesAplicadas;
    private boolean internacionalFia;
    private int id;
    
    public ComisarioDeportivo(String nombre, String apellido,
                             Fecha fechaDeNacimiento, String nacionalidad,
                            int SancionesAplicadas,boolean InternacionalFia, int id){
        
        super(nombre, apellido, fechaDeNacimiento, nacionalidad);
        this.sancionesAplicadas=SancionesAplicadas;
        this.internacionalFia=InternacionalFia;
        this.id = id;
    }
    public ComisarioDeportivo() {
    }
    //Metodos

    public void mostrarDatosCo(){
        super.mostrarDatosBasicos(); // Llama al método de la clase padre
        System.out.println("ID: " + id);
        System.out.println("Sanciones: " + sancionesAplicadas);
        System.out.println("FIA Internacional: " + (internacionalFia ? "Si" : "No"));
        }
    //Getters

    
    public int getSancionesAplicadas() {
        return sancionesAplicadas;
    }

    public boolean getInternacionalFia() {
        return internacionalFia;
    }

    public int getId(){
        return id;
    }


    //Setters


    

    public void setSancionesAplicadas(int SancionesAplicadas) {
        this.sancionesAplicadas = SancionesAplicadas;
    }

    public void setInternacionalFia(boolean InternacionalFia) {
        this.internacionalFia = InternacionalFia;
    }

    public void setId(int id){
        this.id = id;
    }
}
