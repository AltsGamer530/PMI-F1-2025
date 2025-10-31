/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author arctan
 */
public class Persona {
    private int ID;
    private String Nombre;
    private String Apellido;
    private Fecha FechaDeNacimiento;
    private String Nacionalidad;

    public Persona() {}

    public Persona(int ID, String Nombre, String Apellido, Fecha FechaDeNacimiento, String Nacionalidad) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.FechaDeNacimiento = FechaDeNacimiento;
        this.Nacionalidad = Nacionalidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public Fecha getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Fecha FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public String getNacionalidad() {
        return Nacionalidad;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.Nacionalidad = Nacionalidad;
    }
    
    public void mostrarDatos(){
        System.out.println("ID: "+this.getID());
        System.out.println("Nombre: "+this.getNombre());
        System.out.println("Apellido: "+this.getApellido());
        System.out.println("Fecha de nacimiento: "+this.getFechaDeNacimiento().toString());
        System.out.println("Nacionalidad: "+this.getNacionalidad());
    }
    
    
}
