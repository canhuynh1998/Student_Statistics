package adapter;
import model.*;
import util.*;
import java.io.*;
import exception.*;
public abstract class StudentAPIImpl implements StudentAPI {
	public StudentAPIImpl()
	{
		try
		{
			Student []a = new Student[40];
			a=Util.readFile("InputFile.txt",a);			//read the file and put into the Student array.
			Statistics statB = new Statistics();
			statB.findLow(a);
			statB.findHigh(a);
			statB.findAvg(a);
			StudentGrade []stuGrade = new StudentGrade[a.length];
			int i = 0;
			while(a[i]!=null)
			{
				stuGrade[i] = new StudentGrade();
				stuGrade[i].setStu(a[i]);
				stuGrade[i].setStat(statB);
				i++;
			}
			Util.serializeGrades(stuGrade); 
		}catch(StudentGradingException e) {
			System.out.println(e.toString());
		}
	}
	
	public void printStudentScore(int sid)
	{
		try
		{
			FileInputStream infile =	new FileInputStream (sid+".txt");
			ObjectInputStream in = new ObjectInputStream (infile);
			StudentGrade newStuGrade = (StudentGrade)in.readObject();
			newStuGrade.getStu().printScore();
		}catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(1);
		}
	}
	
	public void printStatistics()
	{
		try
		{
			FileInputStream infile =	new FileInputStream ("1234.txt");
			ObjectInputStream in = new ObjectInputStream (infile);
			StudentGrade newStuGrade = (StudentGrade)in.readObject();
			newStuGrade.getStat().print(3);
		}catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
