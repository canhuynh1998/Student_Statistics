package driver;
import java.util.*;

import exception.StudentGradingException;
import model.Statistics;
import model.Student;
import util.Util;
public class Driver {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			Student a[] = new Student[40];	
			a = Util.readFile("InputFile.txt", a);
		    Statistics statA= new Statistics();
		    statA.findLow(a);
		    statA.print(0);
		    statA.findHigh(a);
		    statA.findAvg(a);
		    statA.print(1);
		    statA.print(2);
		    statA.print(3);
		    statA.print(4);		
		}catch(StudentGradingException e)
		{
			System.out.println(e.toString());
		}
	   

	}
}
