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
    private String generados = "Generados.txt";
    private String filial, codigo, placa, pEstado;
    private Estado estado;
    metodosValidacion valida = new metodosValidacion();
    
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
   
    public void leerInicio_TXT(String parametro) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(parametro));
            String linea;
            while ((linea = reader.readLine()) != null) {
                
                String[] datos = linea.split("\\|");
                filial = datos[0];
                codigo = datos[1];
                placa = datos[2];
                pEstado = datos[3];
                estado = Estado.valueOf(pEstado);
                
                filial = valida.valNoVacio(filial);
                int pcodigo = valida.verificacionNumeroNoVacio(Integer.parseInt(codigo));
                codigo = ""+pcodigo;
                int pplaca = valida.verificacionNumeroNoVacio(Integer.parseInt(placa));
                placa=""+pplaca;
                
                Quickpass quickpass_Nuevo = new Quickpass(filial, Integer.parseInt(codigo), Integer.parseInt(placa),estado);  
            }
            reader.close();
              
       
        } catch (IOException e) {
            e.printStackTrace(System.out);
            
        }
    }
    
    public void leerArchivos() {
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(generados));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                filial = datos[0];
                codigo = datos[1];
                placa = datos[2];
                pEstado = datos[3];
                estado = Estado.valueOf(pEstado);
                
                filial = valida.valNoVacio(filial);
                int pcodigo = valida.verificacionNumeroNoVacio(Integer.parseInt(codigo));
                codigo = ""+pcodigo;
                int pplaca = valida.verificacionNumeroNoVacio(Integer.parseInt(placa));
                placa=""+pplaca;
                
                Quickpass quickpass_Nuevo = new Quickpass(filial, Integer.parseInt(codigo), Integer.parseInt(placa),estado);  
            }
            reader.close();
              
       
        } catch (IOException e) {
            e.printStackTrace(System.out);
            
        }
    }
}
