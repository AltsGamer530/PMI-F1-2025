/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import modelo.*;
import controlador.Controlador;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vista.InterfazGrafica;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author arctan
 */
public class Main {
     public static void main(String args[]) {
         
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        e.printStackTrace();
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new vista.InterfazGrafica().setVisible(true));
    }
}
