/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author gilma
 */
public class ComboBuilder {
    private Combo combo;
    
    public ComboBuilder(BaseCombo base){
        this.combo = ComboFactory.crear(base);
    }
    
    public ComboBuilder conBebida(Bebida bebida){
        combo.setBebida(bebida);
        return this;
    }
    
    public ComboBuilder conAcompanamiento(Acompanamiento acompanamiento){
        combo.setAcompanamiento(acompanamiento);
        return this;
    }
    
    public ComboBuilder conExtra(Extra extra){
        combo.setExtra(extra);
        return this;
    }
    
    public Combo construir(){
        return combo;
    }
}
