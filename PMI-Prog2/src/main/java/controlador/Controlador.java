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
    private static ListaComisarios listaComisarios = new ListaComisarios();
    
    public static boolean obtenerPilotosArchivo(){
        return ManejoArchivos.cargarPilotosDeArchivo(listaPilotos);
    }

    public static boolean obtenerComisariosArchivo(){
        return ManejoArchivos.cargarComisariosDeArchivo(listaComisarios);
    }

    public static boolean actualizarArchivo(){
        if(ManejoArchivos.guardarEnArchivo(listaPilotos, listaComisarios)){
            System.out.println("Archivo Actualizado");
            return true;
        }
        System.out.println("Error: no se pudo actualizar el archivo");
        return false;
    }
    
    public static ListaPilotos getListaPilotos(){
        return listaPilotos;
    }

    public static ListaComisarios getListaComisarios(){
        return listaComisarios;
    }
    
    public static boolean agregarPilotoInterfaz(Piloto p){
        return listaPilotos.addPiloto(p);
    }

    public static boolean agregarComisarioInterfaz(ComisarioDeportivo c){
        return listaComisarios.addComisario(c);
    }
    
    //solo se llama cuando se realizo la confirmacion
    public static boolean eliminarPilotoInterfaz(int nroAuto){
        return listaPilotos.eliminarPiloto(nroAuto);
    }

    //lo mismo que arriba
    public static boolean eliminarComisarioInterfaz(int id){
        return listaComisarios.eliminarComisario(id);
    }
    
    public static boolean modificarPilotoInterfaz(int nroAuto, Piloto pModificado){
        Piloto pOriginal = listaPilotos.buscarPilotoPorNumero(nroAuto);
        boolean modificado = false;
        if(pOriginal.getNumeroDeAuto() != pModificado.getNumeroDeAuto()){
            pOriginal.setNumeroDeAuto(pModificado.getNumeroDeAuto());
            modificado = true;
        }
        if(!pOriginal.getRol().equals(pModificado.getRol())){
            pOriginal.setRol(pModificado.getRol());
            modificado = true;
        }
        if(pOriginal.getPuntos() != pModificado.getPuntos()){
            pOriginal.setPuntos(pModificado.getPuntos());
            modificado = true;
        }
        if(pOriginal.getPodios() != pModificado.getPodios()){
            pOriginal.setPodios(pModificado.getPodios());
            modificado = true;
        }
        if(pOriginal.getPoles() != pModificado.getPoles()){
            pOriginal.setPoles(pModificado.getPoles());
            modificado = true;
        }
        if(pOriginal.getVueltasRapidas() != pModificado.getVueltasRapidas()){
            pOriginal.setVueltasRapidas(pModificado.getVueltasRapidas());
            modificado = true;
        }
        if(pOriginal.getPenalizaciones() != pModificado.getPenalizaciones()){
            pOriginal.setPenalizaciones(pModificado.getPenalizaciones());
            modificado = true;
        }
        if(pOriginal.getAbandonos() != pModificado.getAbandonos()){
            pOriginal.setAbandonos(pModificado.getAbandonos());
            modificado = true;
        }
        
        return modificado;
    }

}
