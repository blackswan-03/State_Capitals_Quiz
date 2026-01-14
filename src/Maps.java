/** The requirements for this program:
 * -) Store the 50 US states and their capital cities into an unsorted HashMap
 * -) Display the contents of this unsorted map to the output console
 * -) Convert the HashMap into a TreeMap to sort it alphabetically by state
 * -) Create a binary search tree to store the Map data in
 * -) Prompt the user to enter a state, then return the capital of that state
 */

// import any necessary API utilities for this program
import java.util.Map; // Imports the "Map" utility to allow for the use of "Map" data structures
import java.util.Map.Entry; // Imports the "Entry" utility to allow for the use of the "Entry" data structure
import java.util.HashMap; // Imports the "HashMap" utility to allow for the use of the "HashMap" data structure
import java.util.TreeMap; // Imports the "TreeMap" utility to allow for the sorting of the HashMap
import java.util.Scanner; // Imports the "Scanner" utility to allow for user input

// "Tree" class for all of the code relating to the binary search tree
class Tree {
	// Set up the binary search tree for data storage
	class Node { // Declare a "Node" class for the individual nodes in the binary search tree
		String data; // "String" variable to hold the data (i.e., key) for each node
		Node leftChild; // Identifies the left child of the parent node (if it exists)
		Node rightChild; // Identifies the right child of the parent node (if it exists)
			
		Node(String data) { // Method to initialize a node using incoming "String" data as an input parameter
			this.data = data; // Matches the incoming data to the "data" variable
			leftChild = rightChild = null; // Sets both "leftChild" and "rightChild" to "null" prior to insertion
		}
	}
		
	Node root; // Initializes a root node for the binary search tree
		
	public Tree() { // Call the constructor method for the "Maps" class
		root = null; // Assigns the "root" node a value of "null"
	}
		
	public Node insertNode(Node node, String key) { // Function that inserts a new node into the tree
		if(node == null) { // If the node is empty/null...
			node = new Node(key); // Create a new node with a unique identifier key
			return node; // Return the node to the function
		}
		if(key.compareTo(node.data) <= 0) { // If the key is alphabetically lower than the previous node's key...
			node.leftChild = insertNode(node.leftChild, key); // Recursively call the "insertNode" function to insert a left child node
		} else if(key.compareTo(node.data) > 0) { // Else if the key is alphabetically higher than the previous node's key...
			node.rightChild = insertNode(node.rightChild, key); // Recursively call the "insertNode" function to insert a right child node
		}
		return node; // Return the node to the function
	}
		
	public void insert(String key) { // Method that allows new values/nodes to be inserted into the tree
		root = insertNode(root, key); // Calls the "insertNode" function and stores the returned value as "root"
	}
		
	public Node findNode (Node node, String key) { // Function that looks for a specific node in the tree
		if(key.compareTo(node.data) == 0) { // If the input key is equal to a node in the tree...
			return node; // Return that node to the function
		}
		if(key.compareTo(node.data) <= 0) { // If the input key is alphabetically lower than a node's key...
			if(node.leftChild == null) { // If the node has no left child...
				return null; // Return "null" to the function (i.e., the input node does not exist on the tree)
			} else { // If the node DOES have a left child...
				return findNode(node.leftChild, key); // Return that left child to the function
			}
		} else if(key.compareTo(node.data) > 0) { // Else if the input key is alphabetically higher than a node's key...
			if(node.rightChild == null) { // If the node has no right child...
				return null; // Return "null" to the function (i.e., the input node does not exist on the tree)
			} else { // If the node DOES have a right child...
				return findNode(node.rightChild, key); // Return that right child to the function
			}
		}
		return node; // Return the final node to the function
	}
		
	public Node find(String key) { // Function that asks which node to find
		Node node = findNode(root, key); // Calls the "findNode" function and stores the returned value as a "node"
		return node; // Returns the found "node" to the function
	}
}

// The main class for this program ("Maps")
public class Maps {
	
	// Declare the initial HashMap for the states and their capitals
	Map<String, String> capitals = new HashMap<String, String>();
	
	// Methods in the "Maps" class to declare and manipulate the HashMap
	
	// Method to store the data for the states and capitals in the "capitals" HashMap
	void fillMap(Map<String, String> map) { // Declares the method with the HashMap as an input parameter
		
		// Fill in the HashMap with the keys (states) and values (capitals)
		map.put("Alabama", "Montgomery");
		map.put("Alaska", "Juneau");
		map.put("Arizona", "Phoenix");
		map.put("Arkansas", "Little Rock");
		map.put("California", "Sacramento");
		map.put("Colorado", "Denver");
		map.put("Connecticut", "Hartford");
		map.put("Delaware", "Dover");
		map.put("Florida", "Tallahassee");
		map.put("Georgia", "Atlanta");
		map.put("Hawaii", "Honolulu");
		map.put("Idaho", "Boise");
		map.put("Illinois", "Springfield");
		map.put("Indiana", "Indianapolis");
		map.put("Iowa", "Des Moines");
		map.put("Kansas", "Topeka");
		map.put("Kentucky", "Frankfort");
		map.put("Louisiana", "Baton Rouge");
		map.put("Maine", "Augusta");
		map.put("Maryland", "Annapolis");
		map.put("Massachusetts", "Boston");
		map.put("Michigan", "Lansing");
		map.put("Minnesota", "Saint Paul");
		map.put("Mississippi", "Jackson");
		map.put("Missouri", "Jefferson City");
		map.put("Montana", "Helena");
		map.put("Nebraska", "Lincoln");
		map.put("Nevada", "Carson City");
		map.put("New Hampshire", "Concord");
		map.put("New Jersey", "Trenton");
		map.put("New Mexico", "Santa Fe");
		map.put("New York", "Albany");
		map.put("North Carolina", "Raleigh");
		map.put("North Dakota", "Bismarck");
		map.put("Ohio", "Columbus");
		map.put("Oklahoma", "Oklahoma City");
		map.put("Oregon", "Salem");
		map.put("Pennsylvania", "Harrisburg");
		map.put("Rhode Island", "Providence");
		map.put("South Carolina", "Columbia");
		map.put("South Dakota", "Pierre");
		map.put("Tennessee", "Nashville");
		map.put("Texas", "Austin");
		map.put("Utah", "Salt Lake City");
		map.put("Vermont", "Montpelier");
		map.put("Virginia", "Richmond");
		map.put("Washington", "Olympia");
		map.put("West Virginia", "Charleston");
		map.put("Wisconsin", "Madison");
		map.put("Wyoming", "Cheyenne");
	
		// Display results
		System.out.println("The states and their capitals unsorted:"); // Title for HashMap content
		System.out.println(map); // Print the full HashMap to the output console
		System.out.println(); // Blank line to space things out
	}
	
