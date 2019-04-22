import java.util.Random;
import java.util.Scanner;

public class SearchBenchmark {

	public static void main(String[] args) {
		
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
		sc.close();
		
		int sequentialSearch = seqSearch(myArray, searchNum);
		if (sequentialSearch == -1) {
			System.out.println("Your Value was not found, try again");
		}
		
		
		
		

	}
 
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
					System.out.println("Has been found at index: " + position);
					System.out.println("It took " + comparisonCount + 
							" Comparisons to find the search value.");
				
			} else {
				index ++;
				comparisonCount ++;
			} 

		} // end while loop
		return position;
		
	} 
}
