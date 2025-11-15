package NumberCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberCounter extends JFrame{
    private JPanel contentPane;
    private JButton decreaseButton;
    private JButton increaseButton;
    private JLabel countLabel;
    public int count = 0;

    public NumberCounter(){
        setTitle("Number Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count > 0){
                    count--;
                }
                countLabel.setText(String.valueOf(count));
            }
        });

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                countLabel.setText(String.valueOf(count));
            }
        });
    }

    public static void main(String[] args) {
        new NumberCounter();
    }


}
