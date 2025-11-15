package CharRemover;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterRemover extends JFrame{
    private JPanel contentPane;
    private JCheckBox vowelCheckBox;
    private JCheckBox consonantCheckBox;
    private JCheckBox numberCheckBox;
    private JButton removeButton;
    private JButton restoreButton;
    private JLabel textLabel;

    public CharacterRemover(){
        setTitle("Character Remover");
        setContentPane(contentPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        final String text = textLabel.getText();
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String temp = text;

                if(vowelCheckBox.isSelected()) temp = temp.replaceAll("[AEIOU]", "");
                if(consonantCheckBox.isSelected()) temp = temp.replaceAll("[BCDFGHJKLMNPQRSTVWXYZ]", "");
                if(numberCheckBox.isSelected()) temp = temp.replaceAll("[0-9]", "");

                if(temp.isEmpty()) temp = "EMPTY";
                textLabel.setText(temp);
            }
        });

        restoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vowelCheckBox.setSelected(false);
                consonantCheckBox.setSelected(false);
                numberCheckBox.setSelected(false);
                textLabel.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        new CharacterRemover();
    }

}
