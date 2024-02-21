import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{

    JButton buttonGenerate;
    JButton buttonPasswordStrength;
    JButton buttonQuit;
    JPanel panel1, panel2;
    MyFrame() {
        this.setTitle("Password generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 400);
        ImageIcon imageIcon = new ImageIcon("I:\\Idea Projects\\PasswordGenerator\\assets\\logo.png");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);

        buttonGenerate = new JButton("Generate password");
        buttonGenerate.setBounds(120, 170, 150, 50);
        buttonGenerate.setFocusable(false);
        buttonGenerate.addActionListener(e -> {
            new GeneratePasswordWindow();
            this.dispose();
        });




        buttonPasswordStrength = new JButton("Check password");
        buttonPasswordStrength.setBounds(120, 230, 150, 50);
        buttonPasswordStrength.setFocusable(false);
        buttonPasswordStrength.addActionListener(e -> {
            CheckPasswordStrengthWindow window = new CheckPasswordStrengthWindow();
            this.dispose();
        });



        this.add(buttonGenerate);
        this.add(buttonPasswordStrength);




        this.setVisible(true);
    }


}
