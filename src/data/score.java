package data;

public class score {
	int studentNumber;
	String name;
	int chineseScore;
	int mathScore;
	int sum;
	int avg;
	score(int studentNumber,String name,int chineseScore,int mathScore)
	{
		this.studentNumber = studentNumber;
		this.name = name;
		this.chineseScore = chineseScore;
		this.mathScore = mathScore;
		this.sum = chineseScore + mathScore;
		this.avg = sum / 2;
	}
	score(int studentNumber,String name)
	{
		//call complete constructor
		this(studentNumber, name,0,0);  
		//this.sno=sno;
		//this.name=name;
	} 
}