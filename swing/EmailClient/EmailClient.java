package hr.fer.oop.swing.EmailClient;

import javax.swing.*;
import java.awt.*;

public class EmailClient extends JFrame {
    JTextField from = new JTextField();
    JTextField to = new JTextField();
    JTextField subject = new JTextField();
    JTextField msg = new JTextField();
    JButton email = new JButton("Send e-mail");
    JButton clearMsg = new JButton("Clear Message");


    public EmailClient() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        setTitle("E-mail Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200,200,400,480);
        setLayout(new BorderLayout());

        JPanel panel = (JPanel) getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(3, 1));
        labelPanel.add(new JLabel("From: ", JLabel.RIGHT));
        labelPanel.add(new JLabel("To: ", JLabel.RIGHT));
        labelPanel.add(new JLabel("Subject: ", JLabel.RIGHT));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3, 1, 3, 3));
        textPanel.add(from);
        textPanel.add(to);
        textPanel.add(subject);

        northPanel.add(labelPanel, BorderLayout.WEST);
        northPanel.add(textPanel, BorderLayout.CENTER);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messagePanel.add(new JLabel("Message:"), BorderLayout.NORTH);
        messagePanel.add(msg, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(email);
        buttonsPanel.add(clearMsg);

        panel.add(northPanel, BorderLayout.NORTH);
        panel.add(messagePanel, BorderLayout.CENTER);
        panel.add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
