package project5;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

import nonstandard.ItemNotFoundException;

public class driver {
	

	public static void main(String[] args) {
		BinarySearchTree boop = new BinarySearchTree<Integer>();
		Integer beep =0, ind=0, input=0; 
		Integer[] arr= new Integer[20];
		String bop ="", prefix="";
		String[] list= {"add or insert: adds a number to the tree", "delete: removes a number", "deleteMin: removes smallest number",
    			"find: finds number", "findMin: finds smallest number","findMax: finds largest number","makeEmpty: makes tree empty",
    			"isEmpty: shows if tree is empty","findKth: finds the K-th smallest value"};
		boolean quit =false;
		 Scanner eh = new Scanner(System.in);
		 //System.out.println("I emailed you about assignment 4 on sunday but never got a reply.\nI left a .txt with a copy of what i said in the email pls take a look.\n");
		while(quit!=true) {
		System.out.println("input h or help for a list of commands");
		bop=eh.nextLine();
		switch (bop.toLowerCase()) {
	        case "add","insert": 
	        	System.out.println("input ammount of numbers to add(up to 20 at a time):");
	        	beep=eh.nextInt();
	        	while(ind<beep) {
	        	input=eh.nextInt();
	        	boop.insert(input);
	        	ind++;
	        	}
	        	//boop.printTree(boop.root,prefix);
	        break;
	        case "delete": 
	        	System.out.println("what number?");
	        	beep=eh.nextInt();
	        	boop.remove(beep);
	        break;
	        case "deletemin": 
	        	boop.removeMin();
	        break;
	        case "find": 
	        	System.out.println("what number?");
	        	beep=eh.nextInt();
	        	input=0;
	        	boop.find(beep,input);
	        	
	        break;
	        case "findmin": 
	        	boop.findMin();
	        break;
	        case "findmax": 
	        	boop.findMax();
	        break;
	        case "makeempty": 
	        	boop.makeEmpty();
	        break;
	        case "isempty": 
	        	System.out.println(boop.isEmpty());
	        break;
	        case "findkth": 
	        	System.out.println("what number?");
	        	beep=eh.nextInt();
	        	System.out.println("the K-th smallest value is: "+boop.findKth(beep));
	        break;
	        case "help","h": 
	        	for(int i=0; i<list.length; i++) {
	        		System.out.println(list[i]);
	        	}
	        System.out.println();
	        break;
	        case "print": boop.printTree(boop.root,prefix);
	        break;
	        case "quit": System.err.println("goodbye");
	        quit=true;
	        default: boop.printTree(boop.root,prefix);
            break;
	        }
		 }
		System.exit(0);
	}
}