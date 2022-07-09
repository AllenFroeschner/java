package student;

import java.util.Scanner;

public class Student {
	//keep the instance variables private so they cannot be inherited 
	private String name;
	private double GPA;
	private int ID;
	public Student(String name, double GPA, int ID) {
		name="";
		GPA=0.0;
		ID=0;
	}
	
	private double getGPA() {
		return this.GPA;
	}
	
	private double setGPA(double gpa) {
		this.GPA=gpa;
		return this.GPA;
	}
	
	private void compGPA(double gpa1, double gpa2) {
		if(gpa1>gpa2) {
			System.out.println("student 1 has  a better gpa");	
		}
		else if(gpa1==gpa2) {
			System.out.println("they both have the same gpa");	
		}
		else System.out.println("student 2 has  a better gpa");;
	}
	
	public static void main (String []args) {
		//create variables for student object
		double gpa=0.0;
		String name="name";
		int ID=123;
		//create students 
		Student s1= new Student(name,gpa,ID);
		Student s2= new Student(name,gpa,ID);
		
		//input gpa for both students by calling setGPA() for both objects
		Scanner eh = new Scanner(System.in);
		System.out.println("imput student gpa:");
		gpa=eh.nextDouble();
		s1.setGPA(gpa);
		System.out.println("imput student 2 gpa:");
		gpa=eh.nextDouble();
		s2.setGPA(gpa);
		s1.compGPA(s1.getGPA(),s2.getGPA());
	}
}
