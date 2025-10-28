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
                //leyendo el archivo nashe
                Piloto aux = new Piloto();
                aux.setID(Integer.parseInt(line));
                aux.setNombre(reader.readLine());
                aux.setApellido(reader.readLine());
                String[] fecha = reader.readLine().split("/");
                aux.setFechaDeNacimiento(new Fecha(Integer.parseInt(fecha[0]),
                                                   Integer.parseInt(fecha[1]),
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
        } 
        //ANDA
        System.out.println("pilotos guardados en lista");
        return true;
    }

    public static boolean cargarComisariosDeArchivo(ListaComisarios lista){
        File f = new File("./data/ComisariosDeportivos.txt");
        String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(f))){
            while((line = reader.readLine()) != null){
                //leyendo el archivo
                ComisarioDeportivo aux = new ComisarioDeportivo();
                aux.setId(Integer.parseInt(reader.readLine()));
                aux.setNombre(line);
                aux.setApellido(reader.readLine());
                String[] fecha = reader.readLine().split("/");
                aux.setFechaDeNacimiento(new Fecha(Integer.parseInt(fecha[0]),
                                                   Integer.parseInt(fecha[2]),
                                                   Integer.parseInt(fecha[2])));
                aux.setNacionalidad(reader.readLine());
                aux.setSancionesAplicadas(Integer.parseInt(reader.readLine()));
                aux.setInternacionalFia(Boolean.parseBoolean(reader.readLine()));
                lista.addComisario(aux);
                System.out.println("se cargo un comisario");
                
            }
        }catch(IOException e){
            System.err.println("Error leyendo el archivo: " + e.getMessage());
        } 
        //ANDA
        System.out.println("comisarios guardados en lista");
        return true;
    }
    


    //llamar cuando: actualizar archivo (cargar piloto y cerrar aplicación)
    public static boolean guardarEnArchivo(ListaPilotos pilotos, ListaComisarios comisarios){
        int exito_pilotos = 0, exito_comisarios = 0;
        File f1 = new File("./data/Pilotos.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(f1, false))){
            for(Piloto p : pilotos.getLista()){
                //guardar pilotos
                 pw.println(p.getID());
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
                 exito_pilotos = 1;
                 System.out.println("archivo pilotos actualizado");
            }
        }catch(IOException e){
             System.err.println("Error al guardar los pilotos: " + e.getMessage());
        }
        
        File f2 = new File("./data/ComisariosDeportivos.txt");
        try(PrintWriter pw = new PrintWriter(new FileWriter(f2, false))){
            for(ComisarioDeportivo c : comisarios.getLista()){
                //guardar pilotos
                 pw.println(c.getId());
                 pw.println(c.getNombre());
                 pw.println(c.getApellido());
                 pw.println(c.getFechaDeNacimiento().toString());
                 pw.println(c.getNacionalidad());
                 pw.println(c.getSancionesAplicadas());
                 pw.println(c.getInternacionalFia() ? "Si" : "No");
            }
            exito_comisarios = 1;
            System.out.println("archivo comisarios actualizado");
        }catch(IOException e){
             System.err.println("Error al guardar los comisarios: " + e.getMessage());
        }
        
        if(exito_pilotos == 1 && exito_comisarios == 1) return true;
        return false;
    }    
}