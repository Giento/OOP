package hr.fer.oop.swing.LayoutDemo;

import javax.swing.*;
import java.awt.*;

public class PanelWithLayout3 extends JPanel {
    JButton b1 = new JButton("Button1");
    JButton b2 = new JButton("Button2 is very very long?");
    JButton b3 = new JButton("Button3");
    JButton b4 = new JButton("Button4");
    JButton b5 = new JButton("Button5");

    public PanelWithLayout3() {
        setLayout(new GridLayout(3, 0, 5, 5));
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);

    }
}
