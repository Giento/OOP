package hr.fer.oop.swing.LayoutDemo;

import javax.swing.*;
import java.awt.*;

public class PanelWithLayout2 extends JPanel {
    JButton [] buttons = new JButton[5];

    public PanelWithLayout2() {
        setLayout(new FlowLayout()); //default layout for JPanel
        //setLayout(new FlowLayout(FlowLayout.LEFT));
        for(int i = 0; i < buttons.length; i++) {
            add(i%2 == 0 ?
                    add(buttons[i] = new JButton("Button" + (i+1))) :
                    add(buttons[i] = new JButton("Button" + (i+1) + " is very very long")));
        }
    }
}
