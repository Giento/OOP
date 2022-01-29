package hr.fer.oop.swingZadaci.zad3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scoreboard extends JFrame {
    JButton reset = new JButton("Reset");
    JButton redBtn = new JButton("New point for red");
    JButton blueBtn = new JButton("New point for blue");
    JLabel redCnt = new JLabel("0", SwingConstants.CENTER);
    JLabel blueCnt = new JLabel("0", SwingConstants.CENTER);

    public Scoreboard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 200);
        setTitle("Scoreboard");
        blueCnt.setBackground(Color.BLUE);
        blueCnt.setFont(new Font("Verdana", Font.BOLD, 18));
        blueCnt.setOpaque(true);
        redCnt.setBackground(Color.RED);
        redCnt.setFont(new Font("Verdana", Font.BOLD, 18));
        redCnt.setOpaque(true);

        JPanel northPanel = new JPanel();
        northPanel.add(reset);
        add(northPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(1, 0, 5, 5));
        centerPanel.add(redCnt);
        centerPanel.add(blueCnt);
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);
        southPanel.add(redBtn);
        southPanel.add(blueBtn);

        reset.addActionListener((e) -> {
            redCnt.setText("0");
            blueCnt.setText("0");
        });

        Multilistener listener = new Multilistener();
        redBtn.addActionListener(listener);
        blueBtn.addActionListener(listener);
        pack();
    }


    class Multilistener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == redBtn) {
                redCnt.setText(String.valueOf(
                        Integer.parseInt(redCnt.getText()) + 1));
            }
            if(e.getSource() == blueBtn) {
                blueCnt.setText(String.valueOf(
                        Integer.parseInt(blueCnt.getText()) + 1));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Scoreboard frame = new Scoreboard();
            frame.setVisible(true);
        });
    }
}
