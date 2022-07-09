package norm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class proj {
	
	private double[] money;
	private int people;
	public proj(int pe, double[] mo) {
		people=pe;
		money= mo;
	}
	public double setMoney(int j,double i) {
		this.money[j]=i;
		return this.money[j];
		
	}
	public double getMoney(int j) {
		return this.money[j];
		
	}
	public int setPeople(int p) {
		this.people=p;
		return this.people;
		
	}
	public int getPeople() {
		return this.people;
		
	}
}