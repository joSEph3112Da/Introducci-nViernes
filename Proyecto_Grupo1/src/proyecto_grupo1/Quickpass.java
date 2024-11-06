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
public class Quickpass {//Atributos
    String filial;
    int codigo;
    int placa;
    Estado estado;
    
    
    public Quickpass(String pCodigo){ //Constructor
        this.estado = Estado.Activo;      
        int codigoValida = setCodigo(pCodigo); //Valida Codigo
        
        if ( codigoValida != -2 && codigoValida != -1) {
            this.codigo = codigoValida; 
        }
        else{
            JOptionPane.showMessageDialog(null, "El Código: "+ pCodigo +" es inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        System.out.println(this.toString());
    }

    public int setCodigo(String pCodigo) { //Setea el Codigo validado de 10 digitos y que comience con 101
        
        if (pCodigo.length() == 10) {
            if (pCodigo.substring(0,3).equals("101")) { //Valida
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
    public String toString() { //toString
        return "Quickpass [filial=" + filial + ", codigo=" + codigo + ", placa=" + placa + ", estado=" + estado + "]";
    }
}
