package school;

//record score(String color, char size) {}
//Record Type is specialized version and similar to a class.a new feature introduced in java 16
public class score {
	int sno;
	String name;
	int chin;
	int math;
	int sum;
	score(int sno,String name,int chin,int math)
	{
		this.sno=sno;
		this.name=name;
		this.chin=chin;
		this.math=math;
		this.sum=chin+math;
	}
	score(int sno,String name)
	{
		//call complete constructor
		this(sno, name,0,0);  
		//this.sno=sno;
		//this.name=name;
	} 
}