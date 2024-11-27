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
        String opcionEliminar = ""; //Variable menu de eliminar Quickpass
        ArregloQuickpass qPass = new ArregloQuickpass(5); //Arreglo de Quickpass
        ArregloQuickpass quickpassEliminados = new ArregloQuickpass(15);

        do {
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Gestion de QuickPass\n2) Gestion de Accesos\n3) Reporte\n4) Salir");
            switch (opcion) {
                case "1":
                    do {
                        opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de QuickPass***\n1) Crear Quickpass\n2) Consultar por código\n3) Bloquear Quickpass\n4) Eliminar Quickpass\n5) Salir");

                        switch (opcionMenuQuickPass) {
                            case "1":
                                if (qPass.getCupo() > 0) {
                                    String filial_nuevo = valida.valNoVacio("filial");
                                    int codigo_Nuevo = valida.validaCodigo();
                                    int placa_nuevo = valida.valmayor0("placa");
                                    Quickpass quickpass_Nuevo = new Quickpass(filial_nuevo, codigo_Nuevo, placa_nuevo);
                                    qPass.agregarQuickpass(quickpass_Nuevo);
                                    JOptionPane.showMessageDialog(null, "El quickpass fue creado correctamente");
                                } else {
                                    JOptionPane.showMessageDialog(null, "No queda más espacio para quickpass", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                                break;

                            case "2": //Brayan acá hay que agregar un submenú como en la opcion 4 de eliminar para las distintas visualizaciones recuerde inicializarla al puro inicio y comente la cosa
                                JOptionPane.showMessageDialog(null, "***Quickpass Creados***" + qPass);
                                JOptionPane.showMessageDialog(null, "***Quickpass Eliminados***" + quickpassEliminados);
                                //JOptionPane.showMessageDialog(null, "***Consulta por Código***");
                                LocalDateTime tiempo = LocalDateTime.now();

                                break;

                            case "3":
                                JOptionPane.showMessageDialog(null, "***Bloquear Código***");
                                break;

                            case "4":
                                do {
                                    opcionEliminar = JOptionPane.showInputDialog("***Eliminar Quickpass***\n1) Eliminar por código\n2) Eliminar por Placa\n3) Salir");
                                    switch (opcionEliminar) {
                                        case "1":
                                            int codigo_Elimina = Integer.parseInt(JOptionPane.showInputDialog("***Eliminar por Código***\n" + qPass + "\nDigite el código del Quickpass a eliminar: "));
                                            Quickpass quickpass_Eliminar = qPass.eliminarQuick_Codigo(codigo_Elimina);
                                            quickpassEliminados.agregarQuickpass(quickpass_Eliminar);
                                            break;
                                            
                                        case "2":
                                            int placa_Elimina = Integer.parseInt(JOptionPane.showInputDialog("***Eliminar por Placa***\n" + qPass + "\nDigite la placa del Quickpass a eliminar: "));
                                            Quickpass quickpass_Eliminar_placa = qPass.eliminarQuick_Placa(placa_Elimina);
                                            quickpassEliminados.agregarQuickpass(quickpass_Eliminar_placa);
                                            
                                            break;
                                            
                                        case "3":
                                            JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Eliminar!");
                                            break;
                                            
                                        default:
                                            throw new AssertionError();
                                    }
                                } while (!opcionEliminar.equals("3"));
                                

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
