import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class loginframe extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;

	private JPasswordField passwordField;

	private JTextArea txtAddress;

	private JComboBox<String> comboDepartment;

	private JCheckBox chkJava;
	private JCheckBox chkPython;
	private JCheckBox chkWeb;
	private JCheckBox chkMobile;
	private JCheckBox chkTerms;

	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOther;

	private JRadioButton rdbtnBeginner;
	private JRadioButton rdbtnIntermediate;
	private JRadioButton rdbtnAdvanced;

	private ButtonGroup genderGroup;
	private ButtonGroup experienceGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					loginframe frame = new loginframe();
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		});
	}

	
	public loginframe() {

		setTitle("Student Registration Form");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 750, 780);

		setLocationRelativeTo(null);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);


		JLabel lblTitle = new JLabel("Student Registration Form");

		lblTitle.setFont(new Font("Arial", Font.BOLD, 28));

		lblTitle.setBounds(170, 20, 400, 40);

		contentPane.add(lblTitle);
		

		JLabel lblName = new JLabel("Name:");

		lblName.setBounds(60, 100, 100, 30);

		contentPane.add(lblName);

		txtName = new JTextField();

		txtName.setBounds(220, 100, 220, 30);

		contentPane.add(txtName);

		JLabel lblEmail = new JLabel("Email:");

		lblEmail.setBounds(60, 150, 100, 30);

		contentPane.add(lblEmail);

		txtEmail = new JTextField();

		txtEmail.setBounds(220, 150, 220, 30);

		contentPane.add(txtEmail);


		JLabel lblPassword = new JLabel("Password:");

		lblPassword.setBounds(60, 200, 100, 30);

		contentPane.add(lblPassword);

		passwordField = new JPasswordField();

		passwordField.setBounds(220, 200, 220, 30);

		contentPane.add(passwordField);


		JLabel lblPhone = new JLabel("Phone:");

		lblPhone.setBounds(60, 250, 100, 30);

		contentPane.add(lblPhone);

		txtPhone = new JTextField();

		txtPhone.setBounds(220, 250, 220, 30);

		contentPane.add(txtPhone);


		JLabel lblAddress = new JLabel("Address:");

		lblAddress.setBounds(60, 310, 100, 30);

		contentPane.add(lblAddress);

		txtAddress = new JTextArea();

		txtAddress.setBounds(220, 300, 220, 80);

		contentPane.add(txtAddress);


		JLabel lblGender = new JLabel("Gender:");

		lblGender.setBounds(60, 420, 100, 30);

		contentPane.add(lblGender);

		rdbtnMale = new JRadioButton("Male");

		rdbtnMale.setBounds(220, 420, 80, 30);

		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");

		rdbtnFemale.setBounds(320, 420, 100, 30);

		contentPane.add(rdbtnFemale);

		rdbtnOther = new JRadioButton("Other");

		rdbtnOther.setBounds(430, 420, 100, 30);

		contentPane.add(rdbtnOther);

		genderGroup = new ButtonGroup();

		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		genderGroup.add(rdbtnOther);


		JLabel lblDepartment = new JLabel("Department:");

		lblDepartment.setBounds(60, 480, 100, 30);

		contentPane.add(lblDepartment);

		String departments[] = {
				"Select Department",
				"Computer Science",
				"Software Engineering",
				"Information Technology"
		};

		comboDepartment = new JComboBox<>(departments);

		comboDepartment.setBounds(220, 480, 220, 30);

		contentPane.add(comboDepartment);


		JLabel lblSkills = new JLabel("Skills:");

		lblSkills.setBounds(60, 540, 100, 30);

		contentPane.add(lblSkills);

		chkJava = new JCheckBox("Java");

		chkJava.setBounds(220, 540, 80, 30);

		contentPane.add(chkJava);

		chkPython = new JCheckBox("Python");

		chkPython.setBounds(320, 540, 100, 30);

		contentPane.add(chkPython);

		chkWeb = new JCheckBox("Web");

		chkWeb.setBounds(430, 540, 80, 30);

		contentPane.add(chkWeb);

		chkMobile = new JCheckBox("Mobile");

		chkMobile.setBounds(520, 540, 100, 30);

		contentPane.add(chkMobile);


		JLabel lblExperience = new JLabel("Experience:");

		lblExperience.setBounds(60, 590, 100, 30);

		contentPane.add(lblExperience);

		rdbtnBeginner = new JRadioButton("Beginner");

		rdbtnBeginner.setBounds(220, 590, 100, 30);

		contentPane.add(rdbtnBeginner);

		rdbtnIntermediate = new JRadioButton("Intermediate");

		rdbtnIntermediate.setBounds(340, 590, 120, 30);

		contentPane.add(rdbtnIntermediate);

		rdbtnAdvanced = new JRadioButton("Advanced");

		rdbtnAdvanced.setBounds(490, 590, 100, 30);

		contentPane.add(rdbtnAdvanced);

		experienceGroup = new ButtonGroup();

		experienceGroup.add(rdbtnBeginner);
		experienceGroup.add(rdbtnIntermediate);
		experienceGroup.add(rdbtnAdvanced);


		chkTerms = new JCheckBox("I agree to Terms & Conditions");

		chkTerms.setBounds(220, 640, 250, 30);

		contentPane.add(chkTerms);


		JButton btnSubmit = new JButton("Submit");

		btnSubmit.setBounds(120, 690, 120, 35);

		contentPane.add(btnSubmit);

		JButton btnReset = new JButton("Reset");

		btnReset.setBounds(300, 690, 120, 35);

		contentPane.add(btnReset);

		JButton btnExit = new JButton("Exit");

		btnExit.setBounds(480, 690, 120, 35);

		contentPane.add(btnExit);

		// SUBMIT BUTTON EVENT

		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					String name = txtName.getText().trim();
					if (name.isEmpty()) {
						throw new Exception("Name cannot be empty");
					}
					if (!name.matches("[a-zA-Z ]+")) {
						throw new Exception("Name must contain alphabets only..");
					}


					String email = txtEmail.getText().trim();
					if (!email.contains("@") || !email.contains(".com")) {
						throw new Exception("Invalid Email Format");
					}


					String password = String.valueOf(passwordField.getPassword());
					if (password.length() < 8) {

						throw new Exception("Password must be at least 8 characters");
					}
					
					String phone = txtPhone.getText().trim();
					if (phone.length() != 11) {

						throw new Exception("Phone number digits must be 11 ");

					}

					Long.parseLong(phone);

					String address = txtAddress.getText().trim();
					if (address.isEmpty()) {
						throw new Exception("Address cannot be empty, fill the field");
					}

					String gender = "";
					if (rdbtnMale.isSelected()) {
						gender = "Male";
					}

					else if (rdbtnFemale.isSelected()) {
						gender = "Female";
					}
					else if (rdbtnOther.isSelected()) {
						gender = "Other";
					}

					else {

						throw new Exception("Please select gender");

					}

					String department = comboDepartment.getSelectedItem().toString();
					if (department.equals("Select Department")) {
						throw new Exception("Please select department");
					}
					
					String skills = "";
					if (chkJava.isSelected()) {
						skills = skills + "Java ";
					}

					if (chkPython.isSelected()) {
						skills = skills + "Python ";
					}

					if (chkWeb.isSelected()) {
						skills =skills + "Web ";
					       }

					if (chkMobile.isSelected()) {
						skills = skills + "Mobile ";
                                  }
					if (skills.isEmpty()) {
						throw new Exception("Select at least one skill");
					}

					if (!chkTerms.isSelected()) {
						throw new Exception("Accept Terms & Conditions");

					}


					String experience = "";

					if (rdbtnBeginner.isSelected()) {

						experience = "Beginner";
					}

					else if (rdbtnIntermediate.isSelected()) {

						experience = "Intermediate";
					}

					else if (rdbtnAdvanced.isSelected()) {

						experience = "Advanced";
					}

					JOptionPane.showMessageDialog(
							null,

							"Registration Successful\n\n"
							+ "Name: " + name + "\n"
							+ "Email: " + email + "\n"
							+ "Phone: " + phone + "\n"
							+ "Address: " + address + "\n"
							+ "Gender: " + gender + "\n"
							+ "Department: " + department + "\n"
							+ "Skills: " + skills + "\n"
							+ "Experience: " + experience
					);
				}

				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(
							null,
							"Phone number must contain digits only"
					);
				}

				catch (Exception ex) {
					JOptionPane.showMessageDialog(
							null,
							ex.getMessage()
					);
				}

				finally {

					System.out.println("Validation Finished");
				}
			}
		});

		btnReset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtEmail.setText("");
				passwordField.setText("");
				txtPhone.setText("");
				txtAddress.setText("");

				genderGroup.clearSelection();
				experienceGroup.clearSelection();

				chkJava.setSelected(false);
				chkPython.setSelected(false);
				chkWeb.setSelected(false);
				chkMobile.setSelected(false);

				chkTerms.setSelected(false);

				comboDepartment.setSelectedIndex(0);

			}
		});

		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(
						null,
						"Are you sure you want to exit?",
						"Exit Confirmation",
						JOptionPane.YES_NO_OPTION
				);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}
}

			