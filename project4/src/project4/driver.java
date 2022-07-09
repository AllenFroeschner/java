package project4;

import java.util.Scanner;

import exceptions.UnderflowException;
//used the listNode and ListStack files from BB i added an underflow exception in its own package
public class driver {
	private static void add(ListStack<Character> List,String b,char act,char[] wrd,int index) throws UnderflowException, InterruptedException {
		System.out.println("add a word or character to the list");
		Scanner eh = new Scanner(System.in);
		b=eh.nextLine();
		for(int i=0; i<b.length();i++) {
			List.push(b.charAt(i));
			index++;
		}
		printList(List,b,act,wrd,index);
	}
	private static void deleteLast(ListStack<Character> List,String b,char act,char[] wrd, int index) throws UnderflowException, InterruptedException {
		System.out.println("do you wish to remove your last action or last word?\n(enter 'action' or 'word')");
		Scanner eh = new Scanner(System.in);
		b=eh.nextLine();
		if(index==0) {
			System.err.println("you cannot remove from an empty list");
			add(List,b,act,wrd,index);
		}
		else if(b.toLowerCase().equals("action")) {
		act=List.top();
		List.pop();
		index--;
		}
		else if(b.toLowerCase().equals("word")) {
			int i=0;
			while(List.top()!=' ') {
			wrd[i]=List.top();
			List.pop();	
			index--;
			i++;
			}
		}	
		else {
			System.err.println("sorry i think you made a mistake");
			deleteLast(List,b,act,wrd,index);
			
		}
		printList(List,b,act,wrd,index);
	}
	private static void undo(ListStack<Character> List,String b,char act,char[] wrd, int index) throws UnderflowException, InterruptedException {
		System.out.println("do you wish to undo your last action or last word?\n(enter 'action' or 'word')");
		Scanner eh = new Scanner(System.in);
		b=eh.nextLine();
		if(b.toLowerCase().equals("action")&& act!='\u0000') {
			List.push(act);
			act='\u0000';
			index++;
		}
		else if(b.toLowerCase().equals("word")&& wrd[0]!='\u0000') {
			int p=1;
			while(wrd[p]!=0) {
				p++;
			}
			List.pop();
			for(int j=p--; j>-1;j--) {
				List.push(wrd[j]);
				wrd[j]='\u0000';
				index++;
			}
		}
		else {
			System.err.println("sorry i think you made a mistake");
		}
		printList(List,b,act,wrd,index);
	}
	private static void printList(ListStack<Character> List,String b,char act,char[] wrd, int index) throws UnderflowException, InterruptedException {
		char[] s=new char[index+1];
		final int delay= 100;
		for(int i=0; i<index; i++) {
			s[i]=List.topAndPop();
		}
		System.out.println("");
		for(int i=index; i>-1; i--) {
			System.out.print(s[i]);
			List.push(s[i]);
			Thread.currentThread();
			Thread.sleep(delay);
		}
		System.out.println("");
		ui(List,b,act,wrd,index);
	}
	private static void ui(ListStack<Character> List,String b,char act,char[] wrd, int index) throws UnderflowException, InterruptedException{
		System.out.println("'add' some word|'delete' or 'undo' the previous word added or the previous action"
				+ "|'redo' a prior undo|'print' the sentence|'quit' to terminate the program");
		 String input="";
		 Scanner eh = new Scanner(System.in);
		 b=eh.nextLine();
		switch (b.toLowerCase()) {
	        case "add": add(List,b,act,wrd,index);
	        break;
	        case "delete": deleteLast(List,b,act,wrd,index);
	        break;
	        case "undo": deleteLast(List,b,act,wrd,index);
	        break;
	        case "redo": undo(List,b,act,wrd,index);
	        break;
	        case "print": printList(List,b,act,wrd,index);
	        break;
	        case "quit": System.err.println("goodbye");
	        System.exit(0);
	        default: System.err.println("sorry i think you made a mistake");
	        ui(List,b,act,wrd,index);
            break;
	        }
	}
	
	public static void main(String[] args) throws UnderflowException, InterruptedException {
		ListStack<Character> list=new ListStack();
		 String input="";
		 int index=0;
		 char action='\u0000';
		 char[] word=new char[20];
		 ui(list,input,action,word,index);
	        
	}
}
