package SimpleCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame{
    private JPanel contentPane;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JLabel lblResult;
    private JLabel lbNumber1;
    private JLabel lbNumber2;
    private JComboBox cbOperations;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        lblResult.setBorder(BorderFactory.createEtchedBorder());

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lblResult.setText(String.valueOf(compute()));
            }
        });
    }

    public int compute(){
        int num1 = Integer.parseInt(tfNumber1.getText());
        int num2 = Integer.parseInt(tfNumber2.getText());
        String op = (String)cbOperations.getSelectedItem();

        int res = 0;
        switch(op){
            case "+" -> res = num1 + num2;
            case "-" -> res = num1 - num2;
            case "*" -> res = num1 * num2;
            case "/" -> res = num1 / num2;
        }

        return res;
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
