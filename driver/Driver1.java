package driver;
import model.Student;
import exception.StudentGradingException;
import util.Util;

public class Driver1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] a = new Student[40];
		try {
			a=Util.readFile("InputFile.txt", a);
		} catch (StudentGradingException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
	}

}
/*
OUTPUT testing

You are missing at least 1 quizz for student 8026
exception.StudentGradingException
*/