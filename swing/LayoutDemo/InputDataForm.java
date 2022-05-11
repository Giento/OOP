package hr.fer.oop.swing.LayoutDemo;


import javax.swing.*;
import java.awt.GridLayout;

public class InputDataForm extends JPanel {
    JTextField name = new JTextField();
    JTextField address = new JTextField();
    JCheckBox vaccinated = new JCheckBox("vaccinated");

    public InputDataForm() {
        setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        setLayout(new GridLayout(3, 2, 5,5));

        add(new JLabel("Name:", SwingConstants.RIGHT));
        add(name);

        add(new JLabel());
        add(vaccinated);

        add(new JLabel("Address:", SwingConstants.RIGHT));
        add(address);
    }
}
