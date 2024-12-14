/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_grupo1;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        String opcion; //Variable de Menu Inicial
        String opcionMenuQuickPass; //Variable menu Quickpass
        String opcionEliminar; //Variable menu de eliminar Quickpass
        String opcionMenuVista; //Variable menu de vista
        String opcionMenuVistaNormal;  //Variable menu de vista no eliminados
        String opcionMenuVistaEliminados;  //Variable menu de vista eliminados
        String opcionGestionAccesos;  //Variable menu Gestion Accesos
        String opcionConsultaGestionAccesos;
        ArregloQuickpass qPass = new ArregloQuickpass(5); //Arreglo de Quickpass
        ArregloQuickpass quickpassEliminados = new ArregloQuickpass(15); //Arreglo de los eliminados

        HistorialTxt historialTxt = new HistorialTxt();// Metodo que hace las validaciones
        ArchivosTxt arc = new ArchivosTxt(); //Metodos TXT
        arc.leerInicio_TXT("Generados.txt", qPass);
        arc.leerInicio_TXT("Eliminados.txt", quickpassEliminados);

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
                    do {
                        opcionGestionAccesos = JOptionPane.showInputDialog("***Gestion de Accesos***\n1) Verificar acceso\n2) Realizar Consultas\n3)  Salir");

                        if (opcionGestionAccesos == null) {
                            JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Accesos!");
                            break;
                        }
                        switch (opcionGestionAccesos) {
                            case "1":
                                int verificacion = valida.validaCodigo();
                                qPass.validarAcceso(verificacion);
                                
                                break;
                            case "2":
                                do {
                                    opcionConsultaGestionAccesos = JOptionPane.showInputDialog("***Consulta de Gestion de Accesos***\n1) Verificar con filial\n2) Verificar con Rango de Fechas\n3) Verificar con Codigo\n4) Verificar con Placa\n5) Salir");
                                    if (opcionConsultaGestionAccesos == null) {
                                        JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Accesos!");
                                        break;
                                    }
                                    switch (opcionConsultaGestionAccesos) {
                                        case "1":
                                            String opcionValidacion = JOptionPane.showInputDialog("Seleccione la filial que desea validar:");
                                            String filialValida = historialTxt.verificarFilial(opcionValidacion);
                                            JOptionPane.showMessageDialog(null, filialValida);
                                            break;
                                        case "2":
                                            LocalDateTime fechaInicio = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha de inicio con el formato: (dd-MM-yyyy HH:mm:ss):"), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                                            LocalDateTime fechaFin = LocalDateTime.parse(JOptionPane.showInputDialog("Ingrese la fecha de fin (dd-MM-yyyy HH:mm:ss):"), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
                                            String fechasValidas = historialTxt.verificarRangoFechas(fechaInicio, fechaFin);
                                            JOptionPane.showMessageDialog(null, fechasValidas);
                                            break;
                                        case "3":
                                            int codigoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero delcódigo:"));
                                            String codigoEncontrado = historialTxt.verificarPorCodigo(codigoBuscar);
                                            JOptionPane.showMessageDialog(null, codigoEncontrado);
                                            break;
                                        case "4":
                                            int placaBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de la placa:"));
                                            String placaEncontrado = historialTxt.verificarPorPlaca(placaBuscar);
                                            JOptionPane.showMessageDialog(null, placaEncontrado);
                                            break;
                                        case "5":
                                            JOptionPane.showMessageDialog(null, "¡Saliendo de Consulta de Gestion de Accesos!");
                                            break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                                } while (!opcionConsultaGestionAccesos.equals("5"));
                                break;
                            case "3":
                                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Accesos!");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (!opcionGestionAccesos.equals("3"));
                    break;

                case "3":
                    String menuReportes;
                    do {
                        menuReportes = JOptionPane.showInputDialog("Menú Reportes\n"
                                + "1) Ver Total de Quickpass registrados\n"
                                + "2) Ver Total de Total de Quickpass Activos\n"
                                + "3) Ver Total de Total de Quickpass Inactivos\n"
                                + "4) Ver Total de Total de Quickpass Eliminados\n"
                                + "5) Ver Total de Accesos\n"
                                + "6) Ver Total de Accesos por filial\n"
                                + "7) Salir");

                        if (menuReportes == null) {
                            JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Accesos!");
                            break;
                        }
                        switch (menuReportes) {
                            case "1":
                                int totalRegistrados = qPass.contadorQuickPass();
                                JOptionPane.showMessageDialog(null, "Total de Quickpass registrados: " + totalRegistrados);
                                break;

                            case "2":
                                int activosCount = qPass.countByEstado(Estado.Activo);
                                JOptionPane.showMessageDialog(null, "Total de Quickpass Activos: " + activosCount);
                                break;

                            case "3":
                                int inactivosCount = qPass.countByEstado(Estado.Inactivo);
                                JOptionPane.showMessageDialog(null, "Total de Quickpass Inactivos: " + inactivosCount);
                                break;

                            case "4":
                                int eliminadosCount = quickpassEliminados.contadorQuickPass();
                                JOptionPane.showMessageDialog(null, "Total de Quickpass Eliminados: " + eliminadosCount);
                                break;

                            case "5":
                                JOptionPane.showMessageDialog(null, "Total de accesos: " + historialTxt.contadorConsulta());
                                break;
                                
                            case "6":
                                String opcionValidacion = JOptionPane.showInputDialog("Seleccione la filial que desea validar:");
                                int filialContador = historialTxt.contadorFilial(opcionValidacion);
                                JOptionPane.showMessageDialog(null, "Total de accesos para la filial " + opcionValidacion + ": " + filialContador);

                                break;

                            case "7":
                                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Reportes!");
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida, intente de nuevo.");
                        }

                    } while (!menuReportes.equals("7"));

                    break;

                case "4":
                    JOptionPane.showMessageDialog(null, "¡Hasta Luego!");
                    arc.borrarContenido_TXT("Generados.txt");
                    qPass.guardaTXTLista("Generados.txt");
                    arc.borrarContenido_TXT("Eliminados.txt");
                    quickpassEliminados.guardaTXTLista("Eliminados.txt");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }//Switch Menu Principal
        } while (!opcion.equals("4")); //Final Do While Menu Principal
    }
}
