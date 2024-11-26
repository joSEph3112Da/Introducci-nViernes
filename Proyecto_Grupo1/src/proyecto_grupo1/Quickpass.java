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

    public Quickpass(String pFilial, int pCodigo, int pPlaca) { //Constructor
        this.estado = Estado.Activo; //Default Estado
        this.codigo = pCodigo;
        this.filial = pFilial;
        this.placa = pPlaca;

    }

    public void setCodigo(int pCodigo) { //Setea el Codigo validado de 10 digitos y que comience con 101
        this.codigo = pCodigo;
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
