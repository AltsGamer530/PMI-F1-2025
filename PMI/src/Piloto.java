

public class Piloto {
    private String Nombre;
    private String Apellido;
    private Fecha FechaDeNacimiento;
    private String Nacionalidad;
    private int NumeroDeAuto;
    private String Equipo;
    private String Rol;
    private int Puntos;
    private String Podios;
    private String Poles;
    private String VueltasRapidas;
    private String Penalizaciones;
    private String Abandonos;
    private String Fia;
    
    public Piloto(String Nombre,String Apellido,Fecha FechaDeNacimiento,
            String Nacionalidad,int NumeroDeAuto,String Equipo,String Rol,
            int Puntos,String Podios,String Poles,String VueltasRapidas,
            String Penalizaciones,String Abandonos,String Fia){
    this.Nombre=Nombre;
    this.Apellido=Apellido;
    this.FechaDeNacimiento=FechaDeNacimiento;
    this.Nacionalidad=Nacionalidad;
    this.NumeroDeAuto=NumeroDeAuto;
    this.Equipo=Equipo;
    this.Rol=Rol;
    this.Puntos=Puntos;
    this.Podios=Podios;
    this.Poles=Poles;
    this.VueltasRapidas=VueltasRapidas;
    this.Penalizaciones=Penalizaciones;
    this.Abandonos=Abandonos;
    this.Fia=Fia;
    }

    public Piloto(){}

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

    public int getNumeroDeAuto() {
        return NumeroDeAuto;
    }

    public String getEquipo() {
        return Equipo;
    }

    public String getRol() {
        return Rol;
    }

    public int getPuntos() {
        return Puntos;
    }

    public String getPodios() {
        return Podios;
    }

    public String getPoles() {
        return Poles;
    }

    public String getVueltasRapidas() {
        return VueltasRapidas;
    }

    public String getPenalizaciones() {
        return Penalizaciones;
    }

    public String getAbandonos() {
        return Abandonos;
    }

    public String getFia() {
        return Fia;
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

    public void setNumeroDeAuto(int NumeroDeAuto) {
        this.NumeroDeAuto = NumeroDeAuto;
    }

    public void setEquipo(String Equipo) {
        this.Equipo = Equipo;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public void setPodios(String Podios) {
        this.Podios = Podios;
    }

    public void setPoles(String Poles) {
        this.Poles = Poles;
    }

    public void setVueltasRapidas(String VueltasRapidas) {
        this.VueltasRapidas = VueltasRapidas;
    }

    public void setPenalizaciones(String Penalizaciones) {
        this.Penalizaciones = Penalizaciones;
    }

    public void setAbandonos(String Abandonos) {
        this.Abandonos = Abandonos;
    }

    public void setFia(String Fia) {
        this.Fia = Fia;
    }
    
    
    
    
}
