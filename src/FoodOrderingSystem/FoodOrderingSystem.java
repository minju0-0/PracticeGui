package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class FoodOrderingSystem extends JFrame{
    private JPanel contentPane;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JLabel foodLabel;
    private JButton btnOrder;
    private ButtonGroup discounts;
    private List<JCheckBox> foods;

    public FoodOrderingSystem() {
        setTitle("Food Ordering System");
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        discounts = new ButtonGroup();
        discounts.add(rbNone);
        discounts.add(rb5);
        discounts.add(rb10);
        discounts.add(rb15);

        foods = new ArrayList<>(Arrays.asList(
                cPizza, cBurger, cFries,
                cSoftDrinks, cTea, cSundae));


        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = calcPrice() * (1 - getDiscount());

                String message = String.format("                The total price is Php %.2f", total);
                JOptionPane.showMessageDialog(null, message, "Total Price", JOptionPane.PLAIN_MESSAGE);
//                int result = JOptionPane.showConfirmDialog(
//                        null, message, "Total Price",
//                        JOptionPane.YES_NO_OPTION);
//
//                if(result == JOptionPane.YES_OPTION) {
//                    JOptionPane.showMessageDialog(null, "Payment Successful", "Confirmed", JOptionPane.PLAIN_MESSAGE);
//                }else{
//                    JOptionPane.showMessageDialog(null, "Order Cancelled", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
//                }
            }
        });
    }

    public double calcPrice(){
        double total = 0;
        for(JCheckBox food : foods){
            if(food.isSelected()){
                String foodName = food.getName();
                switch(foodName){
                    case "Pizza" -> total += 100;
                    case "Burger" -> total += 80;
                    case "Fries" -> total += 65;
                    case "SoftDrinks" -> total += 55;
                    case "Tea" -> total += 50;
                    case "Sundae" -> total += 40;
                }
            }
        }
        return total;
    }

    public double getDiscount(){
        Enumeration<AbstractButton> disc = discounts.getElements();
        while(disc.hasMoreElements()){
            AbstractButton curr = disc.nextElement();
            if(curr.isSelected()){
                String amount = curr.getActionCommand();
                return Double.parseDouble(amount) / 100;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new FoodOrderingSystem();
    }
}
