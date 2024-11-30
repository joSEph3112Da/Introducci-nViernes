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
       
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getEstado() == Estado.valueOf(parametro)) {
                mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
            }
        }

        return mensaje;

    }
    
    public void mostrarporFilial() {
        String mensaje = "\n";
        String p_Filial =JOptionPane.showInputDialog("***Menu Mostrar por Filial***\nEscriba la Filial");
        for (int i = 0; i < listQuickpass.length; i++) {
            if (listQuickpass[i] != null && listQuickpass[i].getFilial().equals(p_Filial)) {
                mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public void mostrarporBusqueda() {
        String mensaje = "\n";
        String p_Busqueda = "";
        String filial_Busqueda;
        String estado_Busqueda;
        int codigo_Busqueda;
        int placa_Busqueda;
        do {
            p_Busqueda =JOptionPane.showInputDialog("***Menu Mostrar por Busqueda***\n1) Por Filial\n2) Por Codigo\n3) Por Placa\n4) Por Estado\n5) Salir");
            
            if (p_Busqueda == null) {
                JOptionPane.showMessageDialog(null, "¡Saliendo de Gestion de Quickpass!");
                break;
            }
            
            switch (p_Busqueda) {
                case "1":
                    filial_Busqueda=JOptionPane.showInputDialog("***Menu Mostrar por Filial***\nEscriba la Filial");
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getFilial().equals(filial_Busqueda) ) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    break;
                case "2":
                    codigo_Busqueda=Integer.parseInt(JOptionPane.showInputDialog("***Menu Mostrar por Código***\nEscriba la Codigo"));
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getCodigo()== codigo_Busqueda) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    break;
                case "3":
                    placa_Busqueda=Integer.parseInt(JOptionPane.showInputDialog("***Menu Mostrar por Placa***\nEscriba la Placa"));
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getPlaca()== placa_Busqueda) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    break;
                    
                case "4":
                    estado_Busqueda=JOptionPane.showInputDialog("***Menu Mostrar por Estado***\nEscriba el Parametro");
                    for (int i = 0; i < listQuickpass.length; i++) {
                        if (listQuickpass[i] != null && listQuickpass[i].getEstado()== Estado.valueOf(estado_Busqueda) ) {
                            mensaje += (i + 1) + ") " + listQuickpass[i] + "\n";
                        }
                    }
                    break;
                case "5":
                    p_Busqueda="5";
                    JOptionPane.showMessageDialog(null, "¡Saliendo!");
                    break;
                
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta, intente de nuevo",
                            "Error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } while (!p_Busqueda.equals("5"));
    }
    

    @Override
    public String toString() {
        String mensaje = "\n";
        for (int x = 0; x < listQuickpass.length; x++) {
            mensaje += (x + 1) + ") " + listQuickpass[x] + "\n";
        }
        return mensaje;

    }
    
    
    
}