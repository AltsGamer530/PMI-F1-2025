/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author arctan
 */
public class ManejoArchivos {
    public ManejoArchivos(){}
    
    public static void cargarPilotosDeArchivo(ListaPilotos lista){
        File f = new File("/home/arctan/Desktop/Program/PMI-F1-2025/PMI-Prog2/src/main/java/controlador/Pilotos.txt");
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            while((line = reader.readLine()) != null){
                //leyendo el archivo nashe
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
                
                lista.getListaPilotos().add(aux);
                
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        } 
        //NASHEE ANDA
    }
}
