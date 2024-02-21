import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GeneratePasswordWindow extends JFrame {

    Boolean includeUpper, includeLower, includeNumbers, includeSymbols;
    String yes1, yes2, yes3, yes4;
    String no1, no2, no3, no4;
    JLabel labelQ1, labelQ2, labelQ3, labelQ4, labelQ5;
    JSlider passLength;
    GeneratePasswordWindow(){
        this.setTitle("Password generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(400, 400);
        ImageIcon imageIcon = new ImageIcon("I:\\Idea Projects\\PasswordGenerator\\assets\\logo.png");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLayout(null);


        labelQ1 = new JLabel("Do you want Uppercase letters to be used?");
        labelQ1.setBounds(10, 5, 300,30);
        labelQ1.setForeground(Color.WHITE);

        labelQ2 = new JLabel("Do you want Lowercase letters to be used?");
        labelQ2.setBounds(10, 70, 300,30);
        labelQ2.setForeground(Color.WHITE);

        labelQ3 = new JLabel("Do you want Numbers to be used?");
        labelQ3.setBounds(10, 135, 300,30);
        labelQ3.setForeground(Color.WHITE);

        labelQ4 = new JLabel("Do you want Symbols to be used?");
        labelQ4.setBounds(10, 200, 300,30);
        labelQ4.setForeground(Color.WHITE);

        labelQ5 = new JLabel("Length of the password.");
        labelQ5.setBounds(10, 265, 300,30);
        labelQ5.setForeground(Color.WHITE);

        JRadioButton radioButtonYes1 = new JRadioButton("yes");
        radioButtonYes1.setBounds(10, 40, 50, 20);
        radioButtonYes1.setFocusable(false);

        JRadioButton radioButtonNo1 = new JRadioButton("no");
        radioButtonNo1.setBounds(70, 40, 50, 20);
        radioButtonNo1.setFocusable(false);

        JRadioButton radioButtonYes2 = new JRadioButton("yes");
        radioButtonYes2.setBounds(10, 105, 50, 20);
        radioButtonYes2.setFocusable(false);

        JRadioButton radioButtonNo2 = new JRadioButton("no");
        radioButtonNo2.setBounds(70, 105, 50, 20);
        radioButtonNo2.setFocusable(false);

        JRadioButton radioButtonYes3 = new JRadioButton("yes");
        radioButtonYes3.setBounds(10, 170, 50, 20);
        radioButtonYes3.setFocusable(false);

        JRadioButton radioButtonNo3 = new JRadioButton("no");
        radioButtonNo3.setBounds(70, 170, 50, 20);
        radioButtonNo3.setFocusable(false);

        JRadioButton radioButtonYes4 = new JRadioButton("yes");
        radioButtonYes4.setBounds(10, 235, 50, 20);
        radioButtonYes4.setFocusable(false);

        JRadioButton radioButtonNo4 = new JRadioButton("no");
        radioButtonNo4.setBounds(70, 235, 50, 20);
        radioButtonNo4.setFocusable(false);

        JButton submitButton = new JButton("Submit.");
        submitButton.setBackground(Color.GREEN);
        submitButton.setFocusable(false);
        submitButton.setForeground(Color.BLACK);
        submitButton.setBounds(250, 310, 100, 40);


        passLength = new JSlider(0, 40, 8);
        passLength.setPaintTicks(true);
        passLength.setMinorTickSpacing(4);
        passLength.setPaintTrack(true);
        passLength.setMajorTickSpacing(8);
        passLength.setPaintLabels(true);
        JPanel passLengthPanel = new JPanel();
        passLengthPanel.setBounds(10, 300, 200, 50);
        passLengthPanel.add(passLength);

        radioButtonYes1.addActionListener(e -> {
            includeUpper = true;
        });
        radioButtonNo1.addActionListener(e -> {
            includeUpper = false;
        });

        radioButtonYes2.addActionListener(e -> {
            includeLower = true;
        });
        radioButtonNo2.addActionListener(e -> {
            includeLower = false;
        });

        radioButtonYes3.addActionListener(e -> {
            includeNumbers = true;
        });
        radioButtonNo3.addActionListener(e -> {
            includeNumbers = false;
        });

        radioButtonYes4.addActionListener(e -> {
            includeSymbols = true;
        });
        radioButtonNo4.addActionListener(e -> {
            includeSymbols = false;
        });

        submitButton.addActionListener(e -> {
            Generator generator = new Generator(includeUpper, includeLower, includeNumbers, includeSymbols);
            Password password = generator.requestPassword(passLength.getValue());

            JFrame passwordFrame = new JFrame("Password generator");
            passwordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            passwordFrame.setSize(400,200);
            passwordFrame.setResizable(false);
            passwordFrame.setIconImage(imageIcon.getImage());
            passwordFrame.getContentPane().setBackground(Color.DARK_GRAY);
            passwordFrame.setLayout(null);
            JTextField textField = new JTextField();
            textField.setText(password.toString());
            textField.setEditable(false);
            textField.setForeground(Color.BLACK);
            textField.setBounds(25, 50, 330, 30);
            JButton button = new JButton("Copy");
            button.setFocusable(false);
            button.setBounds(160, 100, 80, 40);
            button.addActionListener(e1 -> {
                textField.selectAll();
                textField.copy();

            });
            passwordFrame.add(button);
            passwordFrame.add(textField);
            passwordFrame.setVisible(true);
        });


        ButtonGroup group1 = new ButtonGroup();
        group1.add(radioButtonYes1);
        group1.add(radioButtonNo1);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(radioButtonYes2);
        group2.add(radioButtonNo2);
        ButtonGroup group3 = new ButtonGroup();
        group3.add(radioButtonYes3);
        group3.add(radioButtonNo3);
        ButtonGroup group4 = new ButtonGroup();
        group4.add(radioButtonYes4);
        group4.add(radioButtonNo4);

        this.add(labelQ1);
        this.add(labelQ2);
        this.add(labelQ3);
        this.add(labelQ4);
        this.add(labelQ5);
        this.add(radioButtonYes1);
        this.add(radioButtonNo1);
        this.add(radioButtonYes2);
        this.add(radioButtonNo2);
        this.add(radioButtonYes3);
        this.add(radioButtonNo3);
        this.add(radioButtonYes4);
        this.add(radioButtonNo4);
        this.add(passLengthPanel);
        this.add(submitButton);

        this.setVisible(true);


    }
}
