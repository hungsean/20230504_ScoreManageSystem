package school;

import java.io.*;
import java.util.*;

public class score_MS1 {

	static int sno []={101,103,110,111,123};
	static String name []={"cow","dog","eagle","fox","goat"};
	static int chin []={80,90,76,88,54};
	static int math []={55,68,65,89,44};
	public static void main(String[] args) //throws Exception
	{
		String instruct="";
		Scanner in1 = new Scanner(System.in);
		try {
			score classsc []= new score[5];
			for(int i=0;i<=4;i++) System.out.println(classsc [i]);//value of reference==null
			//input1(classsc);
			input2(classsc);
			output1(classsc, 4);
			//System.out.print("input command to handle: "); 
			//instruct=in1.nextLine();
			while (!instruct.equals("end"))

			for(int i=0;i<=4;i++) {
				System.out.print(classsc[i].sno+",");
				System.out.print(classsc[i].name+",");
				System.out.print(classsc[i].chin+",");
				System.out.print(classsc[i].math+",");
				System.out.println(classsc[i].sum);  
			}
		}
		catch (Exception e) 
		{   }
	}
	static void input1(score classsc [])
	{
		for(int i=0;i<=4;i++) 
		classsc[i]= new score(sno[i],name[i],chin[i],math[i]);
	}

	static void input2(score classsc [])
	{
		try 
		{
			File sourceF = new File("test2.txt"); 
			Scanner input = new Scanner(sourceF);
			int sno, chin, math;
			String name;
			int i=0;
			//for(int i=0;i<=4;i++) {
			while (input.hasNextLine())
			{
				sno= input.nextInt();
				name = input.next();
				chin = input.nextInt();
				math = input.nextInt();
				if (i<=3) input.nextLine();
				classsc[i]= new score(sno,name,chin,math);//array of object
				System.out.print(classsc[i].sno+","); 
				i++;
			}
		input.close(); 
		}//try
		catch (FileNotFoundException e) {  }

	}

	static void output1(score classsc [], int n)
	{
		for(int i=0;i<=n;i++) 
		{
			System.out.print(classsc[i].sno+",");
			System.out.print(classsc[i].name+",");
			System.out.print(classsc[i].chin+",");
			System.out.print(classsc[i].math+",");
			System.out.println(classsc[i].sum);  }
		for(int i=0;i<=4;i++) 
			System.out.println(classsc[i]);//reference 
	}//output1
}