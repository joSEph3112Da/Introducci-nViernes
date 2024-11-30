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
        String opcionMenuVista = ""; //Variable menu de vista
        String opcionMenuVistaNormal = "";  //Variable menu de vista no eliminados
        String opcionMenuVistaEliminados = "";  //Variable menu de vista eliminados
        ArregloQuickpass qPass = new ArregloQuickpass(5); //Arreglo de Quickpass
        ArregloQuickpass quickpassEliminados = new ArregloQuickpass(15); //Arreglo de los eliminados
        

        do {
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Gestion de QuickPass\n2) Gestion de Accesos\n3) Reporte\n4) Salir");
            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
                break;
            }

            switch (opcion) {
                case "1":
                    do {
                        opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de QuickPass***\n1) Crear Quickpass\n2) Visualizaciones\n3) Bloquear Quickpass\n"
                                + "4) Activar Quickpass\n5) Eliminar Quickpass\n6) Salir");
                        if (opcionMenuQuickPass == null) {
                            JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Quickpass!");
                            break;
                        }

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

                            case "2":
                                do {
                                    opcionMenuVista = JOptionPane.showInputDialog("***Menu de Vista***\n1) Visualizar Quickpass\n2) Visualizar Quickpass Eliminados\n3) Salir");
                                    if (opcionMenuVista == null) {
                                        JOptionPane.showMessageDialog(null, "¡Saliendo de Vista Normal!");
                                        break;
                                    }
                                    switch (opcionMenuVista) {
                                        case "1":
                                            do {
                                                opcionMenuVistaNormal = JOptionPane.showInputDialog("***Menu de Vista***\n1) Ver Todos\n2) Ver por Filial\n3) Busqueda Específica\n4) Salir");
                                                switch (opcionMenuVistaNormal) {
                                                    case "1":
                                                        JOptionPane.showMessageDialog(null, "***Quickpass Creados***" + qPass);
                                                        break;

                                                    case "2":
                                                        qPass.mostrarporFilial();
                                                        break;

                                                    case "3":
                                                        qPass.mostrarporBusqueda();
                                                        break;

                                                    case "4":
                                                        JOptionPane.showMessageDialog(null, "¡Saliendo de Vista Normal!");
                                                        break;

                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } while (!opcionMenuVistaNormal.equals("4"));

                                            break;
                                        case "2":
                                            do {
                                                opcionMenuVistaEliminados = JOptionPane.showInputDialog("***Menu de Vista***\n1) Ver Todos\n2) Ver por Filial\n3) Busqueda Específica\n4) Salir");

                                                if (opcionMenuVistaEliminados == null) {
                                                    JOptionPane.showMessageDialog(null, "¡Saliendo de Vista de Eliminados!");
                                                    break;
                                                }

                                                switch (opcionMenuVistaEliminados) {
                                                    case "1":
                                                        JOptionPane.showMessageDialog(null, "***Quickpass Eliminados***" + quickpassEliminados);
                                                        break;

                                                    case "2":
                                                        quickpassEliminados.mostrarporFilial();
                                                        break;

                                                    case "3":
                                                        quickpassEliminados.mostrarporBusqueda();
                                                        break;  

                                                    case "4":
                                                        JOptionPane.showMessageDialog(null, "¡Saliendo de Vista de Eliminados!");
                                                        break;

                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                                                "Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                            } while (!opcionMenuVistaEliminados.equals("4"));

                                            break;
                                        case "3":
                                            JOptionPane.showMessageDialog(null, "¡Saliendo de Visualizar!");
                                            break;

                                        default:
                                            JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (!opcionMenuVista.equals("3"));

                                break;

                            case "3":
                                int codigo_Inactiva = Integer.parseInt(JOptionPane.showInputDialog("***Bloquear Código***" + qPass.mostrarActivosoInactivos("Activo") + "\nDigite el código del quickpass a Inactivar"));
                                qPass.desactivar_Codigo(codigo_Inactiva);
                                break;

                            case "4":
                                int codigo_Activar = Integer.parseInt(JOptionPane.showInputDialog("***Activar***" + qPass.mostrarActivosoInactivos("Inactivo") + "\nDigite el código del quickpass a Activar"));
                                qPass.activar_Codigo(codigo_Activar);
                                break;

                            case "5":
                                do {
                                    opcionEliminar = JOptionPane.showInputDialog("***Eliminar Quickpass***\n1) Eliminar por código\n2) Eliminar por Placa\n3) Salir");

                                    if (opcionEliminar == null) {
                                        JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Eliminar!");
                                        break;
                                    }
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
                                            JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (!opcionEliminar.equals("3"));

                                break;

                            case "6":
                                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Quickpass!");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                        }//Switch Menu Gestion

                    } while (!opcionMenuQuickPass.equals("6")); //Final Do While Gestion
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

                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }//Switch Menu Principal
        } while (!opcion.equals("4")); //Final Do While Menu Principal
    }
}
