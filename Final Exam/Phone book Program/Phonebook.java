import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhonebookSystem extends JFrame implements ActionListener {
    private JTextField nameField, phoneField;
    private JTextArea contactArea;
    private JButton addButton, deleteButton, searchButton, updateButton, displayButton;
    private final File contactFile = new File("phonebook.txt");

    public PhonebookSystem() {
        // Initialize UI components
        setTitle("Phonebook System");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(230, 240, 255));

        // Input Panel
        JPanel inputPanel = createInputPanel();
        JPanel buttonPanel = createButtonPanel();
        JPanel textAreaPanel = createTextAreaPanel();

        // Add panels to the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(textAreaPanel, BorderLayout.SOUTH);

        add(mainPanel);
        loadContacts();
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        inputPanel.setBackground(new Color(200, 220, 240));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add or Search Contact"));

        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        JLabel nameLabel = new JLabel("Name:");
        JLabel phoneLabel = new JLabel("Phone:");

        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 14));

        phoneField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                if (!text.matches("\\d*")) {
                    JOptionPane.showMessageDialog(PhonebookSystem.this,
                            "Phone number must contain only digits!",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                return true;
            }
        });

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        return inputPanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        buttonPanel.setBackground(new Color(230, 240, 255));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        addButton = createStyledButton("Add");
        deleteButton = createStyledButton("Delete");
        searchButton = createStyledButton("Search");
        updateButton = createStyledButton("Update");
        displayButton = createStyledButton("Display");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayButton);

        return buttonPanel;
    }

    private JPanel createTextAreaPanel() {
        JPanel textAreaPanel = new JPanel(new BorderLayout());
        textAreaPanel.setBackground(new Color(200, 220, 240));
        textAreaPanel.setBorder(BorderFactory.createTitledBorder("Contacts"));

        contactArea = new JTextArea(12, 20);
        contactArea.setEditable(false);
        contactArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        contactArea.setBackground(new Color(240, 250, 255));
        contactArea.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JScrollPane scrollPane = new JScrollPane(contactArea);
        textAreaPanel.add(scrollPane, BorderLayout.CENTER);

        return textAreaPanel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(90, 30));
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(100, 150, 200));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        button.addActionListener(this);
        return button;
    }

    private void loadContacts() {
        contactArea.setText("");
        try (BufferedReader br = new BufferedReader(new FileReader(contactFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                contactArea.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading contacts: " + e.getMessage());
        }
    }

    private void saveContacts(List<String> contacts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(contactFile))) {
            for (String contact : contacts) {
                bw.write(contact);
                bw.newLine();
            }
            loadContacts();
        } catch (IOException e) {
            System.err.println("Error saving contacts: " + e.getMessage());
        }
    }

    private void addContact() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        if (name.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Phone cannot be empty!");
            return;
        }
        String contact = name + "," + phone;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(contactFile, true))) {
            bw.write(contact);
            bw.newLine();
            contactArea.append(contact + "\n");
            nameField.setText("");
            phoneField.setText("");
        } catch (IOException e) {
            System.err.println("Error saving contact: " + e.getMessage());
        }
    }

    private void deleteContact() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name to delete!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(contactFile))) {
            List<String> contacts = new ArrayList<>();
            boolean found = false;

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(name + ",")) {
                    found = true;
                } else {
                    contacts.add(line);
                }
            }

            if (found) {
                saveContacts(contacts);
                JOptionPane.showMessageDialog(this, "Contact deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found!");
            }
        } catch (IOException e) {
            System.err.println("Error deleting contact: " + e.getMessage());
        }
    }

    private void searchContact() {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name to search!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(contactFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(name + ",")) {
                    JOptionPane.showMessageDialog(this, "Contact Found: " + line);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Contact not found!");
        } catch (IOException e) {
            System.err.println("Error searching contact: " + e.getMessage());
        }
    }

    private void updateContact() {
        String name = nameField.getText().trim();
        String newPhone = phoneField.getText().trim();
        if (name.isEmpty() || newPhone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a name and new phone number to update!");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(contactFile))) {
            List<String> contacts = new ArrayList<>();
            boolean found = false;

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(name + ",")) {
                    contacts.add(name + "," + newPhone);
                    found = true;
                } else {
                    contacts.add(line);
                }
            }

            if (found) {
                saveContacts(contacts);
                JOptionPane.showMessageDialog(this, "Contact updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Contact not found!");
            }
        } catch (IOException e) {
            System.err.println("Error updating contact: " + e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addContact();
        } else if (e.getSource() == deleteButton) {
            deleteContact();
        } else if (e.getSource() == searchButton) {
            searchContact();
        } else if (e.getSource() == updateButton) {
            updateContact();
        } else if (e.getSource() == displayButton) {
            loadContacts();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PhonebookSystem().setVisible(true));
    }
          }
