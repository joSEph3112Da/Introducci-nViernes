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
public class Quickpass {//Atributos

    private String filial;
    private int codigo;
    private int placa;
    private Estado estado;

    public Quickpass() { //Constructor
        this.estado = Estado.Activo; //Default Estado 
        this.filial = filial;
        this.codigo = codigo;
        this.placa = placa;

        System.out.println(this.toString()); //ToString
    }

    public void setCodigo(String pCodigo) { //Setea el Codigo validado de 10 digitos y que comience con 101

        if (pCodigo.length() == 10) {
            if (pCodigo.substring(0, 3).equals("101")) { //Valida
                this.codigo = Integer.parseInt(pCodigo);
            } else {
                JOptionPane.showMessageDialog(null, "El Código: " + pCodigo + " debe de comenzar con 101", "Error", JOptionPane.ERROR_MESSAGE);
                this.codigo = -2;
            }

        } else {
            JOptionPane.showMessageDialog(null, "El Código: " + pCodigo + " debe tener 10 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            this.codigo = -1;
        }

    }

    public int getCodigo() {
        return codigo;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public int getPlaca() {
        return placa;
    }

    public void setPlaca(int placa) {
        this.placa = placa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() { //toString
        return "Quickpass [filial=" + filial + ", codigo=" + codigo + ", placa=" + placa + ", estado=" + estado + "]";
    }
}
