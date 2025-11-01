    package modelo;



public class ComisarioDeportivo extends Persona{
    private int SancionesAplicadas;
    private boolean Fia;
    
    public ComisarioDeportivo(){}
    
    public ComisarioDeportivo(int id, String Nombre,String Apellido,
                               Fecha FechaDeNacimiento,String Nacionalidad,
                               int SancionesAplicadas,boolean Fia){
        super(id,Nombre,Apellido,FechaDeNacimiento,Nacionalidad);
        this.SancionesAplicadas=SancionesAplicadas;
        this.Fia=Fia;
    }
    
    //Metodos

    //getters

    public int getSancionesAplicadas() {
        return SancionesAplicadas;
    }

    public boolean getFia() {
        return Fia;
    }


    //Setters

    public void setSancionesAplicadas(int SancionesAplicadas) {
        this.SancionesAplicadas = SancionesAplicadas;
    }

    public void setFia(boolean InternacionalFia) {
        this.Fia = InternacionalFia;
    }
    
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Sanciones aplicadas: "+this.getSancionesAplicadas());
        System.out.println("");
        System.out.println("Licencia FIA: "+ (this.getFia() ? "Si" : "No"));
    }
}