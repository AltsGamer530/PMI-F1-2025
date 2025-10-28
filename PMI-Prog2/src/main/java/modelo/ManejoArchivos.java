/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import controlador.Controlador;

/**
 *
 * @author Admin
 */
public class ManejoArchivos {
    public ManejoArchivos(){}
    
    public static boolean cargarPilotosDeArchivo(ListaPilotos lista){
        File f = new File("./data/Pilotos.txt");
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            while((line = reader.readLine()) != null){
                //leyendo el archivo
                Piloto aux = new Piloto();
                aux.setNombre(line);
                aux.setApellido(reader.readLine());
                String[] fecha = reader.readLine().split("/");
                aux.setFechaDeNacimiento(new Fecha(Integer.parseInt(fecha[0]),
                                                   Integer.parseInt(fecha[2]),
                                                   Integer.parseInt(fecha[2])));
                aux.setNacionalidad(reader.readLine());
                aux.setNumeroDeAuto(Integer.parseInt(reader.readLine()));
                aux.setEquipo(reader.readLine());
                aux.setRol(reader.readLine());
                aux.setPuntos(Integer.parseInt(reader.readLine()));
                aux.setPodios(Integer.parseInt(reader.readLine()));
                aux.setPoles(Integer.parseInt(reader.readLine()));
                aux.setVueltasRapidas(Integer.parseInt(reader.readLine()));
                aux.setPenalizaciones(Integer.parseInt(reader.readLine()));
                aux.setAbandonos(Integer.parseInt(reader.readLine()));
                aux.setFia(Boolean.parseBoolean(reader.readLine()));
                lista.addPiloto(aux);
                System.out.println("se cargo un piloto");
                
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
            return false;
        } 
        //ANDA
        System.out.println("pilotos guardados en lista");
        return true;
    }
    
    //llamar cuando: actualizar archivo (cargar piloto y cerrar aplicación)
    public static boolean guardarEnArchivo(ListaPilotos lista){
        File f = new File("./data/Pilotos.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(f, false))){
            for(Piloto p : lista.getLista()){
                //guardar pilotos
                 pw.println(p.getNombre());
                 pw.println(p.getApellido());
                 pw.println(p.getFechaDeNacimiento().toString());
                 pw.println(p.getNacionalidad());
                 pw.println(p.getNumeroDeAuto());
                 pw.println(p.getEquipo());
                 pw.println(p.getRol());
                 pw.println(p.getPuntos());
                 pw.println(p.getPodios());
                 pw.println(p.getPoles());
                 pw.println(p.getVueltasRapidas());
                 pw.println(p.getPenalizaciones());
                 pw.println(p.getAbandonos());
                 pw.println(p.getFia() ? "Si" : "No");
            }
            
        }catch(IOException e){
             System.err.println("Error al guardar los pilotos: " + e.getMessage());
             return false;
        }
        System.out.println("archivo actualizado");
        return true;
    }    
}