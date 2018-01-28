package gradecalculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class is responsible for designing the center of the GUI program. Additionally, this
 * class interprets 4 of the buttons sent by the 'GradeCalcApp.' This class will contribute information
 * depending on what button is pressed. For example, if the 'Save!' button is pressed, this class will help
 * create a new file filled with data the user inputed into the center panel.  
 * 
 * @author Abhi D. Student
 * @version April 30, 2017
 */
public class AppCenterPanel extends JPanel implements ActionListener {

	// Borrowed Code: Tower Defense
	private static final long serialVersionUID = 42L;
	// End of Borrowed Code (Avoids the obnoxious warning)
	
	// Field TextField variables for the assignments (10 assignments in CS1410)
	private TextField assignment1 = new TextField("");
	private TextField assignment2 = new TextField("");
	private TextField assignment3 = new TextField("");
	private TextField assignment4 = new TextField("");
	private TextField assignment5 = new TextField("");
	private TextField assignment6 = new TextField("");
	private TextField assignment7 = new TextField("");
	private TextField assignment8 = new TextField("");
	private TextField assignment9 = new TextField("");
	private TextField assignment10 = new TextField("");

	// Field TextField variables for labs (8 graded labs in CS1410)
	private TextField lab1 = new TextField("");
	private TextField lab2 = new TextField("");
	private TextField lab4 = new TextField("");
	private TextField lab5 = new TextField("");
	private TextField lab8 = new TextField("");
	private TextField lab10 = new TextField("");
	private TextField lab11 = new TextField("");
	private TextField lab12 = new TextField("");

	// Field TextField variables for quizzes (5 graded quizzes in CS1410)
	private TextField quiz1 = new TextField("");
	private TextField quiz2 = new TextField("");
	private TextField quiz3 = new TextField("");
	private TextField quiz5 = new TextField("");
	private TextField quiz6 = new TextField("");

	// Field string variables for recording the information presented in respected TextFields
	String task1, task2, task3, task4, task5, task6, task7, task8, task9, task10, workshop1, workshop2,
	workshop4, workshop5, workshop8, workshop10, workshop11, workshop12, exam1, exam2, exam3, exam4, exam5, exam6;

	// Essential field boolean variable that will check to see if the user has pressed the save button
	private boolean isSaved = false;

	/**
	 * This is the constructor for the grade calculator. This constructor
	 * simply loads the text fields for the assignments, labs, and quizzes.
	 */
	public AppCenterPanel()
	{
		// Call the assignmentTextFields, labTextFields, and quizTextFields methods.
		assignmentTextFields();
		labTextFields();
		quizTextFields();
	}

	/**
	 * This method overrides the paint function for JPanels to design 
	 * the center panel (make it look nice).
	 */
	public void paint (Graphics g)
	{
		// Set the background color to Cyan
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// Create a TNR Title Font that will display the name of the program
		Font titleFont = new Font("Times New Roman", Font.BOLD + Font.CENTER_BASELINE, 24);
		g.setFont(titleFont); // Incorporate the font
		g.setColor(Color.RED); // Set the font to red
		g.drawString("CS-1410 Grade Calculator", 125, 25); // Draw the name

		// Create labels for 'Assignments', 'Labs', and 'Quizzes', have some specific font
		Font labelsTitle = new Font("Times New Roman", Font.BOLD, 18);
		g.setFont(labelsTitle); // Incorporate the font
		g.setColor(Color.ORANGE); // Set the font to orance

		// Draw the labels
		g.drawString("Assignments", 40, 75); 
		g.drawString("Labs", 247, 75);
		g.drawString("Quizzes", 385, 75);

		// Call the methods to draw the assignment numbers (and point possibility), lab numbers (and point possibility), and quiz numbers (and point possibility)
		assignmentLabels(g);
		labLabels(g);
		quizLabels(g);
	}

	/**
	 * This method adds the assignment text fields to the center panel, and organizes them.
	 */
	public void assignmentTextFields()
	{
		// Add the assignment text fields to the center panel (this class)
		this.add(assignment1);	
		this.add(assignment2);
		this.add(assignment3);
		this.add(assignment4);
		this.add(assignment5);
		this.add(assignment6);
		this.add(assignment7);
		this.add(assignment8);
		this.add(assignment9);
		this.add(assignment10);

		// Set the dimensions for each assignment text field
		assignment1.setBounds(75, 85, 25, 25);
		assignment2.setBounds(75, 125, 25, 25);
		assignment3.setBounds(75, 165, 25, 25);
		assignment4.setBounds(75, 205, 25, 25);
		assignment5.setBounds(75, 245, 25, 25);
		assignment6.setBounds(75, 285, 25, 25);
		assignment7.setBounds(75, 325, 25, 25);
		assignment8.setBounds(75, 365, 25, 25);
		assignment9.setBounds(75, 405, 25, 25);
		assignment10.setBounds(75, 445, 25, 25);

		// Give a border layout
		this.setLayout(new BorderLayout());
	}

