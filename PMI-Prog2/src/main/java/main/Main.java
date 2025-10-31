/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import modelo.*;
import controlador.Controlador;
import vista.InterfazGrafica;

/**
 *
 * @author arctan
 */
public class Main {
     public static void main(String args[]) {

        /* Create and display the form */
        Controlador.obtenerPilotosArchivo();
        Controlador.obtenerComisariosArchivo();
        java.awt.EventQueue.invokeLater(() -> new vista.InterfazGrafica().setVisible(true));
    }
}
