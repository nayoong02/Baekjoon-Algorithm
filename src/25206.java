import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double creditSum = 0; // 학점 총합
        double gradeSum = 0; //(학점 * 과목평점) 총합
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            String course = st.nextToken();
            double credit = Double.parseDouble((st.nextToken()));
            String grade = st.nextToken();

            if (grade.equals("A+")) {
                creditSum += credit;
                gradeSum += credit * 4.5;
            } else if (grade.equals("A0")) {
                creditSum += credit;
                gradeSum += credit * 4.0;
            } else if (grade.equals("B+")) {
                creditSum += credit;
                gradeSum += credit * 3.5;
            } else if (grade.equals("B0")) {
                creditSum += credit;
                gradeSum += credit * 3.0;
            } else if (grade.equals("C+")) {
                creditSum += credit;
                gradeSum += credit * 2.5;
            } else if (grade.equals("C0")) {
                creditSum += credit;
                gradeSum += credit * 2.0;
            } else if (grade.equals("D+")) {
                creditSum += credit;
                gradeSum += credit * 1.5;
            } else if (grade.equals("D0")) {
                creditSum += credit;
                gradeSum += credit * 1.0;
            } else if (grade.equals("F")) {
                creditSum += credit;
                gradeSum += credit * 0.0;
            }
        }

        System.out.println(gradeSum / creditSum);
    }
}