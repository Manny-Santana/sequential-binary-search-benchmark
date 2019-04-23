package sortAlgorithms;

public class IntQuickSort {


	
	/**
	 * public method that calls a quicksort method
	 * only accepts 1 argument of an int array
	 * @param array what you want to sort out
	 */
public static void quickSort(int[] array) {
		
		doQuickSort(array, 0, array.length - 1);
	}
/**
 * swaps the second argument with the 3rd argument
 * @param array desgnated array	
 * @param a first variable to swap with b
 * @param b replacement variable
 */
private static void swap(int[] array, int a, int b) {
	
	int temp;
	//store value of index a in memory
	temp = array[a];
	
	//swap in value of index b
	//this erases index a and replaces it with value  of index b
	array[a] = array[b];
	
	//replace the value of index b with the value of the stored value of index a
	array[b] = temp;
	
	}


private static int partition(int[] array, int start, int end) {
	
	int pivotValue; //pivot value
	int endOfLeftList; //Last element in the left sublist
	int mid; //holds index of the midpoint
	
	//Find subscript of the middle element.
	// This is also going to be the starting pivot value
	mid = (start + end) / 2;
	
	
	//swap middle element with the first element
	//which will be our pivot value
	//pivot will be at the beginning of the list
	swap(array, start, mid);
	
	//store the first variable as the pivot for comparisons
	pivotValue = array[start];
	
	//initialize the endOfLeftList as the first value
	// the only item in the left sub list will be the pivot value for now
	// this value will increase as the size of the left sublist increases
	// this way the endOfLeftList variable will always indicate the final element
	// of the left sublist array.
	
	endOfLeftList = start;
	
	//scan the entire list and move any values that
	//are less than the pivot value to the left
	//sublist.
	// scan + 1 - because the first value is the pivot (not to be compared)
	
	for(int scan = start +1; scan <= end; scan++) {
		
		if(array[scan] < pivotValue) {
			
			endOfLeftList++;
			swap(array, endOfLeftList, scan);
		}
	}
	
	
	//Move pivot to the end of the left sublist
	swap(array, start, endOfLeftList);
	
	
	return endOfLeftList;
}
private static void doQuickSort(int[] array, int start, int end) {
	
	int pivotPoint;
	
	if (start < end) {
		
		//get pivotPoint
		pivotPoint = partition(array, start, end);
		
		//Sort the first sublist by comparing all items in each sublist
		// to each number to the left of each pivot point ( last index of each sublist) 
		doQuickSort(array, start, pivotPoint - 1);
		
		//Sort the second sublist ( same as first except 
		doQuickSort(array, pivotPoint + 1, end);
		
	}
	
	
}





}