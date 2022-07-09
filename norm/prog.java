package norm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prog {


	private static void readShelterInfo(proj[] a, String file) throws InterruptedException {
		int i = 0;
		int buldings =0;
		int peopl=0;
		
		try {
			Scanner scanner = new Scanner(new File(file));
			buldings=scanner.nextInt();
			System.out.println("number of buildings: "+buldings);
			int p=1;
		while( p<=buldings) {
			peopl=scanner.nextInt();
			delay();
			System.out.println("number of people: "+peopl);
			double[] money= new double[peopl+1];
			int j=0;
			while(j<peopl)
		{
			money[j]=scanner.nextDouble();
		     j++;
		}
			a[i]= new proj(peopl, money);
			//*
			Sort(money);
			computeMinMoney(a[i]);
			System.out.println("final ammount each person has: ");
			for(int h=0; h<peopl; h++) {
			System.out.print(a[i].getMoney(h)+", ");
			}
			i++;
			p++;
		}
		     
		    } catch (FileNotFoundException e) {
		      System.out.println("um..\n\nthis is awkward. \n\nplease make sure the file name is correct");
		      
		      System.exit(0);
		    }
	}
	private static void computeMinMoney(proj b) throws InterruptedException {
		double total=0,shouldHave=0,temp1=0,temp2=0;
		//gets total ammount of money and then finds the average
		for(int i=0; i<b.getPeople(); i++) {
			total+=b.getMoney(i);
		}
		shouldHave=total/b.getPeople();
		total=0;
		System.out.println("\n\neach person should have: $"+ shouldHave);
		int n=b.getPeople()-1;
		//sets everyones money to the average amount or lower and then takes the money remaining and gives it to the people with
		//less than the average
		for( ;n>0; n--) {
			if(b.getMoney(n)>shouldHave) {
				temp1=b.getMoney(n)-shouldHave;
				b.setMoney(n,b.getMoney(n)-temp1);
				temp2+=temp1;
				total+=temp1;
			}
			else if(b.getMoney(n)<shouldHave) {
				temp1=b.getMoney(n)-shouldHave;
				temp2+=temp1;
				b.setMoney(n,b.getMoney(n)-temp1);
			}
			
		}
		//sometimes this prints after this method has ran and
		//i have no clue as to why
		System.err.println("total money that changed hands: "+total);
		b.setMoney(0,b.getMoney(n)+temp2);		
	}
	//*not needed but i decided to use it because it makes me feel less like i'm looking at a computer spitting out data quickly 
	//feels more like i'm looking at a computer spitting out data quickly, but slower... 
	private static void delay() throws InterruptedException {
		final int delay= 100, max=20;
		System.out.print("\n");
		for(int i=0;max>=i; i++) {
			System.out.print("~");
			Thread.currentThread();
			Thread.sleep(delay);
		}
		System.out.print("\n");
	}
	//*also not needed but i decided to use it just because
	private static void Sort(double arr[])
    {
        int n = arr.length-1;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        System.out.println("sorted list of money from file: ");
        for(int j=0; j<arr.length-1; j++) {
        	System.out.print(arr[j]+", ");
        }
    }
	//completely forgot about this just started printing where i wanted...
	public void printMoneyExchanged() {
		
	}
	public static void main(String [] args) throws InterruptedException{
		proj[] h1=new proj[20];
		String file1;
		Scanner eh = new Scanner(System.in);
		System.out.println("input file name without .txt");
		file1=eh.nextLine()+".txt";
		readShelterInfo(h1,file1);
	}
}
