package taxes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class houses {

	private void readFile(int [] house1, String file) {
		int i = 0;
		
		try {
			Scanner scanner = new Scanner(new File(file));
			while(scanner.hasNextInt())
		{
		     house1[i++] = scanner.nextInt();
		}
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("um..\n\nthis is awkward. \n\nplease make sure the file name is correct");
		      //e.printStackTrace();
		      System.exit(0);
		    }
	}
	//adds all numbers in array and compares the total values
	private void tax(int[] house1,int [] house2) {
		int one=0,two=0;
		for(int i=0; i<60; i++) {
			one+=house1[i]; two+=house2[i];
		}
		System.out.println("\nyour first house is $"+one+", your second house is $"+two);
		if(one>two) {
			System.out.println("\nyou will pay $"+one);
		}
		else 
			System.out.println("\nyou will pay $"+two);
			
	}
	
	public static void main(String [] args) throws InterruptedException{
		int[] house_1= new int [60], house_2= new int [60];
		final int delay= 100, max=20;
		Scanner eh = new Scanner(System.in);
		String file1, file2;
		System.out.println("imput file name for first house taxes");
		file1=eh.nextLine()+".txt";
		System.out.println("using "+file1+"\nimput file name for second house taxes");
		file2=eh.nextLine()+".txt";
		System.out.println("using "+file2);
		for(int i=0;max>=i; i++) {
			System.out.print("~");
			Thread.currentThread().sleep(delay);
		}
		
		
		
		//TimeUnit.SECONDS.sleep(2);
		houses h1=new houses();
		h1.readFile(house_1, file1);
		h1.readFile(house_2, file2);
		h1.tax(house_1,house_2);
		}
	
}
