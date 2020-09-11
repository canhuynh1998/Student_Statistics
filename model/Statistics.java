package model;

import java.io.Serializable;

public class Statistics  implements Serializable {
	private int[] lowScore;
	private int[] highScore;
	private float[] avgScore;

	//Constructor
	public Statistics() {
		this.lowScore = new int[5];
		this.highScore = new int[5];
		this.avgScore = new float[5];
	}

	//findLow() function, takes an array of Student
	// findHigh() and findAvg() are similar
	public void findLow(Student[] a) {
		boolean eoa = false;	
		// count is the number of object in the array.
		// counting number of object in the while loop.
		//the while loop stops when count is greater or equal to the length of Student array
		//or when the Student array references NULL.
		int count = 0;
		while (!eoa) {
			if (count >= a.length  || a[count] == null) {
				eoa = true;
			} else {
				count++;
			}
		}
		
		if (count <= 0) {
			System.out.printf("The Student array is empty\n");
		} else {
			// check if number of Student objects is out of bound
			// if it is out of bound, iterate the whole array and ignore those out of bound elements.
			if (count > a.length) {
				count = a.length;
			}
			// i is col, j is row
			// code runs col by col to find the smallest value
			// put the smallest value into the array
			for (int i = 0; i < this.lowScore.length; i++) {
				int min = a[0].getScores()[i];
				for (int j = 0; j < count; j++) {
					if (min > a[j].getScores()[i]) {
						min = a[j].getScores()[i];
					}
				}
				this.lowScore[i] = min;
			}
		}
	}

	//printLow() function
	//It is used for printing the array storing the lowest score for each quizzes.
	public void printLow() {
		int[] low = this.lowScore;
		System.out.printf("Low Score :");
		for (int i = 0; i < this.lowScore.length; i++) {
			System.out.printf(" %d", low[i]);
		}
		System.out.println();
	}

	//findHigh() function
	//Same functionality as findLow()
	public void findHigh(Student[] a) {
		boolean eoa = false;
		int count = 0;
		while (!eoa) {
			if (count >= a.length || a[count] == null) {
				eoa = true;
			} else {
				count++;
			}
		}
		
		if (count <= 0)
		{
			System.out.printf("The Student array is empty\n");
		} else {
			if (count >= a.length) 
			{
				count = a.length;
			}
			for (int i = 0; i < this.lowScore.length; i++) 
			{
				int max = a[0].getScores()[i];
				for (int j = 0; j < count; j++)
				{
					if (max < a[j].getScores()[i]) 
					{
						max = a[j].getScores()[i];
					}
				}
				this.highScore[i] = max;
			}
		}
	}

	//printHigh() function
	//Same functionality as printLow() function.
	public void printHigh() {
		int[] high = this.highScore;
		System.out.printf("High Score :");
		for (int i = 0; i < this.highScore.length; i++) {
			System.out.printf(" %d", high[i]);
		}
		System.out.println();
	}

	//findAvg() function
	//Similar functionality as findLow()
	//It is finding the average score for each quizzes.
	public void findAvg(Student[] a) {
		boolean eoa = false;
		int count = 0;
		while (!eoa) 
		{
			if (count >= a.length || a[count] == null) 
			{
				eoa = true;
			} else 
			{
				count++;
			}
		}
		if (count <= 0)
		{
			System.out.printf("The Student array is empty\n");
		} else {
			if (count >= a.length) 
			{
				count = a.length;
			}
			for (int i = 0; i < this.lowScore.length; i++)
			{
				float sum = 0.0f;
				for (int j = 0; j < count; j++) 
				{
					sum += a[j].getScores()[i];
				}
				sum /= count;
				this.avgScore[i] = sum;
			}
		}
	}

	//printAvg() function
	//Same functionality as printLow()
	public void printAvg() {
		float[] avgArr = this.avgScore;
		System.out.printf("Average Score :");
		for (int i = 0; i < this.avgScore.length; i++) {
			System.out.printf(" %3.2f", avgArr[i]);
		}
		System.out.println();
	}

	//print() function
	//It takes an int i as a parameter
	//so that it can call other functions
	public void print(int i) {
		if (i == 0) {
			printLow();
		} else if (i == 1) {
			printHigh();
		} else if (i == 2) {
			printAvg();
		} else if (i == 3) {
			printLow();
			printHigh();
			printAvg();
		} else {
			System.out.printf("Input Error\n");
		}
	}
}
