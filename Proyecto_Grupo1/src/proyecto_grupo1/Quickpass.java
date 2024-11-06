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
    
    
    public Quickpass(String pCodigo){
        this.estado = Estado.Activo;
        int codigoValida = setCodigo(pCodigo);
        
        if ( codigoValida != -2 && codigoValida != -1) {
            this.codigo = codigoValida; 
        }
        else{
            JOptionPane.showMessageDialog(null, "El Código: "+ pCodigo +" es inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int setCodigo(String pCodigo) {
        
        if (pCodigo.length() == 10) {
            if (pCodigo.substring(0,3).equals("101")) {
                return Integer.parseInt(pCodigo);
            }
            else{
                return -2;
            }

        }
        else{
            return -1;
        }
           
    }
    
    
    
    @Override
    public String toString() {
        return "Quickpass [filial=" + filial + ", codigo=" + codigo + ", placa=" + placa + ", estado=" + estado + "]";
    }
}
