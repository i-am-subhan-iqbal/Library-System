import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;
import java.awt.event.ActionEvent;
public class librarySystem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel ContentPane;
	private JTextField stdName;
	private JTextField stdRoll;
	private JTextField issueDate;
	private JTextField returnDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					librarySystem frame = new librarySystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
		 
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
		BookSelect.setModel(new DefaultComboBoxModel(new String[] {"Select Book", "Java", "C++", "React", "Computer Science", "English"}));
		BookSelect.setBounds(173, 168, 114, 26);
		ContentPane.add(BookSelect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(51, 411, 105, 27);
		ContentPane.add(btnExit);
		
		JRadioButton newEdition = new JRadioButton("New Edition");
		newEdition.setBounds(173, 213, 101, 25);
		ContentPane.add(newEdition);
		
		stdName = new JTextField();
		stdName.setBounds(173, 87, 114, 21);
		ContentPane.add(stdName);
		stdName.setColumns(10);
		
		JTextArea remarks = new JTextArea();
		remarks.setBounds(147, 334, 175, 52);
		ContentPane.add(remarks);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setBounds(28, 334, 101, 30);
		ContentPane.add(lblRemarks);
		
		JLabel Heading = new JLabel("Library Management GUI");
		Heading.setFont(new Font("Nimbus Mono PS", Font.BOLD, 16));
		Heading.setBounds(99, 30, 236, 40);
		ContentPane.add(Heading);
		
		stdRoll = new JTextField();
		stdRoll.setColumns(10);
		stdRoll.setBounds(173, 129, 114, 21);
		ContentPane.add(stdRoll);
		
		issueDate = new JTextField();
		issueDate.setColumns(10);
		issueDate.setBounds(173, 255, 114, 21);
		ContentPane.add(issueDate);
		
		returnDate = new JTextField();
		returnDate.setColumns(10);
		returnDate.setBounds(173, 297, 114, 21);
		ContentPane.add(returnDate);
		
		JRadioButton oldEdition = new JRadioButton("Old Edition");
		oldEdition.setBounds(292, 211, 101, 25);
		ContentPane.add(oldEdition);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(169, 411, 105, 27);
		ContentPane.add(btnReset);
		
		JButton btnSubmit = new JButton("Submit ");
		btnSubmit.setBounds(292, 411, 105, 27);
		ContentPane.add(btnSubmit);
		
		// action listener for exit button...
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		// for reset button..,.
		btnReset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				stdName.setText("");
				stdRoll.setText("");
				issueDate.setText("");
				returnDate.setText("");
				
				remarks.setText("");
				BookSelect.setSelectedIndex(0);
				newEdition.setSelected(false);
				oldEdition.setSelected(false);				
			}
		});
		
		// action listener for submit btn...,.
		// also making all fields required
		btnSubmit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {

        try {

            // THROW EXCEPTION IF EMPTY
            if (stdName.getText().trim().isEmpty() ||
                stdRoll.getText().trim().isEmpty() ||
                issueDate.getText().trim().isEmpty() ||
                returnDate.getText().trim().isEmpty()) {

                throw new EmptyFieldException("Fields cannot be empty!");
            }

            // NUMBER CHECK
            int roll = Integer.parseInt(stdRoll.getText().trim());

            // BOOK CHECK
            if (BookSelect.getSelectedIndex() == 0) {
                throw new Exception("Select a book!");
            }

            // DATE CHECK (simple logic)
            if (returnDate.getText().compareTo(issueDate.getText()) < 0) {
                throw new Exception("Return date invalid!");
            }

            JOptionPane.showMessageDialog(null, "Book Submitted Successfully!");

        }

        catch (EmptyFieldException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Roll number must be numeric!");
        }

        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        finally {
            JOptionPane.showMessageDialog(null, "Operation Completed");
        }
    }
});
		
		

		
	}
}
