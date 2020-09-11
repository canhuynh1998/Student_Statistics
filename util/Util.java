package util;

import java.io.*;
import java.util.*;
import model.Student;
import exception.StudentGradingException;
import model.StudentGrade;
public class Util  {

//readFile() function
//read the input file and put the data into an array of object.
	public static Student[] readFile(String fileName, Student[] stu) throws StudentGradingException
	{	
		int i = 0;
		try {
			//int i = 0;	//counting the number of Student object in the input file, each line is 1 Student object.
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			buff.readLine(); 	// skip the first line.
			//check if the next line is null
			//or if number of Student object 
			//is out of bound.
			while(!eof)
			{
				String line = buff.readLine();
				if(i >= stu.length ||  line==null )
				{
					eof=true;
				}
				else 
				{	
					stu[i] = new Student();
					//StringTokenizer is used for taking each token out.
					StringTokenizer token = new StringTokenizer(line); 			
					while(token.hasMoreTokens())
					{
						//int SID == Integer.parseInt(token.nextToken()))
						//Integer.parseInt(token.nextToken())) is an int which is stored in a String
						//Integer.parseInt(token.nextToken())) converts the String into an int
						stu[i].setSID(Integer.parseInt(token.nextToken()));		
						int [] arr = new int[5];	//create an array to store the scores of each Student
						for(int j = 0; j<arr.length;j++)
						{
							arr[j]=(Integer.parseInt(token.nextToken()));
						}						
						stu[i].setScores(arr);		
					}
					i++;
				}		
			}
			
			buff.close();
			return stu;
		}
		catch(NoSuchElementException e)
		{
			throw new StudentGradingException("You are missing one quizz!","NoSuchElementException",stu[i].getSID());
		}
		catch(IOException e)
		{
			throw new StudentGradingException("Can not find the file","IOException",0);
		}
		finally
		{
			
		}
	}
	
//serializeGrades() function
//take the array of object and write each object into disk.
	public static void serializeGrades(StudentGrade [] a) 
	{
		try
		{
			boolean eoa = false;
			int count = 0;
			while (a[count] != null) {
				FileOutputStream file = new FileOutputStream(a[count].getStu().getSID()+".txt");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(a[count]);
				out.close();
				count++;
				}
	
			}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

//deserializeGrades() function
//take the input file name studid and write back into screen.
	public static void deserializeGrades(int studid)
	{
		try
		{
		    FileInputStream infile =	new FileInputStream (studid+".txt");
			ObjectInputStream in = new ObjectInputStream (infile);
			StudentGrade newGrade = (StudentGrade)in.readObject();
			newGrade.print(3);
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(1);
		}
	}
}
