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
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Gestion de QuickPass\n2) Opcion B\n3) Reporte\n4) Salir");
            switch (opcion) {
                case "1":
                    do {
                        opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de QuickPass***\n1) Crear\n2) Consulta\n3) Salir");
                        switch (opcionMenuQuickPass) {
                            case "1":
                                String codigo_Quick = JOptionPane.showInputDialog("Digite el código del Quickpass (101XXXXXXX): ");                             
                                Quickpass q1 = new Quickpass(codigo_Quick);
                                
                                if (q1.codigo != 0){
                                    JOptionPane.showMessageDialog(null, 
                                            "El código es: "+ q1.codigo +" es correcto", "Registro" , JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                                
                            case "2":
                                JOptionPane.showMessageDialog(null, "Consultas (En desarrollo)");
                                break;
                                
                            case "3":
                                JOptionPane.showMessageDialog(null, "Saliendo del Gestion de QuickPass");
                                break;
                                
                            case null: //Caso Cancel
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo", 
                                        "Error",JOptionPane.ERROR_MESSAGE);
                                opcionMenuQuickPass = "";
                                break;
                                
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo"
                                        , "Error",JOptionPane.ERROR_MESSAGE);                             
                        }//Switch Menu Gestion
                        
                    } while (!opcionMenuQuickPass.equals("3")); //Final Do While Gestion
                    break;
                    
                case "2":
                    JOptionPane.showMessageDialog(null, "Gestion de Accesos (En Desarrollo)");
                    break;
                    
                case "3":
                    JOptionPane.showMessageDialog(null, "Reportes (En Desarrollo)");
                    break;
                    
                case "4":
                    JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
                    break;
                    
                case null:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo"
                            , "Error",JOptionPane.ERROR_MESSAGE);
                    opcion = "";
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo"
                            , "Error",JOptionPane.ERROR_MESSAGE);
            }//Switch Menu Principal
        }
        while(!opcion.equals("4")); //Final Do While Menu Principal
    }  
}
