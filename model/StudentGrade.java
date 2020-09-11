package model;

import java.io.Serializable;

public class StudentGrade  implements Serializable {
	private Student stu;
	private Statistics stat;
	
	public StudentGrade() {}
	
	public Student getStu() {
		return stu;
	}
	public Statistics getStat() {
		return stat;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public void setStat(Statistics stat) {
		this.stat = stat;
	}
	
	public void print(int i)
	{
		System.out.printf("Student's infomation : ");
		this.stu.print();
		System.out.printf("Statistics :");
		this.stat.print(i);
	}
}
