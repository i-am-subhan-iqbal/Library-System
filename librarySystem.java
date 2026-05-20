import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;


class EmptyFieldException extends Exception {
    public EmptyFieldException(String msg) {
        super(msg);
    }
}

class InvalidRollNumberException extends Exception {
    public InvalidRollNumberException(String msg) {
        super(msg);
    }
}

class InvalidDateException extends Exception {
    public InvalidDateException(String msg) {
        super(msg);
    }
}

class NullSelectionException extends Exception {
    public NullSelectionException(String msg) {
        super(msg);
    }
}


public class librarySystem extends JFrame {

    private JPanel ContentPane;
    private JTextField stdName;
    private JTextField stdRoll;
    private JTextField issueDate;
    private JTextField returnDate;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                librarySystem frame = new librarySystem();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public librarySystem() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 600, 500, 500);

        ContentPane = new JPanel();
        ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(ContentPane);
        ContentPane.setLayout(null);

        JLabel lblStudentName = new JLabel("Student Name:");
        lblStudentName.setBounds(28, 82, 101, 30);
        ContentPane.add(lblStudentName);

        JLabel lblRollNumber = new JLabel("Roll number:");
        lblRollNumber.setBounds(28, 124, 101, 30);
        ContentPane.add(lblRollNumber);

        JLabel lblBookTitle = new JLabel("Book Title:");
        lblBookTitle.setBounds(28, 166, 101, 30);
        ContentPane.add(lblBookTitle);

        JLabel lblBookCategory = new JLabel("Book Category:");
        lblBookCategory.setBounds(28, 208, 101, 30);
        ContentPane.add(lblBookCategory);

        JLabel lblIssueDate = new JLabel("Issue Date:");
        lblIssueDate.setBounds(28, 250, 101, 30);
        ContentPane.add(lblIssueDate);

        JLabel lblReturnDate = new JLabel("Return Date:");
        lblReturnDate.setBounds(28, 292, 101, 30);
        ContentPane.add(lblReturnDate);

        JComboBox BookSelect = new JComboBox();
        BookSelect.setModel(new DefaultComboBoxModel(
                new String[]{"Select Book", "Java", "C++", "React", "Computer Science", "English"}));
        BookSelect.setBounds(173, 168, 114, 26);
        ContentPane.add(BookSelect);

        JRadioButton newEdition = new JRadioButton("New Edition");
        newEdition.setBounds(173, 213, 101, 25);
        ContentPane.add(newEdition);

        JRadioButton oldEdition = new JRadioButton("Old Edition");
        oldEdition.setBounds(292, 211, 101, 25);
        ContentPane.add(oldEdition);

        ButtonGroup bg = new ButtonGroup();
        bg.add(newEdition);
        bg.add(oldEdition);

        stdName = new JTextField();
        stdName.setBounds(173, 87, 114, 21);
        ContentPane.add(stdName);

        stdRoll = new JTextField();
        stdRoll.setBounds(173, 129, 114, 21);
        ContentPane.add(stdRoll);

        issueDate = new JTextField();
        issueDate.setBounds(173, 255, 114, 21);
        ContentPane.add(issueDate);

        returnDate = new JTextField();
        returnDate.setBounds(173, 297, 114, 21);
        ContentPane.add(returnDate);

        JTextArea remarks = new JTextArea();
        remarks.setBounds(147, 334, 175, 52);
        ContentPane.add(remarks);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(51, 411, 105, 27);
        ContentPane.add(btnExit);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(169, 411, 105, 27);
        ContentPane.add(btnReset);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(292, 411, 105, 27);
        ContentPane.add(btnSubmit);

                btnExit.addActionListener(e -> System.exit(0));

                btnReset.addActionListener(e -> {
            stdName.setText("");
            stdRoll.setText("");
            issueDate.setText("");
            returnDate.setText("");
            remarks.setText("");
            BookSelect.setSelectedIndex(0);
            bg.clearSelection();
        });

                btnSubmit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        boolean success = false;

                        try {

                            if (stdName.getText().trim().isEmpty() ||
                                stdRoll.getText().trim().isEmpty() ||
                                issueDate.getText().trim().isEmpty() ||
                                returnDate.getText().trim().isEmpty()) {

                                throw new EmptyFieldException("All fields are required!");
                            }

                            if (!stdRoll.getText().trim().matches("\\d+")) {
                                throw new InvalidRollNumberException("Roll number must be numeric only!");
                            }
                            if (BookSelect.getSelectedIndex() == 0) {
                                throw new NullSelectionException("Please select a book!");
                            }

                             String pattern = "\\d{2}-\\d{2}-\\d{4}";

                            if (!issueDate.getText().matches(pattern) ||
                                !returnDate.getText().matches(pattern)) {

                                throw new InvalidDateException("Use date format DD-MM-YYYY only!");
                            }

                              if (returnDate.getText().compareTo(issueDate.getText()) < 0) {
                                throw new InvalidDateException("Return date cannot be before issue date!");
                            }
                            success = true;
                            JOptionPane.showMessageDialog(null, "Book Submitted Successfully!");
                        }
                        catch (EmptyFieldException | InvalidRollNumberException |
                               NullSelectionException | InvalidDateException ex) {

                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }

                        catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Unexpected error: " + ex.getMessage());
                        }

                        finally {
                            if (success) {
                                JOptionPane.showMessageDialog(null, "Operation Completed");
                            }
                        }
                    }
                });
    }
}