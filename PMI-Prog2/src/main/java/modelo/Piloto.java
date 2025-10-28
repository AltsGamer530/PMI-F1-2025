package modelo;

public class Piloto {
    private int ID;
    private String Nombre;
    private String Apellido;
    private Fecha FechaDeNacimiento;
    private String Nacionalidad;
    private int NumeroDeAuto;
    private String Equipo;
    private String Rol;
    private int Puntos;
    private int Podios;
    private int Poles;
    private int VueltasRapidas;
    private int Penalizaciones;
    private int Abandonos;
    private boolean Fia;
    
    public int getID(){
        return ID;
    }
    
    public void setID(int id){
        this.ID = id;
    }
    
    public Piloto(int id, String Nombre,String Apellido,Fecha FechaDeNacimiento,
            String Nacionalidad,int NumeroDeAuto,String Equipo,String Rol,
            int Puntos,int Podios,int Poles,int VueltasRapidas,
            int Penalizaciones,int Abandonos,boolean Fia){
    this.ID = id;
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

    public int getPodios() {
        return Podios;
    }

    public int getPoles() {
        return Poles;
    }

    public int getVueltasRapidas() {
        return VueltasRapidas;
    }

    public int getPenalizaciones() {
        return Penalizaciones;
    }

    public int getAbandonos() {
        return Abandonos;
    }

    public boolean getFia() {
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

    public void setPodios(int Podios) {
        this.Podios = Podios;
    }

    public void setPoles(int Poles) {
        this.Poles = Poles;
    }

    public void setVueltasRapidas(int VueltasRapidas) {
        this.VueltasRapidas = VueltasRapidas;
    }

    public void setPenalizaciones(int Penalizaciones) {
        this.Penalizaciones = Penalizaciones;
    }

    public void setAbandonos(int Abandonos) {
        this.Abandonos = Abandonos;
    }

    public void setFia(boolean Fia) {
        this.Fia = Fia;
    }
    
    public void mostrarDatosPi(){
        System.out.println("ID: "+this.getID());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Apellido: "+this.getApellido());
        System.out.println("Fecha de nacimiento: "+this.getFechaDeNacimiento().toString());
        System.out.println("Nacionalidad: "+this.getNacionalidad());
        System.out.println("Numero de Auto: "+this.getNumeroDeAuto());
        System.out.println("Equipo: "+this.getEquipo());
        System.out.println("Rol en el equipo: "+this.getRol());
        System.out.println("Puntos: "+this.getPuntos());
        System.out.println("Podios: "+this.getPodios());
        System.out.println("Poles: "+this.getPoles());
        System.out.println("Vueltas Rapidas: "+this.getVueltasRapidas());
        System.out.println("Penalizaciones: "+this.getPenalizaciones());
        System.out.println("Abandonos: "+this.getAbandonos());
        System.out.println("Licencia FIA: "+ (this.getFia() ? "Si" : "No"));
    }
    
}
