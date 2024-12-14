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

/**
 *
 * @author Joseph Daniel Alvarado Gómez, Brayan Ruiz Valverde Jeancarlo Loria
 * Brenes, Marco Antonio Alvarez Mejia
 */



public class ArchivosTxt {
    
    public void borrarContenido_TXT(String parametro) {
    try {
       
        BufferedWriter writer = new BufferedWriter(new FileWriter(parametro));

        writer.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    public void escribir_TXT(Quickpass quickpass, String parametro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(parametro, true));
            
            writer.write(quickpass.getFilial() + "|" + 
                     quickpass.getCodigo() + "|" + 
                     quickpass.getPlaca() + "|" + 
                     quickpass.getEstado() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
   
    public void leerInicio_TXT(String parametro, ArregloQuickpass listaDestino) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(parametro));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                String filial = datos[0];
                String codigoStr = datos[1];
                String placaStr = datos[2];
                String pEstado = datos[3];
                Estado estado = Estado.valueOf(pEstado); // Convertimos el estado de texto a tipo Estado

                // Convertimos los códigos y placas a enteros
                int codigo = Integer.parseInt(codigoStr);
                int placa = Integer.parseInt(placaStr);

                // Creamos un nuevo Quickpass
                Quickpass quickpass_Nuevo = new Quickpass(filial, codigo, placa, estado);

                // Añadimos el Quickpass a la lista correspondiente
                listaDestino.agregarQuickpass(quickpass_Nuevo);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
}
