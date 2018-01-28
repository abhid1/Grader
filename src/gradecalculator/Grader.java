/**
 * 
 */
package gradecalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is solely responsible for "grading" the user's input in the Grade Calculator program. Because a new file is created
 * this class only needs to interpret the data in that file, and obtain the user's final percentage based on quiz 4 being canceled, and 
 * a 97% curve.
 * 
 * @author Abhi D. Student
 * @version April 30, 2017
 */
public class Grader {

	// Essential field variables for obtaining the final percentage
	private double programmingTotal = 990; // Total points possible for the assignments
	private double labTotal = 135; // Total points possible for the labs
	private double quizTotal = 570; // Total points possible for the quizzes
	
	// Declare variables to keep track of the total points the user has earned in assignments, labs, and quizzes
	private double assignmentTotal = 0; 
	private double labsTotal = 0;
	private double quizzesTotal = 0;

	/**
	 * This is the constructor for the 'Grader' class. This constructor simply scans through the file created in the
	 * desktop and adds the data to respected Array Lists. Additionally, this constructor will take the points in the Array Lists
	 * and calculate the points the user has earned (set them equal to respected field variables)
	 */
	public Grader()
	{
		// Borrowed code: Stack Overflow
		String userHome = System.getProperty("user.home");
		// End borrowed code. (This gets the user's home information and assigns it to a String variable).
		
		// Obtain the file in the desktop and set it equal to a new file
		File savedFile = new File(userHome + "\\desktop\\" + "CS1410 Grade.txt");
		
		// Surround with try catch statements
		try 
		{
			// Create a new scanner object, and scan the file in the desktop
			Scanner userGrades = new Scanner(savedFile);

			// Create and initialize Array Lists for assignments, labs, and quizzes
			List<Integer> assignments = new ArrayList<Integer>();
			List<Integer> labs = new ArrayList<Integer>();
			List<Integer> quizzes = new ArrayList<Integer>();

			// If there are integers in the data
			if (userGrades.hasNextInt())
			{
				// For the first 10 integers (each assignment point)
				for (int i = 1; i <= 10; i++)
				{
					// Get the points and add them to the 'assignments' Array List
					int points = userGrades.nextInt();
					assignments.add(points);
				}
				// For the next 8 integers (each lab point)
				for (int i = 1; i <= 8; i++)
				{
					// Get the points and add them to the 'labs' Array List
					int points = userGrades.nextInt();
					labs.add(points);
				}
				// For the next 6 integers (each quiz point)
				for (int i = 1; i <= 6; i++)
				{
					// Get the points and add them to the 'quizzes' Array List
					int points = userGrades.nextInt();
					quizzes.add(points);
				}
				
				// Declare a integer count variable and set it equal to 0
				int count = 0;
				
				// For each integer in the assignments list
				for (Integer a : assignments)
				{
					// Get each integer value in the assignments list, and obtain the total
					assignmentTotal = assignments.get(count) + assignmentTotal;
					
					// Increment the count
					count++;
				}
				
				// Set count back to 0
				count = 0;
				
				// For each integer in the labs list
				for (Integer a: labs)
				{
					// Get each integer value in the labs list, and obtain the total
					labsTotal = labs.get(count) + labsTotal;
					
					// Increment the count
					count++;
				}
				
				// Set count back to 0
				count = 0;
				
				// For each integer in the quizzes list
				for (Integer a: quizzes)
				{
					// Get each integer value in the quizzes list, and obtain the total
					quizzesTotal = quizzes.get(count) + quizzesTotal;
					
					// Increment the count
					count++;
				}
			}

		} 
		// If the file cannot be found
		catch (FileNotFoundException e) 
		{
			// Print out a friendly statement
			System.out.println("Cannot find the file.");
		}
	}

	/**
	 * This method will get the final percentage based on the grades the user earned in CS1410. 
	 * 
	 * @return finalGrade, the final percentage (decimal value)
	 */
	public double getPercentage()
	{
		// Get the final grades by taking the total for each respected category, divide it by the total of that category, turn it into a percentage, and multiply it by the category weight
		double finalAssignmentGrade = ((assignmentTotal / programmingTotal) * 100) * .38;
		double finalLabGrade = ((labsTotal / labTotal) * 100) * .20;
		double finalQuizGrade = ((quizzesTotal / quizTotal) * 100) * .42;

		// To obtain the final, curved grade, add the final grades in each category, divide it by 100 (obtain decimal percent value), divide that by .93 (93% total possible point), and then divide that by .97 (97% curve)
		double finalGrade = (((finalAssignmentGrade + finalLabGrade + finalQuizGrade) / 100) / .93) / .97;

		// Return the final grade (decimal value)
		return finalGrade;
	}

	/**
	 * This method will interpret the final percentage (calls the getPercentage method), and associate it with a string character and return that 
	 * character
	 * 
	 * @return a String, letter grade
	 */
	public String getGrade()
	{
		// Obtain the decimal value final grade
		double percentGrade = getPercentage();
		
		// Create a String grade variable and set it equal to empty strings
		String grade = "";

		// If the percent grade is greater than or equal to 93%
		if (percentGrade >= .93)
		{
			// Set grade equal to an A
			grade = "A";
		}
		// If the percent grade is greater than or equal to 90% but less than 93%
		else if (percentGrade >= .90 && percentGrade < .93)
		{
			// Set the grade to an A-
			grade = "A-";
		}
		// If the percent grade is greater than or equal to 88% but less than 90%
		else if (percentGrade >= .88 && percentGrade < .90)
		{
			// Set the grade to a B+
			grade = "B+";
		}
		// If the percent grade is greater than or equal to 83% but less than 80%
		else if (percentGrade >= .83 && percentGrade < .88)
		{
			// Set the grade equal to a B
			grade = "B";
		}
		// If the percent grade is greater than or equal to 80% but less than 83%
		else if (percentGrade >= .80 && percentGrade < .83)
		{
			// Set the grade to a B-
			grade = "B-";
		}
		// If the percent grade is greater than or equal to 78% but less than 80%
		else if (percentGrade >= .78 && percentGrade < .80)
		{
			// Set the grade to a C+
			grade = "C+";
		}
		// If the percent grade is greater than or equal to 73% but less than 78%
		else if (percentGrade >= .73 && percentGrade < .78)
		{
			// Set the grade to a C
			grade = "C";
		}
		// If the percent grade is greater than or equal to 70% but less than 73%
		else if (percentGrade >= .70 && percentGrade < .73)
		{
			// Set the grade to a C-
			grade = "C-";
		}
		// If the percent grade is greater than or equal to 68% but less than 70%
		else if (percentGrade >= .68 && percentGrade < .70)
		{
			// Set the grade to a D+
			grade = "D+";
		}
		// If the percent grade is greater than or equal to 60% but less than 68%
		else if (percentGrade >= .60 && percentGrade < .68)
		{
			// Set the grade to a D
			grade = "D";
		}
		// If the percent grade is greater than or equal to 50% but less than 60%
		else if (percentGrade >= .50 && percentGrade < .60)
		{
			// Set the grade to a D-
			grade = "D-";
		}
		// IF the percent grade is greater than or equal to 0% but less than 50%
		else if (percentGrade >= .0 && percentGrade < .50)
		{
			// Set the grade equal to an E
			grade = "E";
		}
		
		// Return the grade
		return grade;
	}
}
