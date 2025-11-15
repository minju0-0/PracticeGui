package PizzaOrderSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaOrderSystem extends JFrame{
    private JPanel contentPane;
    private JComboBox pizzaSizeChoice;
    private JComboBox pizzaToppingsChoice;
    private JComboBox extraCheeseChoice;
    private JButton calculateButton;
    private JLabel totalLabel;

    public PizzaOrderSystem() {
        setTitle("Pizza Order System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    public void calculateTotal(){
        String sizeChoice = (String) pizzaSizeChoice.getSelectedItem();
        String toppingsChoice = (String) pizzaToppingsChoice.getSelectedItem();
        String extraCheese = (String) extraCheeseChoice.getSelectedItem();

        int total = 0;

        switch(sizeChoice){
            case "Small" -> total += 10;
            case "Medium" -> total += 15;
            case "Large" -> total += 20;
        }
        if(toppingsChoice != null) total += 2;
        if("Yes".equals(extraCheese)) total += 3;

        totalLabel.setText(String.valueOf(total));

    }

    public static void main(String[] args) {
        new PizzaOrderSystem();
    }
}
