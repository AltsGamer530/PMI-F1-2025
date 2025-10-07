

public class ComisariosDeportivos {

    private String Nombre;
    private String Apellido;
    private Fecha FechaDeNacimiento;
    private String Nacionalidad;
    private int SancionesAplicadas;
    private String InternacionalFia;
    
    public ComisariosDeportivos(String Nombre,String Apellido,
    Fecha FechaDeNacimiento,String Nacionalidad,
    int SancionesAplicadas,String InternacionalFia){
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.FechaDeNacimiento=FechaDeNacimiento;
        this.Nacionalidad=Nacionalidad;
        this.SancionesAplicadas=SancionesAplicadas;
        this.InternacionalFia=InternacionalFia;
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

    public String getInternacionalFia() {
        return InternacionalFia;
    }

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

    public void setInternacionalFia(String InternacionalFia) {
        this.InternacionalFia = InternacionalFia;
    }
}
