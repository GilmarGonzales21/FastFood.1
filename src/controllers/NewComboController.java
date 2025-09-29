package controllers;

import javax.swing.JOptionPane;
import core.Controller;
import models.*;
import views.ComboListView;
import views.NewComboView;

public class NewComboController extends Controller {
    private NewComboView view;
    private final ComboListController listController;

    public NewComboController(ComboListController listController) {
        this.listController = listController;
    }
    
    @Override
    public void run() {
        view = new NewComboView(this);
    }
    public void addCombo(BaseCombo base, Bebida bebida, Acompanamiento acompanamiento, Extra extra) {
        try {
            Combo combo = new ComboBuilder(base).conBebida(bebida).conAcompanamiento(acompanamiento).conExtra(extra).construir();
            ComboIO io = new ComboIO();
            io.attach(view);
            io.guardarCombo(combo);

            Object[] row = {
                base.getEtiqueta(),
                bebida.getEtiqueta(),
                acompanamiento.getEtiqueta(),
                extra.getEtiqueta(),
                String.format("%.2f", combo.getTotal())
            };
            listController.addNewRow(row);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public NewComboView getView() {
        return view;
    }

    public ComboListView getListView() {
        return listController.getView();
    }

}
