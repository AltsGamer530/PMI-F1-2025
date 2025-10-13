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
import modelo.Piloto;
import modelo.ComisarioDeportivo;
import modelo.Equipo:
import modelo.Fecha;

/**
 *
 * @author Admin
 */
public class Controlador {
    public static ArrayList<Piloto> cargarPilotos(){
        ArrayList<Piloto> pilotos = new ArrayList<>();
        File f = new File("C:\\Users\\Admin\\Documents\\GitHub\\PMI-F1-2025\\PMI\\src\\Pilotos.txt");
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
                pilotos.add(aux);
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        } 
        //NASHEE ANDA
        return pilotos;
    }
}
