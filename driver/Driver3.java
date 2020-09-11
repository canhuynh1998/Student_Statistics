package driver;
import adapter.*;
import model.Student;

public class Driver3 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAPI a1 = new SAPI();
		a1.printStudentGrade(1234);
		a1.printStudentGrade(6999);
		
		a1.printStatistic();
		a1.printStudentGrade(1312);
	}

}
