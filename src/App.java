import data.Score;
import data.Student;
import java.util.Scanner;

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
                    System.out.println(studentNumber[i] + " " + Score[i].getName());
                    System.out.println(" Chinese: " + Score[i].getChineseScore());
                    System.out.println(" Math: " + Score[i].getMathScore());
                    System.out.println(" Average: " + Score[i].getAvg());
                    System.out.println(" Chinese rank: " + ranktoString(Score[i].getChineseRank()));
                    System.out.println(" Math rank: " + ranktoString(Score[i].getMathRank()));
                    System.out.println(" Average rank: " + ranktoString(Score[i].getAvgRank()));
                    System.out.println();
                }
                continue;
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
}

// System.out.println("1. Add student");
// System.out.println("2. Delete student");
// System.out.println("3. Update student");
// System.out.println("4. Show student");
// System.out.println("5. Show all students");
// System.out.println("6. Show average");
// System.out.println("7. Show standard deviation");
// System.out.println("8. Show rank");
// System.out.println("9. Show all");
// System.out.println("10. Exit");
