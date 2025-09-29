package controllers;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import core.Controller;
import models.ComboIO;
import views.ComboListView;

public class ComboListController extends Controller {
    private ComboListView view;
    private JTable table;
    private DefaultTableModel model;

    @Override
    public void run() {
        model = new DefaultTableModel(getColumns(), 0) {
            @Override 
            public boolean isCellEditable(int r, int c) 
            { 
                return false; 
            }
        };
        table = new JTable(model);
        table.setAutoCreateRowSorter(true);
        view = new ComboListView(this, table);
        loadCombos();
    }

    private void loadCombos() {
        try {
            ComboIO io = new ComboIO();
            io.attach(view);
            Vector<Vector<Object>> rows = io.obtenerCombos();
            if (rows != null) {
                for (Vector<Object> r : rows) 
                    model.addRow(r);
            }
        } catch (Exception e) { }
    }

    public void addNewRow(Object[] values) {
        if (SwingUtilities.isEventDispatchThread()) model.addRow(values);
        else SwingUtilities.invokeLater(() -> model.addRow(values));
    }

    public ComboListView getView() { 
        return view; 
    }

    private Vector<String> getColumns() {
        Vector<String> v = new Vector<>();
        v.add("Base combo");
        v.add("Bebida");
        v.add("Acompañamiento");
        v.add("Extra");
        v.add("Total");
        return v;
    }
}
