/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public enum Acompanamiento {
    PAPAS_FRITAS("Papas fritas", 3.50),
    ENSALADA("Ensalada", 4.00),
    NUGGETS("Nuggets", 5.00);

    private final String etiqueta;
    private final double precio;

    Acompanamiento(String etiqueta, double precio) {
        this.etiqueta = etiqueta;
        this.precio = precio;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return etiqueta;
    }
}