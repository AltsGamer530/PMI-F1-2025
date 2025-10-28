/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.*;
/**
 *
 * @author Admin
 */

public class Controlador {
    private static ListaPilotos listaPilotos = new ListaPilotos();
    
    public static boolean obtenerPilotosArchivo(){
        return ManejoArchivos.cargarPilotosDeArchivo(listaPilotos);
    }
    
    public static boolean actualizarArchivo(){
        if(ManejoArchivos.guardarEnArchivo(listaPilotos)){
            System.out.println("Archivo Actualizado");
            return true;
        }
        System.out.println("Error: no se pudo actualizar el archivo");
        return false;
    }
    
    public static ListaPilotos getListaPilotos(){
        return listaPilotos;
    }
    
    public static boolean agregarPilotoInterfaz(Piloto p){
        return listaPilotos.addPiloto(p);
    }
    
    //solo se llama cuando se realizo la confirmacion
    public static boolean eliminarPilotoInterfaz(int nroAuto){
        return listaPilotos.eliminarPiloto(nroAuto);
    }
    
}
