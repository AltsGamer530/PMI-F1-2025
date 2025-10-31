package modelo;

public abstract class Persona { 
    private String nombre;
    private String apellido;
    private Fecha fechaDeNacimiento;
    private String nacionalidad;



    public Persona(String nombre, String apellido, Fecha fechaDeNacimiento, String nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
    }

    
    public Persona() {
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Fecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaDeNacimiento(Fecha fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    
    public void mostrarDatosBasicos() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Fecha de Nacimiento: " + fechaDeNacimiento.toString());
        System.out.println("Nacionalidad: " + nacionalidad);
    }
 
}