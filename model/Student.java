package model;

import java.io.Serializable;

public class Student  implements Serializable {
	private int SID;
	private int[] scores;
	
	public Student() {}
	
	public Student(int id)
	{
		this.SID=id;
		this.scores=new int [5];
	}
/***********GETTER***********/
	public int getSID() {
		return SID;
	}

	public int[] getScores() {
		return scores;
	}
	
/***********SETTER**********/
	public void setSID(int sID) {
		SID = sID;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
//printScore() function
//It is used for printing all the score
//of a Student object.
	public void printScore()
	{
		int[] Scores = this.scores;
		for(int i = 0; i<Scores.length;i++)
		{
			System.out.printf(" %3d", Scores[i]);
		}
		System.out.println();
	}
	
//print() function
//It is used for printing all the properties
//of a Student object.
	public void print()
	{
		System.out.printf("Student's ID : %d\n",this.SID);
		System.out.printf("Quizzes' score :");
		printScore();
	}
}
