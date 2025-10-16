package modelo;



public class ComisarioDeportivo{

    private String Nombre;
    private String Apellido;
    private Fecha FechaDeNacimiento;
    private String Nacionalidad;
    private int SancionesAplicadas;
    private boolean InternacionalFia;
    private int id;
    
    public ComisarioDeportivo(String Nombre,String Apellido,
    Fecha FechaDeNacimiento,String Nacionalidad,
    int SancionesAplicadas,boolean InternacionalFia, int id){
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.FechaDeNacimiento=FechaDeNacimiento;
        this.Nacionalidad=Nacionalidad;
        this.SancionesAplicadas=SancionesAplicadas;
        this.InternacionalFia=InternacionalFia;
        this.id = id;
    }

    //Metodos

    public void mostrarDatosCo(){
        System.out.println("ID:" + id + "-" + Nombre + " " + Apellido + "- Sanciones: " + SancionesAplicadas + "- FIA Internacional: " + InternacionalFia );
    }

    //getters

    public int getId(){
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public Fecha getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public int getSancionesAplicadas() {
        return SancionesAplicadas;
    }

    public boolean getInternacionalFia() {
        return InternacionalFia;
    }


    //Setters


    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setFechaDeNacimiento(Fecha FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }

    public void setSancionesAplicadas(int SancionesAplicadas) {
        this.SancionesAplicadas = SancionesAplicadas;
    }

    public void setInternacionalFia(boolean InternacionalFia) {
        this.InternacionalFia = InternacionalFia;
    }

    public void setId(int id){
        this.id = id;
    }
}
