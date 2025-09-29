/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.*;
import java.util.*;
import core.Model;
import core.View;
/**
 *
 * @author gilma
 */
public class ComboIO implements Model{
    
    private static final String DIRECTIVO =".";
    private static final String ARCHIVO = "combos.txt";
    private List<View> vistas = new ArrayList<>();
    private String aviso;
    @Override
    public void attach(View view) {
        vistas.add(view);
    }

    @Override
    public void detach(View view) {
        vistas.remove(view);
    }

    @Override
    public void notifyViews() {
        for (View v : vistas) {
            v.update(this, aviso);
        }
    }
    
    public void guardarCombo(Combo combo) throws Exception{
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(DIRECTIVO, ARCHIVO), true))) {
            bw.write(combo.toFileName());
            bw.newLine();
        } catch (Exception ex) {
            aviso = "No se pudo guardar el combo";
            notifyViews();
            throw ex;
        }
    }
    
    public Vector<Vector<Object>> obtenerCombos() throws Exception{
                Vector<Vector<Object>> filas = new Vector<>();
        File f = new File(DIRECTIVO, ARCHIVO);
        if (!f.exists()) return filas;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] t = linea.split(";");
                if (t.length < 4) continue;
                BaseCombo base = BaseCombo.valueOf(t[0]);
                Bebida bebida = Bebida.valueOf(t[1]);
                Acompanamiento acompanamiento = Acompanamiento.valueOf(t[2]);
                Extra extra = Extra.valueOf(t[3]);

                Combo combo = new Combo(base);
                combo.setBebida(bebida);
                combo.setAcompanamiento(acompanamiento);
                combo.setExtra(extra);

                Vector<Object> fila = new Vector<>();
                fila.add(base.getEtiqueta());
                fila.add(bebida.getEtiqueta());
                fila.add(acompanamiento.getEtiqueta());
                fila.add(extra.getEtiqueta());
                fila.add(String.format("%.2f", combo.getTotal()));
                filas.add(fila);
            }
        } catch (Exception ex) {
            aviso = "Hubo un problema leyendo combos";
            notifyViews();
            throw ex;
        }
        return filas;
    }
}
