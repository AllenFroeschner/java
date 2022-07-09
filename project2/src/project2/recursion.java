package project2;

import java.util.Scanner;

public class recursion {
	
	private static float functOne (int g,float p,int n) {
		if(n<=0) {
			System.out.println("please enter a number greater than zero");
			Scanner eh = new Scanner(System.in);
			System.out.println("input number:");
			n=eh.nextInt();
			functOne(g,p,n);
		}
		else if(g<=n) {
			p+=1.0/(float)g;
			g++;
			return functOne(g,p,n);
		}
		
		return p;

		
	}
	private static void functTwo (int g,float p,int n) {
		if(n<=0) {
			System.out.println("please enter a number greater than zero");
			Scanner eh = new Scanner(System.in);
			System.out.println("input number:");
			n=eh.nextInt();
			functTwo(g,p,n);
		}
		if(p!=n) {
			for(int i=-1; i<p; i++) {
			System.out.print("*");
			}
			System.out.println();
			p++;
			functTwo(g,p,n);
		}
		else if(p==n&&g!=n) {
			for(int i=n; i>g; i--) {
			System.out.print("*");
			}
			System.out.println();
			g++;
			functTwo(g,p,n);
		}
	}
	public static void main (String []args) {
		int num=0, num2=1;
		//float because its 32bit instead of 64bit
		float num1=0;
		Scanner eh = new Scanner(System.in);
		System.out.println("input number:");
		num=eh.nextInt();
		System.out.println(functOne(num2,num1,num));
		num1=num2=0;
		System.out.println("input number:");
		num=eh.nextInt();
		functTwo(num2,num1,num); 
	}
}
