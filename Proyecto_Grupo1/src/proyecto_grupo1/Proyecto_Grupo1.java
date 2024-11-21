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
        String opcion = "";
        String opcionMenuQuickPass = "";
        ArchivosTxt arc = new ArchivosTxt();

        do {
            opcion = JOptionPane.showInputDialog("***Bienvenido***\n1) Gestion de QuickPass\n2) Gestion de Accesos\n3) Reporte\n4) Salir");
            switch (opcion) {
                case "1":
                    do {
                        opcionMenuQuickPass = JOptionPane.showInputDialog("***Gestion de QuickPass***\n1) Crear\n2) Consulta\n3) Salir");
                        switch (opcionMenuQuickPass) {
                            case "1":
                                Quickpass q1 = new Quickpass(); //Crea objeto default
                                String filial_Quick = JOptionPane.showInputDialog("Digite la filial: ");
                                q1.setFilial(filial_Quick);
                                String filial_Def = q1.getFilial();

                                String codigo_Quick = JOptionPane.showInputDialog("Digite el código del Quickpass (101XXXXXXX): ");
                                q1.setCodigo(codigo_Quick);

                                int codigo_Def = q1.getCodigo(); //Valor actual en codigo para ver si el usuario lo digito bien
                                while (codigo_Def == -1 || codigo_Def == -2) { //ciclo para que lo repita hasta que esté bien
                                    codigo_Quick = JOptionPane.showInputDialog("Digite el código del Quickpass (101XXXXXXX): ");
                                    q1.setCodigo(codigo_Quick);
                                    codigo_Def = q1.getCodigo();
                                }

                                int placa_Quick = Integer.parseInt(JOptionPane.showInputDialog("Digite la placa: "));
                                q1.setPlaca(placa_Quick);
                                int Placa_Def = q1.getPlaca();

                                Enum Estado_Def = q1.getEstado();

                                System.out.println(q1.toString()); //Verificar objeto creado
                                
                                LocalDateTime tiempo = LocalDateTime.now();
                                
                                arc.escribir_TXT(filial_Def + "|" + codigo_Def + "|" + Placa_Def + "|" + Estado_Def + "|" + tiempo);
                                break;

                            case "2":
                                JOptionPane.showMessageDialog(null, "Consultas (En desarrollo)");
                                break;

                            case "3":
                                JOptionPane.showMessageDialog(null, "Saliendo del Gestion de QuickPass");
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

                    } while (!opcionMenuQuickPass.equals("3")); //Final Do While Gestion
                    break;

                case "2":
                    String lectura = arc.leer_TXT();
                    JOptionPane.showMessageDialog(null, "En el txt se encuentra: " + lectura);
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
