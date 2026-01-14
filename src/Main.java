/** The requirements for this program:
 * -) Store the 50 US states and their capital cities into a two-dimensional array (matrix), ordered alphabetically by state
 * -) Display the contents of the array to the user via the output console
 * -) Use a "bubble sort" to sort the contents of the array alphabetically by capital
 * -) Prompt the user to enter an answer for the capital of each state, then report to the user whether each answer is correct
 * -) When all capitals are done, display the total number of answers the user got right
 * -) The user's answers must NOT be case-sensitive
 */

// import any necessary API utilities for this program
import java.util.Arrays; // Imports the "Arrays" utility to allow for easier array manipulation
import java.util.Scanner; // Imports the "Scanner" utility to allow for user input

public class Main { // Declares the "Main" class for this program
	
	// Store the data for the states and capitals in an array
	
	String [][] capitals = { // declares the initial two-dimensional array and adds in the states and their capitals
	
		{"Alabama", "Montgomery"},
		{"Alaska", "Juneau"},
		{"Arizona", "Phoenix"},
		{"Arkansas", "Little Rock"},
		{"California", "Sacramento"},
		{"Colorado", "Denver"},
		{"Connecticut", "Hartford"},
		{"Delaware", "Dover"},
		{"Florida", "Tallahassee"},
		{"Georgia", "Atlanta"},
		{"Hawaii", "Honolulu"},
		{"Idaho", "Boise"},
		{"Illinois", "Springfield"},
		{"Indiana", "Indianapolis"},
		{"Iowa", "Des Moines"},
		{"Kansas", "Topeka"},
		{"Kentucky", "Frankfort"},
		{"Louisiana", "Baton Rouge"},
		{"Maine", "Augusta"},
		{"Maryland", "Annapolis"},
		{"Massachusetts", "Boston"},
		{"Michigan", "Lansing"},
		{"Minnesota", "Saint Paul"},
		{"Mississippi", "Jackson"},
		{"Missouri", "Jefferson City"},
		{"Montana", "Helena"},
		{"Nebraska", "Lincoln"},
		{"Nevada", "Carson City"},
		{"New Hampshire", "Concord"},
		{"New Jersey", "Trenton"},
		{"New Mexico", "Santa Fe"},
		{"New York", "Albany"},
		{"North Carolina", "Raleigh"},
		{"North Dakota", "Bismarck"},
		{"Ohio", "Columbus"},
		{"Oklahoma", "Oklahoma City"},
		{"Oregon", "Salem"},
		{"Pennsylvania", "Harrisburg"},
		{"Rhode Island", "Providence"},
		{"South Carolina", "Columbia"},
		{"South Dakota", "Pierre"},
		{"Tennessee", "Nashville"},
		{"Texas", "Austin"},
		{"Utah", "Salt Lake City"},
		{"Vermont", "Montpelier"},
		{"Virginia", "Richmond"},
		{"Washington", "Olympia"},
		{"West Virginia", "Charleston"},
		{"Wisconsin", "Madison"},
		{"Wyoming", "Cheyenne"}

	};
	
	// Methods in the "Main" class to manipulate the array
	
	// Method to turn the full array to a String for printing to the output console
	void arrayToString(String[][] arr) { // Declare the method with the array as an input parameter
		System.out.println("The states and their capitals sorted by state:"); // Title for array content
		
		for (int i = 0; i < arr.length; i++) { // "for" loop to iterate over each row in the array
			System.out.println(Arrays.toString(arr[i])); // Convert the array rows to strings and print to output console
		}
		System.out.println(); // Blank line to space things out
	}
	
	// Method to "bubble sort" the array alphabetically by capital
	void bubbleSort(String arr[][]) { // Declare the method with the array as an input parameter	
		// Two "for" loops are required to compare two indexed values per row (called "i" and "j")
		for (int i = 0; i < arr.length; i++) { // Outer "for" loop that spans the entire array
			for (int j = i + 1; j < arr.length; j++) { // Inner "for" loop that jumps one element ahead of the "i" loop
				if (arr[j][1].compareTo(arr[i][1]) < 0) { // If the "j" indexed value should be before the "i" indexed value...
					String[] temp = arr[j]; // Temporary holding variable for the original "j" row
					arr[j] = arr[i]; // Swap the "j" and "i" rows
					arr[i] = temp; // Swap the "i" row with the original "j" row
				}
			}
		}
	}
	
	// Method to receive user input, match it to the data in the array, and keep a score of correct answers
	void capitalsQuiz(String[][] arr) { // Declare the method with the array as an input parameter
		Scanner scanner = new Scanner(System.in); // Creates an instance of the imported "Scanner" utility with user input as a parameter
		int score = 0; // Initialize the player's score in an "int" variable
		for (int i = 0; i < arr.length; i++) { // "for" loop to loop over all the capital cities
			System.out.println("What is the capital of " + arr[i][0] + "?"); // Prints the line that asks the question
			String Answer = scanner.nextLine(); // Takes the input from the user
			if(Answer.equalsIgnoreCase(arr[i][1])) { // If the user's answer matches the correct city (NOT case-sensitive)...
				score++; // Add one point to the user's score
				System.out.println("That is correct. Your score is now " + score + "/50."); // Congratulate the player for guessing correctly
				System.out.println(); // Blank line to space things out
			} else { // If the user's answer does NOT match the correct city...
				System.out.println("Nope, that's not correct. Your score is now " + score + "/50."); // Notify the player that they were incorrect
				System.out.println(); // Blank line to space things out
			}
		}
		System.out.println("Your final score was " + score + "/50."); // Print the player's final score to the output console
	}
	
	// "main" method; all previous methods are called into action here
	public static void main(String[] args) {
		Main main = new Main(); // Creates an instance of the "Main" class so that the array and methods can be accessed
		
		// Display the current contents of the array (pre-sort)
		main.arrayToString(main.capitals); // Calls the "arrayToString" method on the "capitals" array
		
		// Sort the contents of the array
		main.bubbleSort(main.capitals); // Calls the "bubbleSort" method on the "capitals" array
		
		// Begin the Capitals Quiz
		main.capitalsQuiz(main.capitals); // Calls the "capitalsQuiz" method on the "capitals" array
	}
}