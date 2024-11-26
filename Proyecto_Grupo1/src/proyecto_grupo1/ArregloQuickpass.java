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
public class ArregloQuickpass {
    private Quickpass listQuickpass[];
    private int cupo;

    public ArregloQuickpass(int tamanno) {
        listQuickpass = new Quickpass[tamanno];
        cupo = tamanno;
    }
    
    public void agregarQuickpass(Quickpass pQuickNew){
        if (cupo == 0) {
            JOptionPane.showMessageDialog(null, "No queda más espacio para quickpass", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            for (int i = 0; i < listQuickpass.length; i++) {
                if (listQuickpass[i] == null) {
                    listQuickpass[i]= pQuickNew;
                    cupo --;
                    JOptionPane.showMessageDialog(null, "El quickpass fue creado correctamente");
                    break;
                }

            }
        }

    }
   
    @Override
    public String toString() {
       String mensaje = "***Quickpass Creados***\n";
       for(int x=0;x<listQuickpass.length;x++){
           mensaje+=(x+1)+") "+listQuickpass[x]+"\n";
       }
       return  mensaje;
       
    }
    
    
}
