package views;

import java.awt.Font;
import javax.swing.*;
import controllers.NewComboController;
import core.Model;
import core.View;
import models.*;

@SuppressWarnings("serial")
public class NewComboView extends JPanel implements View {
    private final NewComboController controller;
    private JRadioButton rHamb, rChicken, rVeggie;
    private JComboBox<Bebida> cbBebida;
    private JComboBox<Acompanamiento> cbAcompanamiento;
    private JComboBox<Extra> cbExtra;

    public NewComboView(NewComboController controller) {
        this.controller = controller;
        setLayout(null);

        JLabel lblBase = new JLabel("Base del combo");
        lblBase.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBase.setBounds(28, 26, 150, 16);
        add(lblBase);

        ButtonGroup bg = new ButtonGroup();
        rHamb = new JRadioButton("Hamburguesa", true);
        rHamb.setBounds(160, 22, 120, 23);
        add(rHamb);
        bg.add(rHamb);

        rChicken = new JRadioButton("Pollo");
        rChicken.setBounds(280, 22, 80, 23);
        add(rChicken);
        bg.add(rChicken);

        rVeggie = new JRadioButton("Vegetariano");
        rVeggie.setBounds(360, 22, 120, 23);
        add(rVeggie);
        bg.add(rVeggie);

        JLabel l1 = new JLabel("Bebida");
        l1.setFont(new Font("Tahoma", Font.BOLD, 11));
        l1.setBounds(28, 70, 120, 16);
        add(l1);

        cbBebida = new JComboBox<>(Bebida.values());
        cbBebida.setBounds(160, 66, 200, 24);
        add(cbBebida);

        JLabel l2 = new JLabel("Acompañamiento");
        l2.setFont(new Font("Tahoma", Font.BOLD, 11));
        l2.setBounds(28, 110, 120, 16);
        add(l2);

        cbAcompanamiento = new JComboBox<>(Acompanamiento.values());
        cbAcompanamiento.setBounds(160, 106, 200, 24);
        add(cbAcompanamiento);

        JLabel l3 = new JLabel("Extra");
        l3.setFont(new Font("Tahoma", Font.BOLD, 11));
        l3.setBounds(28, 150, 120, 16);
        add(l3);

        cbExtra = new JComboBox<>(Extra.values());
        cbExtra.setBounds(160, 146, 200, 24);
        add(cbExtra);

        JButton btnSave = new JButton("Agregar pedido");
        btnSave.setBounds(160, 196, 150, 26);
        add(btnSave);

        JButton btnClean = new JButton("Limpiar");
        btnClean.setBounds(320, 196, 120, 26);
        add(btnClean);

        btnSave.addActionListener(e -> {
            BaseCombo base = rHamb.isSelected() ? BaseCombo.HAMBURGUESA
                    : rChicken.isSelected() ? BaseCombo.POLLO
                            : BaseCombo.VEGETARIANO;
            controller.addCombo(base, (Bebida) cbBebida.getSelectedItem(),
                    (Acompanamiento) cbAcompanamiento.getSelectedItem(), (Extra) cbExtra.getSelectedItem());
        });

        btnClean.addActionListener(e -> {
            rHamb.setSelected(true);
            cbBebida.setSelectedIndex(0);
            cbAcompanamiento.setSelectedIndex(0);
            cbExtra.setSelectedIndex(0);
        });
    }

    @Override
    public void update(Model model, Object data) {
        if (data != null) JOptionPane.showMessageDialog(this, (String) data);
    }
}
