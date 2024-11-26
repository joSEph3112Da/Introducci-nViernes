/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_grupo1;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
/**
 *
 * @author Joseph Daniel Alvarado Gómez, Brayan Ruiz Valverde Jeancarlo Loria
 * Brenes, Marco Antonio Alvarez Mejia
 */
public class Proyecto_Grupo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        metodosValidacion valida = new metodosValidacion(); //Metodos para validaciones
        ArchivosTxt arc = new ArchivosTxt(); // Metodos de TXT
        String opcion = ""; //Variable de Menu Inicial
        String opcionMenuQuickPass = ""; //Variable menu Quickpass
       
        ArregloQuickpass qPass = new ArregloQuickpass(5); //Arreglo de Quickpass
        
        do {
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Gestion de QuickPass\n2) Gestion de Accesos\n3) Reporte\n4) Salir");
            switch (opcion) {
                case "1":
                    do {
                        opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de QuickPass***\n1) Crear Quickpass\n2) Consultar por código\n3) Bloquear Quickpass\n4) Eliminar Quickpass\n5) Salir");
                        
                        switch (opcionMenuQuickPass) {
                            case "1":
                                
                                String filial_nuevo = valida.valNoVacio("filial");
                                int codigo_Nuevo =  valida.validaCodigo();
                                int placa_nuevo = valida.valmayor0("placa");
                                
                                Quickpass quickpass_Nuevo = new Quickpass(filial_nuevo, codigo_Nuevo, placa_nuevo);
                                qPass.agregarQuickpass(quickpass_Nuevo);
                                
                                break;

                            case "2":
                                JOptionPane.showMessageDialog(null, qPass);
                                //JOptionPane.showMessageDialog(null, "***Consulta por Código***");
                                LocalDateTime tiempo = LocalDateTime.now();
                                
                                break;
                                
                            case "3":
                                JOptionPane.showMessageDialog(null, "***Bloquar Código***");
                                break;
                                
                            case "4":
                                JOptionPane.showMessageDialog(null, "***Eliminar Quickpass***");
                                break;

                            case "5":
                                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Quickpass!");
                                break;

                            case null: //Caso Cancel
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                                opcionMenuQuickPass = "";
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                        }//Switch Menu Gestion

                    } while (!opcionMenuQuickPass.equals("5")); //Final Do While Gestion
                    break;

                case "2":
//                    String lectura = arc.leer_TXT(); **Prueba**
//                    JOptionPane.showMessageDialog(null, "En el txt se encuentra: " + lectura); **Prueba**
                    JOptionPane.showMessageDialog(null, "Gestion de Accesos (En Desarrollo)");
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Reportes (En Desarrollo)");
                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
                    break;

                case null:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    opcion = "";
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }//Switch Menu Principal
        } while (!opcion.equals("4")); //Final Do While Menu Principal
    }
}
