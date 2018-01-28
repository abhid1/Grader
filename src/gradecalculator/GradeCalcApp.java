package gradecalculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * This is the basic GUI setup for the Grade Calculator Extra Credit Assignment. Basically this class runs the GUI Thread,
 * sets up the layout of the GUI, incorporates GUI objects, and listens to one of the GUI objects. Additionally, this class
 * relies on another class (AppCenterPanel) in order to setup the center GUI (see 'AppCenterPanel' for more information).
 * 
 * @author Abhi D. Student
 * @version April 30, 2017
 */
public class GradeCalcApp implements Runnable, ActionListener{

	/*
	 * This method is the main method that is responsible for executing
	 * the GUI (GUI thread).
	 */
	public static void main(String[] args) 
	{
		// Create a runnable object
		GradeCalcApp app = new GradeCalcApp();

		// Run the GUI Thread
		SwingUtilities.invokeLater(app);
	}

	// Field Variables essential for setting up the GUI
	private AppCenterPanel centerPanel = new AppCenterPanel();
	private JFrame frame;

	/**
	 * This is the GUI thread, or when the GUI Thread is executed
	 */
	public void run() 
	{	
		// Create a new JFrame and allow close option
		frame = new JFrame("CS1410 - Grade Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build essential panels 
		JPanel container = new JPanel(); // Main container
		JPanel southPanel = new JPanel(); // Will hold the GUI buttons

		// Set the layout of the panels
		container.setLayout(new BorderLayout());
		southPanel.setLayout(new FlowLayout());

		// Build the essential GUI objects
		JButton calculate = new JButton("Calculate!"); // Calculate button
		JButton help = new JButton("Help!"); // Help button
		JButton save = new JButton("Save!"); // Save button
		JButton loadPersonal = new JButton("Abhi's Grades!"); // Load Abhi's Grades button
		JButton clear = new JButton("Clear!"); // Clear button

		// Listen to the button in the center panel class, and this class
		calculate.addActionListener(centerPanel); // Interpret calculate in the AppCenterPanel
		save.addActionListener(centerPanel); // Interpret save in the AppCenterPanel
		loadPersonal.addActionListener(centerPanel); // Interpret Load Abhi's Grades in the AppCenterPanel
		clear.addActionListener(centerPanel); // Interpret clear in the AppCenterPanel
		help.addActionListener(this); // Interpret help in this panel

		// Set dimensions of the GUI
		centerPanel.setMaximumSize(new Dimension(500, 500)); 
		centerPanel.setPreferredSize(new Dimension(500, 500)); 

		// Add the GUI objects (or buttons) to the south panel (or button panel)
		southPanel.add(calculate);
		southPanel.add(help);
		southPanel.add(save);
		southPanel.add(loadPersonal);
		southPanel.add(clear);

		// Add the button panel to the container
		container.add(southPanel, BorderLayout.SOUTH);

		// Add the center panel created by 'AppCenterPanel' to the container
		container.add(centerPanel, BorderLayout.CENTER);

		// Set 'container' as the container
		frame.setContentPane(container);

		// Pack and display the frame
		frame.pack();
		frame.setResizable(false); // Don't let user to adjust the GUI program
		frame.setLocationRelativeTo(null); // Center the GUI (borrowed idea from Tower Defense)
		frame.setVisible(true); // Set the GUI visible
	}

	/**
	 * This is the actionPerformed method. Because this class implements the Action Listener interface, we need
	 * this method. This method simply interprets when the user presses the 'Help' button.
	 */
	public void actionPerformed(ActionEvent e) 
	{	
		// Create an object and set it equal to the source of the action event parameter
		Object source = e.getSource();
		JButton b = (JButton) source; // Cast the object to a JButton so we can get its text

		// If the JButton is the 'Help' button
		if (b.getText() == "Help!")
		{
			// Display some instructions
			JOptionPane.showMessageDialog(frame, "Enter your scores (as integers - *text fields that are empty will automatically be zero*) for each assignment, "
					+ " lab, and quiz. Then press 'save!', followed by 'calculate!' to see your percentage and grade for CS1410!");
		}
	}
}
