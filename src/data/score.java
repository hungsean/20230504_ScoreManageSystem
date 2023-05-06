package data;

public class Score {
	String name;
	int chineseScore;
	int mathScore;
	int sum;
	float avg;
	int chineseRank;
	int mathRank;
	int avgRank;
	
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

	public int getChineseRank() 
	{
		return chineseRank;
	}

	public int getMathRank() 
	{
		return mathRank;
	}

	public int getAvgRank() 
	{
		return avgRank;
	}


	private void update()
	{
		updateSum();
		updateAvg();
		updateRank();
	}

	private void updateSum() 
	{
		this.sum = this.chineseScore + this.mathScore;
	}

	private void updateAvg() 
	{
		this.avg = (float)(this.sum) / (float)2;
	}

	private void updateRank()
	{
		this.chineseRank = rank(this.chineseScore);
		this.mathRank = rank(this.mathScore);
		this.avgRank = rank(this.avg);
	}


	public int rank(float score)
	{
		score -= 50;
		if (score < 0)
			return 0;
		return (int)(score / 10);
	}

	public int rank(int score)
	{
		score -= 50;
		if (score < 0)
			return 0;
		return score / 10;
	}



}