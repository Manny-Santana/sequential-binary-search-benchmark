import java.util.Random;
import java.util.Scanner;

import sortAlgorithms.IntQuickSort;

public class SearchBenchmark {

	public static void main(String[] args) {
		
		//TODO create a quicksort class to use to sort the array before binary search
		
		//initialize int array with 50 items
		int[] myArray;
		myArray = new int[50];
		
		 
		//insert random integers into the array
			
		for(int i=0; i < 50; i++ ) {
			Random rand = new Random();
			int num = rand.nextInt(50 );
			num +=1;
		myArray[i] = num;

		}
		
		// Print the items of the array
		for(int k = 0; k < myArray.length; k ++) {
		System.out.println(" index " + k + ": " + myArray[k]);
		}
		
		//initialize scanner for user input
		Scanner sc = new Scanner(System.in);
		
		//request input from user
		System.out.println("Please Enter a value to search for: ");
		int searchNum = sc.nextInt(); //Your Search Value here <--
		
		
		int sequentialSearch = seqSearch(myArray, searchNum);
		if (sequentialSearch == -1) {
			System.out.println("Your Value was not found, try again");
		}
		
		int binarySearch = search(myArray, searchNum);
		
		// Print the items of the array
				for(int k = 0; k < myArray.length; k ++) {
				System.out.println(" index " + k + ": " + myArray[k]);
				}
				
				System.out.println(binarySearch);
				
				
		sc.close();

	}
 
	/* uses a sequential search algorithm on an unordered array
	 * @param int[] array indicates the array you would like to find a value in
	 * @param int searchValue indicates the value to search for in the array
	 * also counts the number of comparisons
	 */
	public static int seqSearch(int[] array, int searchValue) {
		
		boolean found  = false;
		int position = -1;
		int index = 0;
		int comparisonCount = 0;
		
		// search the array
		while(found == false && index < array.length) {
			if(array[index] == searchValue) {
				comparisonCount ++;
				position = index;
				found = true;
					System.out.println("Your search value: " + searchValue );
					System.out.println("Has been found using sequential search at index: " + position);
					System.out.println("It took " + comparisonCount + 
							" Comparisons to find the search value.");
				
			} else {
				index ++;
				comparisonCount ++;
			} 

		} // end while loop
		return position;
		
	}
	/** calls a recursive Binary search algorithm to checked the passed array
	 * 
	 * @param array array you want to search 
	 * @param value value you want to search for
	 * @return
	 */
	
	public static int search(int[] array, int value) {
		
		return binSearch(array, 0, array.length-1, value, 0);
		
	}
	
	/** Binary Search algorithm the ability to count the comparisons
	 * 
	 * @param array searched array
	 * @param first first element of search area/array
	 * @param last last element of search area/array
	 * @param searchValue value to be found
	 * @return
	 */
	public static int binSearch(int[] array , int first , int last , int searchValue, int cmp) {
		
		IntQuickSort.quickSort(array);
		int middle; // middle point defined as (first + last) /2
		int comparisons = cmp; // count comparisons
		int result;
		
		//base case
		//value not found
		if(first>last) {
			
			System.out.println("That number is not in the list, try again.");
			System.out.println("It took " + comparisons + " comparisons.");
			
			return -1;
		} // end if
		
		middle = (first + last) / 2;
		
		//Base case if found
		if(array[middle] == searchValue) {
			comparisons++;
			result = middle;
			
			System.out.println("Has been found at index using binary search: " + result);
			System.out.println("It took " + comparisons + " comparisons to find.");
			
			
			return result;
			
			
		}
		// if middle value is greater search lower half 
		// move 
		else if(array[middle] > searchValue) {
			
			
			return binSearch(array, first, middle - 1, searchValue, cmp+1);
			
		}
		
		// if middle is less search upper half
		else {
			
			return binSearch(array, middle + 1, last, searchValue, cmp+1);
			
		}
		
		
		
	
		
		
	}
	
	
}
