//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

import java.util.*;

public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = keyboard.nextInt();

		//create an Arraylist of size n
		//The ArrayList holds a LinkedList object 
		//The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
		for (int i=0; i<n; i++)
		{
			hashtable.add(i, new LinkedList<Integer>());
		}


		//Add keys 187, 105, 120, 205, 189 to the appropriate linked list
		//187 will be added to the linked list at index 187%n
		//105 will be added to the linked list at index 105%n
		//etc.

		System.out.println("Enter the number of keys to be hashed: ");
		//asks user for the amount of keys
		int numbersNeeded = keyboard.nextInt();
		//sets the random object
		Random rng = new Random();

		ArrayList<Integer> generated = new ArrayList<>();

		//makes the desired amount of random of numbers and adds them to the list
		while (generated.size() < numbersNeeded) {
			//gets the the random numbers that are less than 10000
			Integer next = rng.nextInt(10000) + 1;

			generated.add(next);


		}


		int size = generated.size();
		int j = 0;
		int collisions = 0;
		int longestLength = 0;
		//only starts if the user selects a table greater than 0
		while (size > 0){
			//gets the index that is of the mod n
			int index = generated.get(j)%n;
			//adds that key to the index
			hashtable.get(index).add(generated.get(j));
			//setting the length to be the hashtables size
			int length = hashtable.get(index).size();
			//gets the largest linked list
			if(length > longestLength){
				longestLength = length;
			}
			//collisions only hapen when there is a numbe already in the linked list so it checks if that is the case
			if(hashtable.get(index).size() > 1){
				collisions++;
			}
			//makes the size smaller until there is nothing left in the list
			size--;
			//goes to the next item in the list
			j++;

		}


		//Display the arraylist of linked lists
		System.out.println();
		System.out.println("After the keys are hashed");

		for (int i=0; i<n; i++)
		{
			System.out.print(i + ": ");
			hashtable.get(i).enumerate();

		}

		System.out.println("\nStatistics:");
		System.out.println("Table size: " + n);
		System.out.println("Number of keys: " + numbersNeeded);
		System.out.println("Load factor: " + numbersNeeded/n);
		System.out.println("Number of collisions: " + collisions);
		System.out.println("Longest list: " + longestLength);


	}
}
			
		
