package data;

import java.util.*;

public class student {

    Map<Integer, Score> studentMap = new HashMap<Integer, Score>();
    float chineseSD = 0;
    float mathSD = 0;
    
    public void addStudent(int studentNumber, Score score) 
    {
        studentMap.put(studentNumber, score);
        updateSD();
    }

    public void removeStudent(int studentNumber) 
    {
        studentMap.remove(studentNumber);
        updateSD();
    }

    public void updateStudent(int studentNumber, Score score) 
    {
        studentMap.put(studentNumber, score);
        updateSD();
    }

    public void updateSD()
    {
        float chineseSum = 0;
        float mathSum = 0;
        float chineseAvg = 0;
        float mathAvg = 0;
        float chineseSD = 0;
        float mathSD = 0;
        int count = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) {
            Score score = entry.getValue();
            chineseSum += score.getChineseScore();
            mathSum += score.getMathScore();
            count++;
        }
        chineseAvg = chineseSum / count;
        mathAvg = mathSum / count;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) {
            Score score = entry.getValue();
            chineseSD += Math.pow(score.getChineseScore() - chineseAvg, 2);
            mathSD += Math.pow(score.getMathScore() - mathAvg, 2);
        }
        chineseSD = (float) Math.sqrt(chineseSD / count);
        mathSD = (float) Math.sqrt(mathSD / count);
        this.chineseSD = chineseSD;
        this.mathSD = mathSD;
    }
}
