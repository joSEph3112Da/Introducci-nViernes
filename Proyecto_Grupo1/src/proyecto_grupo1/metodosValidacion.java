/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author Joseph Daniel Alvarado Gómez, Brayan Ruiz Valverde Jeancarlo Loria
 * Brenes, Marco Antonio Alvarez Mejia
 */
public class metodosValidacion {
    
    public int validaCodigo (){
        int valida = -1;
        String pCodigo;
        while (valida == -2 || valida == -1) {            
            pCodigo = JOptionPane.showInputDialog("Digite el codigo del Quickpass: ");
            
            if (pCodigo.length() == 10) {
                if (pCodigo.substring(0, 3).equals("101")) { //Valida
                    valida = Integer.parseInt(pCodigo);
                } else {
                    JOptionPane.showMessageDialog(null, "El Código: " + pCodigo + " debe de comenzar con 101", "Error", JOptionPane.ERROR_MESSAGE);
                    valida = -2;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El Código: " + pCodigo + " debe tener 10 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
                valida = -1;
            }
        }
        
        return valida;
    
    }
    
    
     public String valNoVacio (String parametro){
        String r;
        
        do {
            r = JOptionPane.showInputDialog("Ingrese la " + parametro + ":");
             if (r.equals("") || r == null) {
                JOptionPane.showMessageDialog(null, "La " + parametro + " es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } while (r.equals("") || r == null);
        
        return r;
    }
     
     public int valmayor0(String parametro){
        int r;
        do {
            r = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la " + parametro + ":"));
            if (r <= 0) {
                JOptionPane.showMessageDialog(null, "La " + parametro + " es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                
            }
            
        } while (r<=0);
        return r;
    }
    
}
