package LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame{
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JButton loginButton;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel messageLabel;
    private final String account = "admin";

    public LoginForm(){
        setTitle("Login Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        messageLabel = new JLabel();

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText((checkAccount())? "Login Successful!" : "Login Failed!");

                JOptionPane.showMessageDialog(
                        null, messageLabel, "Status",
                        JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public boolean checkAccount(){
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        return username.equals(account) && password.equals(account);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
