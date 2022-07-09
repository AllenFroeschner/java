package project3;

import java.util.Scanner;

//had to rewrite this last second because i read the instructions wrong so it isnt the most organized code 
public class driver {

	private static Node<Integer> ArrToLL(Node<Integer> head,Node<Integer> cursor,int[] t) {
		for (int i =0; i<t.length; i++) {
			if(t[i]%2==0) {
				head.setNext(new Node<Integer>(t[i], head.getNext()));
				
			}
			else {
				cursor.setNext(new Node<Integer>(t[i], cursor.getNext()));

				cursor = cursor.getNext();
			}
		}
		cursor = head;
		while (cursor.getNext()!=null) {
			System.out.print(cursor.getNext().getValue()+" -> ");
			cursor = cursor.getNext();
		}
		System.out.print("null\n");
		return head.getNext();
	}
	
	private static void shiftList(Node<Integer> h,Node<Integer> c, int t,int[] g) {
		int[] arr= new int[t];
		if(t>g.length-1 ||t<1) {
			System.err.println("please enter a valid number");
			Scanner eh = new Scanner(System.in);
			System.out.println("input number:");
			t=eh.nextInt();
			shiftList(h,c,t,g);
		}
		for(int i=0; i<t; i++) {
			arr[i]=h.getNext().getValue();
			if(h.getNext() != null)
		    {
			h.setNext(h.getNext().getNext());

		    }
		}
		while (c.getNext()!=null) {
			c = c.getNext();
		}
		for(int i=0; i<t; i++) {
			c.setNext(new Node<Integer>(arr[i], c.getNext()));

			c = c.getNext();
		}
		
	}
	
	public static void main (String[] args) {
		String s="";
		int[] arr;
		int a=0; 
		Node<Integer> head=new Node(0,null), cursor=head;
		Scanner eh = new Scanner(System.in);
		System.out.println("would you like to use the default test array?(y or yes, not case sensitive)");
		s=eh.nextLine();
		if(s.toLowerCase().equals("y")||s.toLowerCase().equals("yes")) {
			int[] ar= {1,0,4,6,7,9,2,10,11,14,13,19,20};
			arr= ar;
			ArrToLL(head,cursor,arr);
		}
		else {
		System.out.println("input length for array:");
		a=eh.nextInt();
		arr= new int[a];
		a=0;
		System.out.println("input each number separated by a space or new line:");
		while(a<arr.length) {
		arr[a]=	eh.nextInt();
		a++;
		}
		ArrToLL(head,cursor,arr);
		}
		//1 0 4 6 7 9 2 10 11 14 13 19 20

		System.out.println("input number:");
		a=eh.nextInt();
		shiftList(head,cursor,a,arr);
		cursor = head;
		while (cursor.getNext()!=null) {
			System.out.print(cursor.getNext().getValue()+" -> ");
			cursor = cursor.getNext();
		}
		System.out.print("null\n");
	}
}
