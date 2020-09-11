package adapter;

public class SAPI extends StudentAPIImpl {

	public SAPI() {}
	@Override
	public void printStudentGrade(int sid) {
		// TODO Auto-generated method stub
		System.out.printf("Score of Student "+sid+" :");
		super.printStudentScore(sid);
	}

	@Override
	public void printStatistic() {
		// TODO Auto-generated method stub
		System.out.printf("Statistic for this class : \n");
		super.printStatistics();
	}

}
