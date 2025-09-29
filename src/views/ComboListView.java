package views;

import java.awt.BorderLayout;
import javax.swing.*;
import controllers.ComboListController;
import core.Model;
import core.View;

@SuppressWarnings("serial")
public class ComboListView extends JPanel implements View {
    private ComboListController controller;
    private JTable table;

    public ComboListView(ComboListController controller, JTable table) {
        this.controller = controller;
        this.table = table;
        setLayout(new BorderLayout());
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    @Override
    public void update(Model model, Object data) {
        if (data != null) JOptionPane.showMessageDialog(this, (String) data);
    }
}