	/**
	 * This method adds the lab text fields to the center panel, and organizes them.
	 */
	public void labTextFields()
	{
		// Add the lab text fields to the center panel (this class)
		this.add(lab1);	
		this.add(lab2);
		this.add(lab4);
		this.add(lab5);
		this.add(lab8);
		this.add(lab10);
		this.add(lab11);
		this.add(lab12);

		// Set the dimensions for each lab text field
		lab1.setBounds(255, 85, 25, 25);
		lab2.setBounds(255, 125, 25, 25);
		lab4.setBounds(255, 165, 25, 25);
		lab5.setBounds(255, 205, 25, 25);
		lab8.setBounds(255, 245, 25, 25);
		lab10.setBounds(255, 285, 25, 25);
		lab11.setBounds(255, 325, 25, 25);
		lab12.setBounds(255, 365, 25, 25);

		// Give a border layout
		this.setLayout(new BorderLayout());
	}

	/**
	 * This method adds the quiz text fields to the center panel, and organizes them.
	 */
	public void quizTextFields()
	{
		// Add the quiz text fields to the center panel (this class)
		this.add(quiz1);	
		this.add(quiz2);
		this.add(quiz3);
		this.add(quiz5);
		this.add(quiz6);

		// Set the dimensions for each quiz text field
		quiz1.setBounds(405, 85, 25, 25);
		quiz2.setBounds(405, 125, 25, 25);
		quiz3.setBounds(405, 165, 25, 25);
		quiz5.setBounds(405, 245, 25, 25);
		quiz6.setBounds(405, 285, 25, 25);

		// Give a border layout
		this.setLayout(new BorderLayout());
	}

	/**
	 * This method is called by the paint method and simply sets up the labels 
	 * (assignment number and point possibilities) for the assignments
	 * 
	 * @param g, A Graphics Object
	 */
	public void assignmentLabels(Graphics g)
	{
		// Labels (assignment numbers) for the assignments
		Font labels = new Font("Times New Roman", Font.BOLD, 14); // TNR bold font for the labels
		g.setFont(labels); // Incorporate the font
		g.setColor(Color.BLACK); // Set the font to black
		g.drawString("#1", 55, 102);
		g.drawString("#2", 55, 142);
		g.drawString("#3", 55, 182);
		g.drawString("#4", 55, 222);
		g.drawString("#5", 55, 262);
		g.drawString("#6", 55, 302);
		g.drawString("#7", 55, 342);
		g.drawString("#8", 55, 382);
		g.drawString("#9", 55, 422);
		g.drawString("#10", 50, 462);

		// Point possibility labels for the assignments (respectfully)
		g.drawString("/75", 100, 102);
		g.drawString("/75", 100, 142);
		g.drawString("/100", 100, 182);
		g.drawString("/100", 100, 222);
		g.drawString("/140", 100, 262);
		g.drawString("/100", 100, 302);
		g.drawString("/100", 100, 342);
		g.drawString("/75", 100, 382);
		g.drawString("/125", 100, 422);
		g.drawString("/100", 100, 462);
	}

	/**
	 * This method is called by the paint method and simply sets up the labels 
	 * (lab number and point possibilities) for the labs
	 * 
	 * @param g, A Graphics Object
	 */
	public void labLabels(Graphics g)
	{
		// Labels (lab number) for the labs
		Font labels = new Font("Times New Roman", Font.BOLD, 14); // TNR bold font for the labels
		g.setFont(labels); // Incorporate the font
		g.setColor(Color.BLACK); // Set the font to black
		g.drawString("#1", 235, 102);
		g.drawString("#2", 235, 142);
		g.drawString("#4", 235, 182);
		g.drawString("#5", 235, 222);
		g.drawString("#8", 235, 262);
		g.drawString("#10", 230, 302);
		g.drawString("#11", 230, 342);
		g.drawString("#12", 230, 382);

		// Point possibility labels for the labs (respectfully)
		g.drawString("/25", 280, 102);
		g.drawString("/20", 280, 142);
		g.drawString("/15", 280, 182);
		g.drawString("/20", 280, 222);
		g.drawString("/10", 280, 262);
		g.drawString("/10", 280, 302);
		g.drawString("/25", 280, 342);
		g.drawString("/10", 280, 382);
	}

