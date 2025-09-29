/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public enum BaseCombo {
    HAMBURGUESA("Hamburguesa", 12.00),
    POLLO("Pollo", 11.50),
    VEGETARIANO("Vegetariano", 10.50);

    private final String etiqueta;
    private final double precioBase;

    BaseCombo(String etiqueta, double precioBase) {
        this.etiqueta = etiqueta;
        this.precioBase = precioBase;
    }
    public String getEtiqueta() {
        return etiqueta;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    @Override
    public String toString() {
        return etiqueta;
    }
}
