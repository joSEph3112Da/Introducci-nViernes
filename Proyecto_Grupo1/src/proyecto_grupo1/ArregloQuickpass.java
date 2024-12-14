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

    ArchivosTxt archivostxt = new ArchivosTxt(); // Metodo de lectura de Archivo

    private Quickpass listQuickpass[];
    private int cupo;

    public ArregloQuickpass(int tamanno) {
        listQuickpass = new Quickpass[tamanno];
        cupo = tamanno;
    }

    public void agregarQuickpass(Quickpass pQuickNew) {

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] == null) {
                listQuickpass[i] = pQuickNew;
                cupo--;

                break;
            }

        }

    }//hacer leer al inicio basado en esto

    public String accesos() {
        String estaAcceso = "Error de Acceso";
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[3] != null && listQuickpass[i].getEstado() == Estado.valueOf("Activo")) {
                estaAcceso = "Aceptado";
            } else {
                estaAcceso = "Rechazado";
            }
            return estaAcceso;
        }
        return estaAcceso;
    }

    public int getCupo() {
        return cupo;
    }

    public Quickpass eliminarQuick_Codigo(int codigo_Elimina) {
        Quickpass r = null;

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getCodigo() == codigo_Elimina) {
                r = listQuickpass[i];
                listQuickpass[i] = null;
                cupo++;
                JOptionPane.showMessageDialog(null, "El Quickpass ha sido eliminado correctamente");
                break;
            }
        }

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Codigo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return r;

    }

    public Quickpass eliminarQuick_Placa(int placa_Elimina) {
        Quickpass r = null;

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getPlaca() == placa_Elimina) {
                r = listQuickpass[i];
                listQuickpass[i] = null;
                cupo++;
                JOptionPane.showMessageDialog(null, "El Quickpass ha sido eliminado correctamente");
                break;
            }
        }

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Placa no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return r;

    }

    public Quickpass desactivar_Codigo(int codigo_Desactiva) {
        Quickpass r = null;

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getCodigo() == codigo_Desactiva) {
                if (listQuickpass[i].getEstado() == Estado.Inactivo) {
                    JOptionPane.showMessageDialog(null, "El Quickpass ya se encuentra desactivado", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    r = listQuickpass[i];
                    listQuickpass[i].setEstado(Estado.Inactivo);
                    JOptionPane.showMessageDialog(null, "El Quickpass ha sido desactivado correctamente");
                    break;
                }
            }
        }

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Codigo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return r;

    }

    public Quickpass activar_Codigo(int codigo_Activa) {
        Quickpass r = null;

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getCodigo() == codigo_Activa) {
                if (listQuickpass[i].getEstado() == Estado.Activo) {
                    JOptionPane.showMessageDialog(null, "El Quickpass ya se encuentra activado", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    r = listQuickpass[i];
                    listQuickpass[i].setEstado(Estado.Activo);
                    JOptionPane.showMessageDialog(null, "El Quickpass ha sido activado correctamente");
                    break;
                }
            }
        }

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Codigo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return r;

    }

    public String mostrarActivosoInactivos(String parametro) {
        String mensaje = "\n";
        int contador = 0;
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getEstado() == Estado.valueOf(parametro)) {
                mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                contador++;
            }
        }

        if (contador == 0) {
            mensaje += "\nNo hay registros\n";
        }

        return mensaje;

    }

    public void mostrarporFilial() {
        String mensaje = "\n";
        int contador = 0;
        String p_Filial = JOptionPane.showInputDialog("***Menu Mostrar por Filial***\nEscriba la Filial");
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getFilial().equals(p_Filial)) {
                mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
            }
        }

        if (contador == 0) {
            mensaje += "\nNo hay registros\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarporBusqueda() {
        String p_Busqueda = "";
        String filial_Busqueda;
        String estado_Busqueda;
        int codigo_Busqueda;
        int placa_Busqueda;

        do {
            p_Busqueda = JOptionPane.showInputDialog("***Menu Mostrar por Busqueda***\n1) Por Filial\n2) Por Codigo\n3) Por Placa\n4) Por Estado\n5) Salir");
            String mensaje = "\n";
            int contador = 0;

            if (p_Busqueda == null) {
                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Quickpass!");
                break;
            }

            switch (p_Busqueda) {
                case "1":
                    filial_Busqueda = JOptionPane.showInputDialog("***Menu Mostrar por Filial***\nEscriba la Filial");
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getFilial().equals(filial_Busqueda)) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    if (contador == 0) {
                        mensaje += "\nNo hay registros\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "2":
                    codigo_Busqueda = Integer.parseInt(JOptionPane.showInputDialog("***Menu Mostrar por Código***\nEscriba la Codigo"));
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getCodigo() == codigo_Busqueda) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    if (contador == 0) {
                        mensaje += "\nNo hay registros\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "3":
                    placa_Busqueda = Integer.parseInt(JOptionPane.showInputDialog("***Menu Mostrar por Placa***\nEscriba la Placa"));
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getPlaca() == placa_Busqueda) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    if (contador == 0) {
                        mensaje += "\nNo hay registros\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;

                case "4":
                    estado_Busqueda = JOptionPane.showInputDialog("***Menu Mostrar por Estado***\nEscriba el Estado");
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getEstado() == Estado.valueOf(estado_Busqueda)) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    if (contador == 0) {
                        mensaje += "\nNo hay registros\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "5":
                    p_Busqueda = "5";
                    JOptionPane.showMessageDialog(null, "¡Saliendo!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }

        } while (!p_Busqueda.equals("5"));
    }

    public void guardaTXTLista(String parametro) {
        ArchivosTxt arc = new ArchivosTxt();
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null) {
                Quickpass quickGuarda = listQuickpass[i];
                arc.escribir_TXT(quickGuarda, parametro);
            }
        }

    }
    
    public int contadorQuickPass() {
        int qcontador = 0;
        int i = 0;
        if (listQuickpass.length > 0) {
            do {
                if (listQuickpass[i] != null) {
                    qcontador++;
                }
                i++;
            } while (i < listQuickpass.length);
        }
        return qcontador;
    }

    public int countByEstado(Estado estado) {
        int econtador = 0;
        int i = 0;
        if (listQuickpass.length > 0) {
            do {
                if (listQuickpass[i] != null && listQuickpass[i].getEstado() == estado) {
                    econtador++;
                }
                i++;
            } while (i < listQuickpass.length);
        }
        return econtador;
    }

    // -------------------------------------------------------------------Historial-----------------------------------------------------------  
    public void validarAcceso(int codigoBuscado) {
        String estadoAcceso = "Rechazado";
        HistorialTxt historialTxt = new HistorialTxt();
        Quickpass qpassValida = null;

        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getCodigo() == codigoBuscado) {
                if (listQuickpass[i].getEstado() == Estado.Activo) {
                    estadoAcceso = "Aprobado";
                    qpassValida = listQuickpass[i];
                } else {
                    qpassValida = listQuickpass[i];
                }

            } else {
                qpassValida = new Quickpass("", codigoBuscado, 0);
            }

        }
        historialTxt.Historial_TXT(estadoAcceso, qpassValida);

    }
    //-----------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        String mensaje = "\n";
        for (int x = 0; x < listQuickpass.length; x++) {
            if (listQuickpass[x] == null) {
                mensaje += (x + 1) + ") " + "Sin registro" + "\n";
            } else {
                mensaje += (x + 1) + ") " + listQuickpass[x] + "\n";
            }

        }
        return mensaje;
    }
}
