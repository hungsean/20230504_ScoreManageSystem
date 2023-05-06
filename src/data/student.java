package data;

import java.io.File;
import java.util.*;

public class Student {

    Map<Integer, Score> studentMap = new HashMap<Integer, Score>();
    
    float chineseSum = 0;
    float mathSum = 0;
    float chineseAvg = 0;
    float mathAvg = 0;
    float chineseSD = 0;
    float mathSD = 0;
    
    public void addStudent(int studentNumber, Score score) 
    {
        studentMap.put(studentNumber, score);
        update();
    }

    public void removeStudent(int studentNumber) 
    {
        studentMap.remove(studentNumber);
        update();
    }

    public void updateStudent(int studentNumber, Score score) 
    {
        studentMap.put(studentNumber, score);
        update();
    }

    public void update()
    {
        updateSum();
        updateAvg();
        updateSD();

    }

    public void updateSum()
    {
        float chineseSum = 0;
        float mathSum = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            chineseSum += score.getChineseScore();
            mathSum += score.getMathScore();
        }
        this.chineseSum = chineseSum;
        this.mathSum = mathSum;
    }

    public void updateAvg()
    {
        float chineseAvg = chineseSum / studentMap.size();
        float mathAvg = mathSum / studentMap.size();
        this.chineseAvg = chineseAvg;
        this.mathAvg = mathAvg;
    }

    public void updateSD()
    {
        float chineseSD = 0;
        float mathSD = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            chineseSD += Math.pow(score.getChineseScore() - chineseAvg, 2);
            mathSD += Math.pow(score.getMathScore() - mathAvg, 2);
        }
        chineseSD = (float) Math.sqrt(chineseSD / studentMap.size());
        mathSD = (float) Math.sqrt(mathSD / studentMap.size());
        this.chineseSD = chineseSD;
        this.mathSD = mathSD;
    }

    public boolean inputFile(String filename)
    {
        String path = System.getProperty ("user.dir") + filename;
        try 
        {
            File file = new File(path);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) 
            {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split(" ");
                int studentNumber = Integer.parseInt(lineArray[0]);
                String name = lineArray[1];
                int chineseScore = Integer.parseInt(lineArray[2]);
                int mathScore = Integer.parseInt(lineArray[3]);
                Score score = new Score(name, chineseScore, mathScore);
                addStudent(studentNumber, score);
            }
            fileScanner.close();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println("File not found");
            System.out.println(e);
            return false;
        }
    }

    public boolean outputFile(String filename)
    {
        String path = System.getProperty ("user.dir") + filename;
        try 
        {
            File file = new File(path);
            if (!file.exists())
            {
                file.createNewFile();
            }
            Formatter fileFormatter = new Formatter(file);
            for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
            {
                int studentNumber = entry.getKey();
                Score score = entry.getValue();
                String name = score.getName();
                int chineseScore = score.getChineseScore();
                int mathScore = score.getMathScore();
                fileFormatter.format("%d %s %d %d\n", studentNumber, name, chineseScore, mathScore);
            }
            fileFormatter.close();
            return true;
        } 
        catch (Exception e) 
        {
            System.out.println("File not found");
            System.out.println(e);
            return false;
        }
    }


}
