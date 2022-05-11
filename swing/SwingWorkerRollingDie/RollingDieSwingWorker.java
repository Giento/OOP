package hr.fer.oop.swing.SwingWorkerRollingDie;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class RollingDieSwingWorker extends JFrame {
    JLabel lbRollings = new JLabel("6000", JLabel.CENTER);
    JSlider slRollings = new JSlider(0, 1000000, 6000);

    final JTextField[] txOccurences;
    final JTextField[] txRelFrequency;

    JButton btStart = new JButton("Start");
    JButton btCalculate = new JButton("Calculate relative freq.");

    int total;
    int num = 0;

    public RollingDieSwingWorker() {
        super("Rolling Die - GUI not responsive");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500,200);

        JPanel pnSlider = new JPanel();
        pnSlider.setLayout(new BorderLayout());
        lbRollings.setBackground(Color.WHITE);
        lbRollings.setOpaque(true);
        slRollings.setMajorTickSpacing(200000);
        slRollings.setMinorTickSpacing(100000);
        slRollings.setPaintTicks(true);
        slRollings.setPaintLabels(true);
        lbRollings.setText(String.valueOf(slRollings.getValue()));
        pnSlider.add(lbRollings, BorderLayout.NORTH);
        pnSlider.add(slRollings, BorderLayout.SOUTH);
        add(pnSlider, BorderLayout.NORTH);

        JPanel pnResults = new JPanel();
        pnResults.setLayout(new GridLayout(6, 0, 3, 3));
        txOccurences = makeTextFields();
        txRelFrequency = makeTextFields();
        for(int i = 0; i < txOccurences.length; i++) {
            pnResults.add(txOccurences[i]);
            pnResults.add(txRelFrequency[i]);
        }
        add(pnResults, BorderLayout.CENTER);

        JPanel pnButtons = new JPanel();
        pnButtons.add(btStart);
        pnButtons.add(btCalculate);
        add(pnButtons, BorderLayout.SOUTH);

        pack();

        slRollings.addChangeListener((e) -> lbRollings.setText(String.valueOf(slRollings.getValue())));

        btStart.addActionListener((e) -> {
                btStart.setEnabled(false);
                slRollings.setEnabled(false);
                for (int i = 0; i < 6; i++) {
                    txOccurences[i].setText("0");
                    txRelFrequency[i].setText("0");
                }
                new RollingTask(Integer.valueOf(lbRollings.getText())).execute();
        });

        btCalculate.addActionListener((e) -> {
            if (total == 0)
                return;
            for (int i = 0; i < 6; i++) {
                txRelFrequency[i].setText(String.format("%6.4f",
                        Double.valueOf(txOccurences[i].getText()) /
                                Double.valueOf(lbRollings.getText())));
            }
        });
    }

    private JTextField[] makeTextFields() {
        JTextField[] textField = new JTextField[6];
        for(int i = 0; i < 6; i++) {
            JTextField t = new JTextField();  // jedino tu razlika
            t.setEditable(false);
            t.setHorizontalAlignment(JTextField.RIGHT);
            t.setText("0");
            textField[i] = t;
        }
        return textField;
    }



    class RollingTask extends SwingWorker<Void, Integer[]> {
        private int noOfRolling;

        public RollingTask(int noOfRolling) {
            this.noOfRolling = noOfRolling;
        }


        @Override
        protected Void doInBackground() {
            total = 0;
            Integer[] occurences = {0,0,0,0,0,0};
            Random random = new Random();
            System.out.println("Intensive task is running on EDT? " + SwingUtilities.isEventDispatchThread());
            System.out.println("Where is it running? " + Thread.currentThread());
            while(total < noOfRolling) {
                total++;
                num = random.nextInt(6);
                //int cnt = Integer.valueOf(txOccurences[num].getText()) + 1;
                //txOccurences[num].setText(String.valueOf(cnt));
                occurences[num]++;
                publish(occurences);
            }
            return null;
        }

        @Override
        protected void process(List<Integer[]> progress) {
            Integer[] lastOccurence = progress.get(progress.size() - 1);
            for (int i = 0; i < 6; i++)
                txOccurences[i].setText(String.valueOf(lastOccurence[i]));
        }

        @Override
        protected void done() {
            btStart.setEnabled(true);
            slRollings.setEnabled(true);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RollingDieSwingWorker().setVisible(true);
            }
        });
    }
}
