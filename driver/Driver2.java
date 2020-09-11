package driver;
import model.*;
import util.*;
import exception.*;
public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Student []a = new Student[40];
			a=Util.readFile("InputFile.txt",a);			//read the file and put into the Student array.
			Statistics statB = new Statistics();
			statB.findLow(a);
			statB.findHigh(a);
			statB.findAvg(a);
			StudentGrade[] b = buildStudGradArray( a, statB);		//build a StudentGrade array.
			Util.serializeGrades(b);	
			int i = 0;
			while(b[i]!= null)
			{
				Util.deserializeGrades(b[i].getStu().getSID());		//from disk write to screen
				System.out.println();
				i++;
			}
		}catch(StudentGradingException e)
		{
			System.out.println(e.toString());
		}
	}
	
//buildStudGradArray function()
//take the Student array and Statistics variable
//to create a StudentGrade array.
	public static StudentGrade [] buildStudGradArray(Student [] a, Statistics statB)
	{
		StudentGrade[] arr = new StudentGrade[a.length];
		int i = 0;
		while(a[i]!=null)
		{
			arr[i]= new StudentGrade();
			arr[i].setStat(statB);
			arr[i].setStu(a[i]);
			i++;
		}

		return arr;
	}
}
