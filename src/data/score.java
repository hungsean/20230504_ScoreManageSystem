package data;

public class Score {
	String name;
	int chineseScore;
	int mathScore;
	int sum;
	float avg;
	public Score(String name,int chineseScore,int mathScore)
	{
		this.name = name;
		this.chineseScore = chineseScore;
		this.mathScore = mathScore;
		update();
	}
	public Score(int studentNumber,String name)
	{
		//call complete constructor
		this(name,0,0);
		//this.name=name;
	} 

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setChineseScore(int chineseScore) 
	{
		this.chineseScore = chineseScore;
		update();
	}

	public void setMathScore(int mathScore) 
	{
		this.mathScore = mathScore;
		update();
	}

	public String getName() 
	{
		return name;
	}

	public int getChineseScore() 
	{
		return chineseScore;
	}

	public int getMathScore() 
	{
		return mathScore;
	}

	public int getSum() 
	{
		return sum;
	}

	public float getAvg() 
	{
		return avg;
	}

	private void update()
	{
		updateSum();
		updateAvg();
		
	}

	private void updateSum() 
	{
		this.sum = this.chineseScore + this.mathScore;
	}

	void updateAvg() 
	{
		this.avg = (float)(this.sum) / (float)2;
	}




}