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
import java.util.Comparator;
import modelo.*;
import modelo.Consultas;
/**
 *
 * @author Admin
 */

public class Controlador {
    private static ListaPilotos listaPilotos = new ListaPilotos();
    private static ListaComisarios listaComisarios = new ListaComisarios();
    private static ListaEquipos listaEquipos = new ListaEquipos();
    
    public static boolean obtenerPilotosArchivo(){
        return ManejoArchivos.cargarPilotosDeArchivo(listaPilotos, listaEquipos);
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
    
    public static ListaPilotos getListaPilotosPuntaje(int puntos){
        ListaPilotos filtrados = new ListaPilotos();
        for(Piloto p : listaPilotos.getLista()){
            if(p.getPuntos() > puntos) filtrados.addPiloto(p);
        }
        return filtrados;
    }
    
    public static ListaComisarios getListaComisariosFIA(){
        ListaComisarios filtrados = new ListaComisarios();
        for(ComisarioDeportivo c : listaComisarios.getLista()){
            if(c.getFia()) filtrados.addComisario(c);
        }
        return filtrados;
    }
    
    public static ListaEquipos getListaEquipos(){
        listaEquipos.mostrarEquipos();
        return listaEquipos;
    }
    
    public static boolean agregarPilotoInterfaz(Piloto p){
        boolean exito = false;
        System.out.println("equipo del piloto: "+p.getEquipo());
        Equipo e = listaEquipos.buscarEquipoPorNombre(p.getEquipo());
        if(e == null) System.out.println("no se encontro el equipo (null)");
        else{
            System.out.println("se encontro el equipo "+e.getNombreE());
            if(e.agregarPiloto(p) && listaPilotos.addPiloto(p)){
            System.out.println("se agrego el piloto "+p.getNombre()+" "+p.getApellido());    
            exito = true;
            }
        }
        
        return exito;
    }

    public static boolean agregarComisarioInterfaz(ComisarioDeportivo c){
        return listaComisarios.addComisario(c);
    }
    
    //solo se llama cuando se realizo la confirmacion
    public static boolean eliminarPilotoInterfaz(int id){
        Piloto p = listaPilotos.buscarPilotoPorID(id);
        if(listaEquipos.buscarEquipoPorNombre(p.getEquipo()).eliminarPiloto(id) &&
           listaPilotos.eliminarPiloto(id)){
           return true;
        }
        return false;
    }

    //lo mismo que arriba
    public static boolean eliminarComisarioInterfaz(int id){
        return listaComisarios.eliminarComisario(id);
    }
    
    public static boolean modificarPilotoInterfaz(Piloto pModificado){
        int id = pModificado.getID();
        Piloto pOriginal = listaPilotos.buscarPilotoPorID(id);
        pOriginal.mostrarDatos();
        System.out.println("^ piloto encontrado por ID " + id);
        boolean modificado = false;
        if(pOriginal == null) return false;
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
        if(!pOriginal.getEquipo().equals(pModificado.getEquipo())){
            System.out.println("Cambio de equipo "+pOriginal.getEquipo()+" -> "+pModificado.getEquipo());
            listaEquipos.buscarEquipoPorNombre(pOriginal.getEquipo()).eliminarPiloto(pOriginal.getID());
            pOriginal.setEquipo(pModificado.getEquipo());
            if(listaEquipos.buscarEquipoPorNombre(pOriginal.getEquipo()).agregarPiloto(pOriginal)) modificado = true;
        }
        if(pOriginal.getFia() != pModificado.getFia()){
            System.out.println("cambio FIA "+(pOriginal.getFia() ? "Si" : "No")+" -> "+(pModificado.getFia() ? "Si" : "No"));
            pOriginal.setFia(pModificado.getFia());
            modificado = true;
        }
        System.out.println(modificado ? "modificado" : "no modificado");
        return modificado;
    }
    
    public static boolean modificarComisarioInterfaz(ComisarioDeportivo cModificado){
        int id = cModificado.getID();
        ComisarioDeportivo cOriginal = listaComisarios.buscarComisarioPorId(id);
        cOriginal.mostrarDatos();
        System.out.println("^ comisario encontrado por ID" + id);
        boolean modificado = false;
        if(cOriginal == null) return false;
        if(cOriginal.getSancionesAplicadas() != cModificado.getSancionesAplicadas() ||
           cOriginal.getFia() != cModificado.getFia()){
            cOriginal.setFia(cModificado.getFia());
            cOriginal.setSancionesAplicadas(cModificado.getSancionesAplicadas());
            System.out.println("se modificó el comisario");
            modificado = true;
        } else System.out.println("no se modificó el comisario");
        
        return modificado;
    }
    
    public static Piloto getPilotoConMasPenalizaciones(){
        return listaPilotos.pilotoConMasPenalizaciones();
    }
    
    public static int getCantidadPilotosRol(String rolBuscado){
        return listaPilotos.contarPilotosPorRol(rolBuscado);
    }
    
    public static Piloto[] getTop3Podios(){
        ListaPilotos lista = listaPilotos;
        //xd
        lista.getLista().sort(Comparator.comparingInt(Piloto::getPodios).reversed());
        Piloto[] top3 = new Piloto[3];
        top3[0] = lista.getLista().get(0);
        top3[1] = lista.getLista().get(1);
        top3[2] = lista.getLista().get(2);
        return top3;
    }
    
    public static Equipo getEquipoConMasPuntos(){
        return listaEquipos.equipoConMasPuntos();
    }
    
    public static Equipo getEquipoConMasPilotos(){
        return listaEquipos.equipoConMasPilotos();
    }
    
    public static ListaEquipos ordenarEquiposPorPuntaje(){
        ListaEquipos lista = listaEquipos;
        //xd
        lista.getEquipos().sort(Comparator.comparingInt(Equipo::getPuntosTotales).reversed());
        return lista;
    }
    
    public static ListaEquipos ordenarEquiposPorPilotos(){
        ListaEquipos lista = listaEquipos;
        lista.getEquipos().sort(Comparator.comparingInt(Equipo::getCantidadPilotos).reversed());
        return lista;
    }
    
}