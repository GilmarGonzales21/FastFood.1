/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public enum Bebida {
    COLA("CocaCola", 3.00),
    JUGO_NARANJA("Jugo de naranja", 4.50),
    AGUA("Agua", 2.00);
    private final String etiqueta;
    private final double precio;
    Bebida(String etiqueta, double precio) {
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
