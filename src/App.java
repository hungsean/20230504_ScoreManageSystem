import data.Score;

public class App {
    public static void main(String[] args) throws Exception {
        Score s1 = new Score("John", 91, 80);
        System.out.println(s1.getSum());
        System.out.println(s1.getAvg());
    }
}
