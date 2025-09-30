/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public class Combo {
    private BaseCombo base;
    private Bebida bebida;
    private Acompanamiento acompanamiento;
    private Extra extra;
    
    public Combo(BaseCombo base){
        this.base = base;
    }

    public BaseCombo getBase() { //
        return base;
    }

    public Bebida getBebida() { //
        return bebida;
    }

    public void setBebida(Bebida bebida) { //
        this.bebida = bebida;
    }

    public Acompanamiento getAcompanamiento() { //
        return acompanamiento;
    }

    public void setAcompanamiento(Acompanamiento acompanamiento) { //
        this.acompanamiento = acompanamiento;
    }

    public Extra getExtra() { //
        return extra;
    }

    public void setExtra(Extra extra) { //
        this.extra = extra;
    }
    
    public double getTotal(){
        double total = base.getPrecioBase();
        if (bebida !=null) {
            total += bebida.getPrecio();
        }
        
        if (acompanamiento !=null) {
            total += acompanamiento.getPrecio();
        }
        
        if (extra != null) {
            total += extra.getPrecio();
        }
        return total;
    }

    public String toFileName() {
        return base.name() + ";" + bebida.name() + ";" + acompanamiento.name() + ";" + extra.name();
    }
}
