import data.Score;
import data.Student;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

public class App {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        String filename = "test2.txt";
        boolean isFile = student.inputFile(filename);
        System.out.println(isFile);
        
        while (true)
        {
            System.out.println();
            System.out.println("Please enter code:");
            System.out.println("or enter help to show all commands");
            Scanner scanner = new Scanner(System.in);
            String code = scanner.nextLine();
            if (code.equals("help"))
            {
                System.out.println("1 : Set file name");
                System.out.println("2 : Print all student average");
                System.out.println("3 : Print all student average rank");
                System.out.println("4 : Print all student standard deviation");
                System.out.println("5 : Print counts of each rank");
                System.out.println("6 : Print all student information");
                System.out.println("7 : Sort all student by bubble sort");
                System.out.println("├── 1 : Sort by Chinese score");
                System.out.println("├── 2 : Sort by Math score");
                System.out.println("├── 3 : Sort by average score");
                System.out.println("└── 4 : escape");
                System.out.println("8 : Sort all student by selection sort");
                System.out.println("├── 1 : Sort by Chinese score");
                System.out.println("├── 2 : Sort by Math score");
                System.out.println("├── 3 : Sort by average score");
                System.out.println("└── 4 : escape");
                System.out.println("9 : Search student by linear search");
                System.out.println("10: Search student by binary search");
                System.out.println("0 : exit");



                continue;
            }

            if (code.equals("1"))//Set file name
            {
                System.out.println("Please enter file name:");
                filename = scanner.nextLine();
                isFile = student.inputFile(filename);
                System.out.println("Input :" + isFile);
                isFile = student.outputFile(filename);
                System.out.println("Output :" + isFile);
                continue;
            }

            if (code.equals("2"))//Print student average
            {
                int[] studentNumber = student.getAllStudentNumber();
                String[] studentName = student.getAllStudentName();
                float[] studentAvg = student.getAllStudentAvg();
                System.out.println();
                for (int i = 0; i < studentNumber.length; i++)
                {
                    System.out.println(studentNumber[i] + " " + studentName[i] + " " + studentAvg[i]);
                }
                continue;
            }

            if (code.equals("3"))//Print student rank
            {
                int[] studentNumber = student.getAllStudentNumber();
                String[] studentName = student.getAllStudentName();
                int[] studentRank = student.getAllStudentAvgRank();
                System.out.println();
                for (int i = 0; i < studentNumber.length; i++)
                {
                    System.out.println(studentNumber[i] + " " + studentName[i] + " " + ranktoString(studentRank[i]));
                }
                continue;
            }

            if (code.equals("4"))//Print student standard deviation
            {
                float chineseSD = student.getChineseSD();
                float mathSD = student.getMathSD();

                System.out.println("Chinese SD: " + chineseSD);
                System.out.println("Math SD: " + mathSD);
                continue;
            }

            if (code.equals("5"))//Print counts of each rank
            {
                int[] countChineseRank = student.getCountChineseRank();
                int[] countMathRank = student.getCountMathRank();
                int[] countAvgRank = student.getCountAvgRank();
                System.out.println("Chinese rank count:");
                for (int i = 5; i >= 0; i--)
                {
                    System.out.println(ranktoString(i) + " : " + countChineseRank[i]);
                }
                System.out.println("Math rank count:");
                for (int i = 5; i >= 0; i--)
                {
                    System.out.println(ranktoString(i) + " : " + countMathRank[i]);
                }
                System.out.println("Avg rank count:");
                for (int i = 5; i >= 0; i--)
                {
                    System.out.println(ranktoString(i) + " : " + countAvgRank[i]);
                }
                continue;
            }

            if (code.equals("6"))//Print all student information
            {
                int[] studentNumber = student.getAllStudentNumber();
                Score[] Score = student.getAllScores();
                System.out.println();
                for (int i = 0; i < studentNumber.length; i++)
                {
                    printStudent(studentNumber[i], Score[i]);
                }
                continue;
            }

            if (code.equals("7"))//Sort all student by bubble sort
            {
                System.out.println("Please enter sort type:");
                System.out.println("├── 1 : Sort by Chinese score");
                System.out.println("├── 2 : Sort by Math score");
                System.out.println("├── 3 : Sort by average score");
                System.out.println("└── 4 : escape");
                code = scanner.nextLine();
                int[] sortedArray;
                if (code.equals("1"))
                {
                    sortedArray = student.chineseBubbleSort();
                    
                }
                else if (code.equals("2"))
                {
                    sortedArray = student.mathBubbleSort();
                    
                }
                else if (code.equals("3"))
                {
                    sortedArray = student.avgBubbleSort();
                    
                }
                else
                {
                    continue;
                }
                for(int sortedInt : sortedArray)
                {
                    printStudentH(sortedInt,student.getStudentByBinary(sortedInt).getValue());
                }

            }

            if (code.equals("8"))//Sort all student by selection sort
            {
                System.out.println("Please enter sort type:");
                System.out.println("├── 1 : Sort by Chinese score");
                System.out.println("├── 2 : Sort by Math score");
                System.out.println("├── 3 : Sort by average score");
                System.out.println("└── 4 : escape");
                code = scanner.nextLine();
                int[] sortedArray;
                if (code.equals("1"))
                {
                    sortedArray = student.chineseSelectionSort();
                    
                }
                else if (code.equals("2"))
                {
                    sortedArray = student.mathSelectionSort();
                    
                }
                else if (code.equals("3"))
                {
                    sortedArray = student.avgSelectionSort();
                    
                }
                else
                {
                    continue;
                }
                for(int sortedInt : sortedArray)
                {
                    printStudentH(sortedInt,student.getStudentByBinary(sortedInt).getValue());
                }

            }

            if (code.equals("9"))//Search student by binary search
            {
                System.out.println("Please enter searching student number:");
                int searchStudentNumber = scanner.nextInt();
                Map.Entry<Integer, Score> searchResult = student.getStudentByBinary(searchStudentNumber);
                if (searchResult == null)
                {
                    System.out.println("Not found");
                }
                else
                {
                    printStudent(searchStudentNumber, searchResult.getValue());
                }
                continue;
            }

            if (code.equals("10"))//Search student by linear search
            {
                System.out.println("Please enter searching student number:");
                int searchStudentNumber = scanner.nextInt();
                Map.Entry<Integer, Score> searchResult = student.getStudentByLinear(searchStudentNumber);
                if (searchResult == null)
                {
                    System.out.println("Not found");
                }
                else
                {
                    printStudent(searchStudentNumber, searchResult.getValue());
                }
                continue;
            }

            if (code.equals("0"))//Exit
            {
                break;
            }
        }
    }

    public static String ranktoString(int rank)
    {
        if (rank == 5)
        {
            return "特優";
        }
        else if (rank == 4)
        {
            return "優";
        }
        else if (rank == 3)
        {
            return "甲";
        }
        else if (rank == 2)
        {
            return "乙";
        }
        else if (rank == 1)
        {
            return "丙";
        }
        else
        {
            return "不及格";
        }
    }

    public static void printStudent(int studentNumber, Score score)
    {
        System.out.println(studentNumber + " " + score.getName());
        System.out.println(" Chinese: " + score.getChineseScore());
        System.out.println(" Math: " + score.getMathScore());
        System.out.println(" Average: " + score.getAvg());
        System.out.println(" Chinese rank: " + ranktoString(score.getChineseRank()));
        System.out.println(" Math rank: " + ranktoString(score.getMathRank()));
        System.out.println(" Average rank: " + ranktoString(score.getAvgRank()));
        System.out.println();
    }

    public static void printStudentH(int studentNumber, Score score)
    {
        System.out.print(studentNumber + " " + score.getName());
        System.out.print(" " + score.getChineseScore());
        System.out.print(" " + score.getChineseRank());
        System.out.print(" " + score.getMathScore());
        System.out.print(" " + score.getMathRank());
        System.out.print(" " + score.getAvg());
        System.out.print(" " + score.getAvgRank());

    }

}