	/**
	 * This method is called by the paint method and simply sets up the labels
	 * (lab number and point possibilities) for the quizzes
	 * 
	 * @param g, A Graphics Object
	 */
	public void quizLabels(Graphics g)
	{
		// Labels for the quizzes
		Font labels = new Font("Times New Roman", Font.BOLD, 14); // TNR bold font for the labels
		g.setFont(labels); // Incorporate the font
		g.setColor(Color.BLACK); // Set the font to black
		g.drawString("#1", 385, 102);
		g.drawString("#2", 385, 142);
		g.drawString("#3", 385, 182);
		g.drawString("#4", 385, 222);
		g.drawString("0 (Canceled)", 415, 222);
		g.drawString("#5", 385, 262);
		g.drawString("#6", 385, 302);

		// Point possibility labels for the quizzes (respectfully)
		g.drawString("/70", 430, 102);
		g.drawString("/100", 430, 142);
		g.drawString("/100", 430, 182);
		g.drawString("/100", 430, 262);
		g.drawString("/100", 430, 302);

	}

	/**
	 * This is the action performed method for this class (since this class implements the action listener
	 * interface. This method will interpret and give information to the 4 GUI objects (buttons) sent to this
	 * class (from the 'GradeCalcApp')
	 * 
	 * @param ActionEvent e, action being received
	 */
	public void actionPerformed(ActionEvent e) 
	{
		// Create an object and set it equal to the source of the action event
		Object source = e.getSource();

		// Cast the object to be a JButton
		JButton b = (JButton) source;

		// Assign the string field variables (respected name) to each text field respectfully.
		task1 = assignment1.getText(); // Task 1 will equal assignment 1 and so on..
		task2 = assignment2.getText();
		task3 = assignment3.getText();
		task4 = assignment4.getText();
		task5 = assignment5.getText();
		task6 = assignment6.getText();
		task7 = assignment7.getText();
		task8 = assignment8.getText();
		task9 = assignment9.getText();
		task10 = assignment10.getText();
		workshop1 = lab1.getText(); // Workshop 1 will equal lab 1 and so on...
		workshop2 = lab2.getText();
		workshop4 = lab4.getText();
		workshop5 = lab5.getText();
		workshop8 = lab8.getText();
		workshop10 = lab10.getText();
		workshop11 = lab11.getText();
		workshop12 = lab12.getText();
		exam1 = quiz1.getText(); // Exam 1 will equal quiz 1 and so on.
		exam2 = quiz2.getText();
		exam3 = quiz3.getText();
		exam4 = "0";
		exam5 = quiz5.getText();
		exam6 = quiz6.getText();

		// Borrowed code: Stack Overflow
		String userHome = System.getProperty("user.home");
		// End borrowed code. (This gets the user's home information and assigns it to a String variable).

		// If the Action Event is a 'Save' JButton pressed and the user has not pressed save
		if (b.getText() == "Save!" && isSaved == false)
		{
			// Set the 'isSaved' field variable equal to true
			isSaved = true;

			// Give the user a message that a file has been saved to the user's desktop
			JOptionPane.showMessageDialog(this, "The file 'CS1410 Grade.txt' has been saved"
					+ " to your desktop!");
			try
			{
				// Call the empty text method to see if there are any empty field variable strings. Set them equal to "0" before moving on.
				emptyTexts();

				// Borrowed code: Stack Overflow
				PrintWriter fileWriter = new PrintWriter(userHome + "\\desktop\\" + "CS1410 Grade.txt", "UTF-8");
				// End borrowed code. (This creates a file to the user's desktop and allows to write in it)

				// In the file created, write the points earned (or grades for the user) in each line of the file. Write in respect to how the user inputs the data.
				fileWriter.println(task1); // All assignment grades...
				fileWriter.println(task2);
				fileWriter.println(task3);
				fileWriter.println(task4);
				fileWriter.println(task5);
				fileWriter.println(task6);
				fileWriter.println(task7);
				fileWriter.println(task8);
				fileWriter.println(task9);
				fileWriter.println(task10);
				fileWriter.println(workshop1); // All lab grades...
				fileWriter.println(workshop2);
				fileWriter.println(workshop4);
				fileWriter.println(workshop5);
				fileWriter.println(workshop8);
				fileWriter.println(workshop10);
				fileWriter.println(workshop11);
				fileWriter.println(workshop12);
				fileWriter.println(exam1); // All exam grades.
				fileWriter.println(exam2);
				fileWriter.println(exam3);
				fileWriter.println(exam4);
				fileWriter.println(exam5);
				fileWriter.println(exam6);
				fileWriter.close(); // Close the file scanner (or end writing inside the file)
			} 
			// Catch an I/O exception when created the file, and print out a friendly statement
			catch (IOException execption) 
			{
				System.out.println("Could not create the file.");
			}
		}
		// If the Action Event is a 'Abhi's Grades!' JButton press
		if (b.getText() == "Abhi's Grades!")
		{
			// Load my personal grades into the text fields
			assignment1.setText("75");
			assignment2.setText("75");
			assignment3.setText("100");
			assignment4.setText("100");
			assignment5.setText("134");
			assignment6.setText("99");
			assignment7.setText("100");
			assignment8.setText("100");
			assignment9.setText("100");
			assignment10.setText("100");
			lab1.setText("25");
			lab2.setText("20");
			lab4.setText("15");
			lab5.setText("20");
			lab8.setText("10");
			lab10.setText("10");
			lab11.setText("25");
			lab12.setText("10");
			quiz1.setText("50");
			quiz2.setText("78");
			quiz3.setText("85");
			quiz5.setText("100");
			quiz6.setText("100");

			// Force the user to save another file
			isSaved = false;
		}
		// If the Action Event is a 'Calculate!' JButton pressed and the user has not pressed save
		else if (b.getText() == "Calculate!" && isSaved == false)
		{
			// Display a message telling the user to click save
			JOptionPane.showMessageDialog(this, "You must click save to save the text file used for calculating"
					+ " your grades!");
		}
		// If the Action Event is a 'Calculate!' JButton pressed and the user has pressed save
		else if (b.getText() == "Calculate!" && isSaved == true)
		{
			// Create a grader object (see information in 'Grader' class)
			Grader grade = new Grader();

			// Display a message showing the user what grade they earned by using the Grader class' methods and data.
			JOptionPane.showMessageDialog(this, "Your grade is: " + grade.getPercentage() * 100 + "%, (based on a 97% curve and with quiz 4 canceled)" + " with a letter grade"
					+ " of : '" + grade.getGrade() + "'");

			// Set 'isSaved' field variable back to false in order to force the user to resave when modifying text fields
			isSaved = false;
		}	
		// If the Action Event is a 'Clear!' JButton pressed
		else if (b.getText() == "Clear!")
		{
			// Empty any data in the textfields
			assignment1.setText("");
			assignment2.setText("");
			assignment3.setText("");
			assignment4.setText("");
			assignment5.setText("");
			assignment6.setText("");
			assignment7.setText("");
			assignment8.setText("");
			assignment9.setText("");
			assignment10.setText("");
			lab1.setText("");
			lab2.setText("");
			lab4.setText("");
			lab5.setText("");
			lab8.setText("");
			lab10.setText("");
			lab11.setText("");
			lab12.setText("");
			quiz1.setText("");
			quiz2.setText("");
			quiz3.setText("");
			quiz5.setText("");
			quiz6.setText("");

			// Set 'isSaved' back to false to force the user to resave when modifying text fields
			isSaved = false;
		}	
	}

