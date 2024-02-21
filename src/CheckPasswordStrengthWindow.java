import javax.swing.*;
import java.awt.*;

public class CheckPasswordStrengthWindow extends JFrame {
    CheckPasswordStrengthWindow() {
        this.setTitle("Password generator");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 200);
        ImageIcon imageIcon = new ImageIcon("I:\\Idea Projects\\PasswordGenerator\\assets\\logo.png");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        JTextField textField = new JTextField();
        textField.setEditable(true);
        textField.setForeground(Color.BLACK);
        textField.setBounds(25, 50, 330, 30);
        JButton button = new JButton("Score!");
        button.setFocusable(false);
        button.setBounds(150, 100, 80, 40);
        button.addActionListener(e -> {
            String score = new Generator().checkPassword(textField.getText());
            JFrame frame = new JFrame();
            frame.setIconImage(imageIcon.getImage());
            frame.setBackground(Color.DARK_GRAY);
            frame.setSize(100, 100);
            frame.setLocationRelativeTo(null);
            JTextField textField1 = new JTextField();
            textField1.setText(score);
            textField1.setEditable(false);
            textField1.setBackground(Color.DARK_GRAY);
            textField1.setForeground(Color.WHITE);
            Font font= new Font("Courier", Font.PLAIN, 20);
            textField1.setFont(font);
            textField1.setHorizontalAlignment(JTextField.CENTER);
            textField1.setBounds(50,50, 80, 100);
            frame.add(textField1);

            frame.setVisible(true);
        });

        this.add(button);
        this.add(textField);
        this.setVisible(true);
    }
}
