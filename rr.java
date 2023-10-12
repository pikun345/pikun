import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class TransactionHistory {
    private static List<String> transactions = new ArrayList<>();

    public static void show() {
        if (transactions.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Transaction History is empty.");
        } else {
            StringBuilder history = new StringBuilder("Transaction History:\n");
            for (String transaction : transactions) {
                history.append(" - ").append(transaction).append("\n");
            }
            JOptionPane.showMessageDialog(null, history.toString());
        }
    }

    public static void addTransaction(String transaction) {
        transactions.add(transaction);
    }
}

class Deposit {
    public static void perform() {
        String input = JOptionPane.showInputDialog("Enter the amount to deposit:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > 0) {
                TransactionHistory.addTransaction("Deposit: Rs." + amount);
                JOptionPane.showMessageDialog(null, "Deposited Rs." + amount);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive value.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }
}

class Withdraw {
    public static void perform() {
        String input = JOptionPane.showInputDialog("Enter the amount to withdraw:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > 0) {
                TransactionHistory.addTransaction("Withdraw: Rs." + amount);
                JOptionPane.showMessageDialog(null, "Withdrawn Rs." + amount);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive value.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }
}

class Transfer {
    public static void perform() {
        String input = JOptionPane.showInputDialog("Enter the amount to transfer:");
        try {
            double amount = Double.parseDouble(input);
            if (amount > 0) {
                TransactionHistory.addTransaction("Transfer: Rs." + amount);
                JOptionPane.showMessageDialog(null, "Transferred Rs." + amount);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive value.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
        }
    }
}

class Quit {
    public static void perform() {
        JOptionPane.showMessageDialog(null, "Mr. ATM is here to help you...");
        System.exit(0);
    }
}

 class ATMSwingApp {
    private static JFrame frame;
    private static JLabel balanceLabel;
    private static double balance = 1000.0;

    public static void main(String[] args) {
        frame = new JFrame("ATM Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        balanceLabel = new JLabel("Current Balance: Rs." + balance);
        frame.add(balanceLabel, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(0, 1)); 

        JButton transactionHistoryButton = new JButton("Transaction History");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");
        JButton quitButton = new JButton("Quit");

        transactionHistoryButton.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                TransactionHistory.show();
            }
        });

        depositButton.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                Deposit.perform();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                Withdraw.perform();
            }
        });

        transferButton.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                Transfer.perform();
            }
        });

        quitButton.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                Quit.perform();
            }
        });

        menuPanel.add(transactionHistoryButton);
        menuPanel.add(depositButton);
        menuPanel.add(withdrawButton);
        menuPanel.add(transferButton);
        menuPanel.add(quitButton);

        frame.add(menuPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}