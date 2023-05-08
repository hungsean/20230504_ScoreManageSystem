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
        String path = System.getProperty ("user.dir") + "\\" + filename;
        System.out.println(path);
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
        String path = System.getProperty ("user.dir") + "\\" + filename;
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

    public Map.Entry<Integer, Score> getStudentByLinear(int studentNumber)
    {
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            if (entry.getKey() == studentNumber)
            {
                return entry;
            }
        }
        return null;
    }

    public Map.Entry<Integer, Score> getStudentByBinary(int studentNumber)
    {
        int left = 0;
        int right = studentMap.size() - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;
            int midStudentNumber = (int) studentMap.keySet().toArray()[mid];
            if (midStudentNumber == studentNumber)
            {
                return (Map.Entry<Integer, Score>) studentMap.entrySet().toArray()[mid];
            }
            else if (midStudentNumber > studentNumber)
            {
                right = mid - 1;
            }
            else if (midStudentNumber < studentNumber)
            {
                left = mid + 1;
            }
        }
        return null;
    }

    public int[] getAllStudentNumber()
    {
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            int studentNumber = entry.getKey();
            studentNumberArray[i] = studentNumber;
            i++;
        }
        return studentNumberArray;
    }

    public String[] getAllStudentName()
    {
        String[] studentNameArray = new String[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            String studentName = score.getName();
            studentNameArray[i] = studentName;
            i++;
        }
        return studentNameArray;
    }

    public float[] getAllStudentAvg()
    {
        float[] studentAvgArray = new float[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            float studentAvg = score.getAvg();
            studentAvgArray[i] = studentAvg;
            i++;
        }
        return studentAvgArray;
    }

    public int[] getAllStudentAvgRank()
    {
        int[] studentRankArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int studentRank = score.getAvgRank();
            studentRankArray[i] = studentRank;
            i++;
        }
        return studentRankArray;
    }

    public float getChineseSD()
    {
        return chineseSD;
    }

    public float getMathSD()
    {
        return mathSD;
    }

    public int[] getCountChineseRank()
    {
        int[] chineseRankArray = new int[6];
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int chineseScore = score.getChineseRank();
            chineseRankArray[chineseScore]++;
        }
        return chineseRankArray;
    }

    public int[] getCountMathRank()
    {
        int[] mathRankArray = new int[6];
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int mathScore = score.getMathRank();
            mathRankArray[mathScore]++;
        }
        return mathRankArray;
    }

    public int[] getCountAvgRank()
    {
        int[] avgRankArray = new int[6];
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int avgScore = score.getAvgRank();
            avgRankArray[avgScore]++;
        }
        return avgRankArray;
    }

    public Score[] getAllScores()
    {
        Score[] scoreArray = new Score[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            scoreArray[i] = score;
            i++;
        }
        return scoreArray;
    }

    public int[] chineseBubbleSort()
    {
        int[] chineseScoreArray = new int[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int chineseScore = score.getChineseScore();
            chineseScoreArray[i] = chineseScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return bubbleSort(chineseScoreArray, studentNumberArray);
    }

    public int[] mathBubbleSort()
    {
        int[] mathScoreArray = new int[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int mathScore = score.getMathScore();
            mathScoreArray[i] = mathScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return bubbleSort(mathScoreArray, studentNumberArray);
    }

    public int[] avgBubbleSort()
    {
        float[] avgScoreArray = new float[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            float avgScore = score.getAvg();
            avgScoreArray[i] = avgScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return bubbleSort(avgScoreArray, studentNumberArray);
    }

    public int[] bubbleSort(int[] array, int[] studentNumberArray)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    int tempStudentNumber = studentNumberArray[j];
                    studentNumberArray[j] = studentNumberArray[j + 1];
                    studentNumberArray[j + 1] = tempStudentNumber;
                }
            }
        }

        return studentNumberArray;
    }

    public int[] bubbleSort(float[] array, int[] studentNumberArray)
    {
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (array[j] > array[j + 1])
                {
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    int tempStudentNumber = studentNumberArray[j];
                    studentNumberArray[j] = studentNumberArray[j + 1];
                    studentNumberArray[j + 1] = tempStudentNumber;
                }
            }
        }

        return studentNumberArray;
    }

    public int[] chineseSelectionSort()
    {
        int[] chineseScoreArray = new int[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int chineseScore = score.getChineseScore();
            chineseScoreArray[i] = chineseScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return selectionSort(chineseScoreArray, studentNumberArray);
    }

    public int[] mathSelectionSort()
    {
        int[] mathScoreArray = new int[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            int mathScore = score.getMathScore();
            mathScoreArray[i] = mathScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return selectionSort(mathScoreArray, studentNumberArray);
    }

    public int[] avgSelectionSort()
    {
        float[] avgScoreArray = new float[studentMap.size()];
        int[] studentNumberArray = new int[studentMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Score> entry : studentMap.entrySet()) 
        {
            Score score = entry.getValue();
            float avgScore = score.getAvg();
            avgScoreArray[i] = avgScore;
            studentNumberArray[i] = entry.getKey();
            i++;
        }
        return selectionSort(avgScoreArray, studentNumberArray);
    }

    public int[] selectionSort(int[] array, int[] studentNumberArray)
    {
        for (int i = 0; i < array.length; i++)
        {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i)
            {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

                int tempStudentNumber = studentNumberArray[i];
                studentNumberArray[i] = studentNumberArray[minIndex];
                studentNumberArray[minIndex] = tempStudentNumber;
            }
        }

        return studentNumberArray;
    }

    public int[] selectionSort(float[] array, int[] studentNumberArray)
    {
        for (int i = 0; i < array.length; i++)
        {
            float min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < min)
                {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (minIndex != i)
            {
                float temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

                int tempStudentNumber = studentNumberArray[i];
                studentNumberArray[i] = studentNumberArray[minIndex];
                studentNumberArray[minIndex] = tempStudentNumber;
            }
        }

        return studentNumberArray;
    }




}