	// Method to sort the HashMap via the "TreeMap" API utility
	void sortMap(Map<String, String> map) { // Declares the method with the HashMap as an input parameter
		
		// Create the TreeMap and fill it with the data from the HashMap
		TreeMap<String, String> sortedMap = new TreeMap<String, String>(); // Declare a new TreeMap that will properly sort the HashMap
		sortedMap.putAll(map); // Insert all of the HashMap keys and values into the new TreeMap
		capitals = sortedMap; // Assign the new "sortedMap" to the "capitals" HashMap
		
		// Display results
		System.out.println("The states and their capitals sorted by state:"); // Title for TreeMap content
		System.out.println(capitals); // Print the new TreeMap to the output console
		System.out.println(); // Blank line to space things out
	}
	
	// Method to insert the HashMap into the binary search tree
	void binarySearchTree(Map<String, String> map) { // Declares the method with the HashMap as an input parameter
		Tree binaryTree = new Tree(); // Creates an instance of the "Tree" class so that the "Tree" functions can be accessed
		
		// Insert nodes into the binary search tree
		for(Entry<String, String> i : map.entrySet()) { // "for" loop to go over the entire TreeMap
			binaryTree.insert(i.getKey()); // Insert the TreeMap key into a new node on the binary search tree
		}
		
		// Find nodes in the binary search tree
		Scanner scanner = new Scanner(System.in); // Creates an instance of the imported "Scanner" utility with user input as a parameter
		boolean end = false; // Boolean value to determine when to end the method
		while (end == false) { // "while" loop to continue the following code until "end" == true
			System.out.println("Enter the state you want to search the binary tree for (Type 'STOP' to move on): "); // Prints user prompt
			String key = scanner.nextLine(); // Takes the user's input and stores it in the "key" variable
			Tree.Node node = binaryTree.find(key); // Calls the "find" function on the binary tree using the "key" variable
		
			if(key.equals("STOP")) { // If the user enters the request to end this method...
				System.out.println("Moving on..."); // Print a "moving on" message to the console
				System.out.println(); // Blank line to space things out
				end = true; // Terminate the "while" loop
			} else if(node == null) { // Else if the node does not exist in the binary tree...
				System.out.println("ERROR: Node '" + key + "' does not exist on the binary tree. Please try again."); // Print error message
				System.out.println(); // Blank line to space things out
			} else { // Else (i.e., the node IS on the binary tree)...
				System.out.println("Success! Node '" + node.data + "' was found on the binary tree."); // Print success message
				System.out.println(); // Blank line to space things out
			}
		}
	}
	
	// Method to prompt the user to enter a state name and receive a capital name in return
	void enterState(Map<String, String> map) { // Declares the method with the HashMap as an input parameter
		Scanner scanner = new Scanner(System.in); // Creates an instance of the imported "Scanner" utility with user input as a parameter
		boolean end = false; // Boolean value to determine when to end the method
		while(end == false) { // "while" loop to continue the following code until "end" == true
			System.out.println("Which state would you like to know the capital of? (Type 'STOP' to quit)"); // Prints prompt to the user
			String request = scanner.nextLine(); // Takes the user's input and stores it in the "request" variable
			
			
			if(request.equals("STOP")) { // If the user enters the request to quit the program...
				System.out.println("Goodbye"); // Print a goodbye message to the output console
				end = true; // Terminate the "while" loop
			} else if(map.containsKey(request)) { // Else if the map contains the state requested by the user (case-sensitive)...
				System.out.println("The capital of " + request + " is " + map.get(request) + "."); // Print the result to the output console
				System.out.println(); // Blank line to space things out
			} else { // Else (i.e., the user enters an incorrect state name)...
				System.out.println("Oops. You must've made a typo. Let's try that again..."); // Print an error message to the output console
				System.out.println(); // Blank line to space things out
			}
		}
	}
	
	// "main" method; all previous methods are called into action here
	public static void main(String[] args) {
		Maps main = new Maps(); // Creates an instance of the "Maps" class so that the HashMap and methods can be accessed
		
		// Fill the map with the state and capital data
		main.fillMap(main.capitals); // Calls the "fillMap" method on the "capitals" HashMap
		
		// Convert the HashMap to a sorted TreeMap
		main.sortMap(main.capitals); // Calls the "sortMap" method on the "capitals" HashMap
		
		// Make a binary search tree for the TreeMap
		main.binarySearchTree(main.capitals); // Calls the "binarySearchTree" method on the "capitals" TreeMap
				
		// Call the "enterState" method to request a state from the user and return a capital
		main.enterState(main.capitals); // Calls the "enterState" method on the "capitals" TreeMap
	}
}