	/**
	 * This method simply checks if any of the text fields are empty before creating a file. If the text fields are empty
	 * then set the string field variables to "0" when recording the data in the file (this is crucial, so no out of bounds
	 * exception is thrown in the 'Grader' class). 
	 */
	public void emptyTexts()
	{
		// If any of the assignments, labs, or quiz text fields are empty, set their respected string field variables to "0"
		if (assignment1.getText().isEmpty())
			task1 = "0";
		if (assignment2.getText().isEmpty())
			task2 = "0";
		if (assignment3.getText().isEmpty())
			task3 = "0";
		if (assignment4.getText().isEmpty())
			task4 = "0";
		if (assignment5.getText().isEmpty())
			task5 = "0";
		if (assignment6.getText().isEmpty())
			task6 = "0";
		if (assignment7.getText().isEmpty())
			task7 = "0";
		if (assignment8.getText().isEmpty())
			task8 = "0";
		if (assignment9.getText().isEmpty())
			task9 = "0";
		if (assignment10.getText().isEmpty())
			task10 = "0";
		if (lab1.getText().isEmpty())
			workshop1 = "0";
		if (lab2.getText().isEmpty())
			workshop2 = "0";
		if (lab4.getText().isEmpty())
			workshop4 = "0";
		if (lab5.getText().isEmpty())
			workshop5 = "0";
		if (lab8.getText().isEmpty())
			workshop8 = "0";
		if (lab10.getText().isEmpty())
			workshop10 = "0";
		if (lab11.getText().isEmpty())
			workshop11 = "0";
		if (lab12.getText().isEmpty())
			workshop12 = "0";
		if (quiz1.getText().isEmpty())
			exam1 = "0";
		if (quiz2.getText().isEmpty())
			exam2 = "0";
		if (quiz3.getText().isEmpty())
			exam3 = "0";
		if (quiz5.getText().isEmpty())
			exam5 = "0";
		if (quiz6.getText().isEmpty())
			exam6 = "0";
	}
}
