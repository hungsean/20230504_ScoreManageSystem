import data.Score;
import data.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Student student = new Student();
        boolean isFile = student.inputFile("test2.txt");
        System.out.println(isFile);
    }
}
