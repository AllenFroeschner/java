package finalproject;

import java.util.Scanner;

public class driver {
	
	private static void sortFind(String sortType,int[] arr) {
		switch (sortType.toLowerCase()) {
        	case "quicksort":
        		System.err.println("sorting using quick sort\n");
        		sort.quicksort(arr);
        		break;
        	case "insertionsort":
        		System.err.println("sorting using insertion sort\n");
        		sort.insertionSort(arr);
        		break;
        	case "mergesort":
        		System.err.println("sorting using merge sort\n");
        		sort.mergeSort(arr);
        		break;
        	case "shellsort":
        		System.err.println("sorting using shell sort\n");
        		sort.shellsort(arr);
        		break;
        	default: System.err.println("please enter valid sort");
		}
	}

	public static void main(String [] args) {
		int ind=0, input=0; 
		int[] arr;
		String command ="startsort",sorttype="quicksort";
		Scanner eh = new Scanner(System.in);
		String[] list= {"startSort","quit"};
		boolean quit =false;
		while(quit!=true) {
			System.out.println("input h or help for a list of commands");
			command=eh.nextLine();
			if(command.compareTo("quit")==0) {
			    System.err.println("goodbye");
	        	System.exit(0);
	        	quit=true;
			}
			else if(command.compareTo("h")==0||command.compareTo("help")==0) {
				for(int i=0; i<list.length;i++) {
		        	System.out.println(list[i]);
		        	}
			}
			else if(command.toLowerCase().compareTo("startsort")==0) {
				System.out.println("input sorting routine\n'quickSort','insertionSort','mergeSort','shellSort'");
	        	sorttype=eh.nextLine();
				System.out.println("input length for array:");
	        	input=eh.nextInt();
	    		arr= new int[input];
	    		System.out.println("input each number separated by a space or new line:");
	    		while(ind<arr.length) {
	    		arr[ind]=	eh.nextInt();
	    		ind++;
	    		}
	    		ind=0;
	    		sortFind(sorttype,arr);
			}
		}
	}
}
