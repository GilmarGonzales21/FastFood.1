/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public enum Extra {
    NINGUNO("Sin extra", 0.0),
    QUESO("Queso", 1.00),
    TOCINO("Tocino", 1.50),
    HELADO("Helado", 3.00);

    private final String etiqueta;
    private final double precio;

    Extra(String etiqueta, double precio) {
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
