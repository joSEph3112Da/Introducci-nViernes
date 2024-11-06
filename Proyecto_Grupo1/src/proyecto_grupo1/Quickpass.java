/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class Quickpass {
    String filial;
    int codigo;
    int placa;
    Estado estado;
    
    
    public Quickpass(){
        this.estado = Estado.Activo;
    }

    public int setCodigo(String pCodigo) {
        
        if (pCodigo.length() == 10) {
            if (pCodigo.substring(0,3).equals("101")) {
                return Integer.parseInt(pCodigo);
            }
            else{
                JOptionPane.showMessageDialog(null, "El código debe comenzar con 101","Error",JOptionPane.ERROR_MESSAGE);
                return -2;
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "El código debe tener 10 dígitos","Error",JOptionPane.ERROR_MESSAGE);
            return -1;
        }
           
    }
    
    
    
    @Override
    public String toString() {
        return "Quickpass [filial=" + filial + ", codigo=" + codigo + ", placa=" + placa + ", estado=" + estado + "]";
    }
}
