/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_grupo1;

import javax.swing.JOptionPane;

/**
 *
 * @author Joseph
 */
public class Proyecto_Grupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String opcion = "";
        String opcionMenuQuickPass = "";
        do{
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Opcion A\n2) Opcion B\n3) Salir");
            
            switch (opcion) {
                case "1":
                    opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de Quick Pass***\n1) Crear\n2) Opcion B\n3) Salir");
                    do {
                        switch (opcionMenuQuickPass) {
                            case "1":
                                Quickpass q1 = new Quickpass();
                                
                                q1.setCodigo("1011234567");
                                System.out.println(q1);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo", "Error",JOptionPane.ERROR_MESSAGE);
                        }
                    } while (!opcionMenuQuickPass.equals("3"));
                    
                    break;
                    
                case "2":
                    JOptionPane.showMessageDialog(null, "Gestion de Accesos");
                    
                    break;
                    
                case "3":
                    JOptionPane.showMessageDialog(null, "Reportes");
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
        while(!opcion.equals("3"));

        
    }
    
}
