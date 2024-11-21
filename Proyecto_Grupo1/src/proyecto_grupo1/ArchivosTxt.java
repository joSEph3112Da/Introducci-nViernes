/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_grupo1;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joseph Daniel Alvarado Gómez, Brayan Ruiz Valverde Jeancarlo Loria
 * Brenes, Marco Antonio Alvarez Mejia
 */
public class ArchivosTxt {

    public void escribir_TXT(String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Prueba.txt"));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public  String leer_TXT() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Prueba.txt"));
            String line = reader.readLine();
            reader.close();
            return line;    
       
        } catch (IOException e) {
            return "Error al leer";
        }
    }

}
