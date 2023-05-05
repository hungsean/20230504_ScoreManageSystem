package data;

import java.util.*;

public class student {

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
}
