/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupo1;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
/**
 * @author Joseph Daniel Alvarado Gómez, Brayan Ruiz Valverde Jeancarlo Loria
 * Brenes, Marco Antonio Alvarez Mejia
 */
public class HistorialTxt {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formato = myDateObj.format(myFormatObj);
    private String historial = "Historial.txt";
    private String s = "|";
    
    
    public void Historial_TXT(String acceso, Quickpass quickpass) {
        try {
            
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(historial, true));
            writer.write(quickpass.getFilial() +s+
                    quickpass.getCodigo() +s+
                    quickpass.getPlaca() +s+
                    quickpass.getEstado() +s+
                    formato +s+
                    acceso +s + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, quickpass+" "+formato+" "+acceso);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// -----------------------------------------CONSULTAS-----------------------------------------    
    public String verificarFilial(String opcionValidacion) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(historial));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String filial = datos[0];
                if (filial.equals(opcionValidacion)) {
                    reader.close(); 
                    return linea;
                    
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "La filial " + opcionValidacion + " no se encuentra registrada.";
    }
    
    public String verificarRangoFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(historial));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            String fechaStr = datos[4];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime fechaAVerificar = LocalDateTime.parse(fechaStr, formatter);
            if (fechaAVerificar.isAfter(fechaInicio.minusDays(1)) && fechaAVerificar.isBefore(fechaFin.plusDays(1))) {
                reader.close();
                return linea;
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "No se encontraron datos en el rango de fechas desde el " +fechaInicio + " hasta el " + fechaFin;
}
    
    public String verificarPorCodigo(int codigo) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(historial));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            System.out.println(datos);
            int codigoTransaccion = Integer.parseInt(datos[1]);
            
            if (codigoTransaccion == codigo) {
                reader.close();
                return linea;
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "El codigo " + codigo + " no se encuentra registrado.";
    }
    
    public String verificarPorPlaca(int placa) {
    try {
        BufferedReader reader = new BufferedReader(new FileReader(historial));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split("\\|");
            int codigoTransaccion = Integer.parseInt(datos[2]);
            
            if (codigoTransaccion == placa) {
                reader.close();
                return linea;
            }
        }
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return "La placa " + placa + " no se encuentra registrada.";
    }
    
    public int contadorConsulta(){
        int contador = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(historial));
            String linea;
            while ((linea = reader.readLine()) != null) {
                contador ++;
            }
            reader.close();
            
            
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        
        return contador;
    }
    
    public int contadorFilial(String opcionValidacion) {
        int contador = 0;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(historial));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String filial = datos[0];
                if (filial.equals(opcionValidacion)) {
                    contador ++;
                    
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }
    
}
