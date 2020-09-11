package exception;
import java.io.*;
public class StudentGradingException extends Exception {
	private int errorNo;
	private String logException;
	
	public StudentGradingException()
	{
		super();
		printProblem();
	}
	
	public StudentGradingException(String msg, String exception,int count)
	{
		super();
		this.logException=msg;
		this.errorNo = count;
		fixProblem(msg,count);
		logException(exception);
	}
	
//	public StudentGradingException(int no)
//	{
//		super();
//		this.errorNo=no;
//		printProblem();
//	}
//	
//	public StudentGradingException(int no, String msg)
//	{
//		super();
//		this.logException=msg;
//		this.errorNo=no;
//		printProblem();
//	}
	
/***********GETTER***********/
	public int getErrorNo() {
		return errorNo;
	}

	public String getLogException() {
		return logException;
	}

/***********SETTER***********/
	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public void setLogException(String errorMsg) {
		this.logException = errorMsg;
	}


	public void printProblem()
	{
		System.out.println("StudentGradingException ");
	}
	
	public void logException(String exception) //throws StudentGradingException
	{		
		try 
		{
			FileWriter a1 = new FileWriter("Logging.txt", true);
			BufferedWriter buff = new BufferedWriter(a1);
			buff.write(exception);
			buff.newLine();
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error -- " + e.toString());
		}
	}
	
	public void fixProblem(String msg, int count)
	{
		System.out.println("You are missing at least 1 quizz for student "+count);
	}
}
