package CharacterCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCounter extends JFrame{
    private JPanel contentPane;
    private JTextArea messageTextArea;
    private JTextField characterTextField;
    private JButton countButton;
    private JLabel counter;
    private JLabel count;

    public CharacterCounter(){
        setTitle("Character Counter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);


        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numOfOccurence = countChar();
                count.setText(String.valueOf(numOfOccurence));
            }
        });
    }

    public int countChar(){
        int ctr = 0;
        String text = messageTextArea.getText();
        char target = characterTextField.getText().charAt(0);

        for(char c : text.toCharArray()){
            if(c == target) ctr++;
        }

        return ctr;
    }

    public static void main(String[] args) {
        new CharacterCounter();
    }



}
