import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String num1 = "", num2 = "", operator = "";

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        display.setPreferredSize(new Dimension(400, 80)); 
        display.setHorizontalAlignment(SwingConstants.RIGHT); 
        display.setBackground(new Color(40, 40, 40));  
        display.setForeground(Color.WHITE);  
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        buttonPanel.setBackground(new Color(40, 40, 40)); 

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(new Color(60, 60, 60)); 
            button.setForeground(Color.WHITE);  
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789".contains(command)) {
            display.setText(display.getText() + command);
        } else if ("/*-+".contains(command)) {
            num1 = display.getText();
            operator = command;
            display.setText("");
        } else if ("=".equals(command)) {
            num2 = display.getText();
            try {
                double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
                display.setText(String.valueOf(result));
                saveToHistory(num1, operator, num2, result);
            } catch (Exception ex) {
                display.setText("Error");
            }
        } else if ("C".equals(command)) {
            display.setText("");
            num1 = num2 = operator = "";
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Cannot divide by zero");
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    private void saveToHistory(String num1, String operator, String num2, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("calculator_history.txt", true))) {
            writer.write(num1 + " " + operator + " " + num2 + " = " + result + "\n");
        } catch (IOException e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
