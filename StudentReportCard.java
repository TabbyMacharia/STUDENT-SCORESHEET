import java.util.Scanner;
public class StudentReportCard {
    public static void main (String[] args) {

        //School details
        Scanner input = new Scanner (System.in);
        System.out.println("Enter the name of your school: ");
        String school_name = input.nextLine();
        System.out.println("Enter the name of your teacher: ");
        String teacher_name = input.nextLine();
        System.out.println("Enter your grade: ");
        int grade = input.nextInt();
        System.out.println("Enter the year: ");
        int year = input.nextInt();
        input.nextLine();

        //Constants
        int students = 2;
        int subjects = 6;

        //Arrays for students records
        String[] studentNames = new String[students];
        double[][] marks= new double[students][subjects];
        double[] totalMarks= new double[students];
        char[] grades = new char[students];
        double[] subjectTotals = new double[subjects];
        double[] subjectAverages = new double[subjects];
        double totalOfSubjectTotals = 0;
        double totalOfSubjectAverages = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countE = 0, countF = 0;

        //Input student data
        for (int i = 0; i < students; i++) {
            input.nextLine();
            System.out.println("Enter name for student "+(i + 1) + ": ");
            studentNames[i] = input.nextLine();

            for (int j = 0; j < subjects; j++) {
                input.nextLine();
                System.out.println("Enter the marks for each subject "+(j + 1) + ": ");
                marks[i][j] = input.nextDouble();

                totalMarks[i] += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }
            //Grading System
            if (totalMarks[i] >= 540) {
                grades[i] = 'A';
                countA++;
            } else if (totalMarks[i]>= 480){
                grades[i] = 'B';
                countB++;
            } else if (totalMarks[i] >= 420) {
                grades[i] = 'C';
                countC++;
            } else if (totalMarks[i] >= 360) {
                grades[i] = 'D';
                countD++;
            } else {
                grades[i] = 'F';
                countF++;
            }
        }

        for (int j = 0; j < subjects; j++) {
            subjectAverages[j] = subjectTotals[j] / students;
        }
        double studentTotalsTotal = 0;
        for (double tm : totalMarks) {
            studentTotalsTotal += tm;
        }
        double studentTotalsAverage = studentTotalsTotal / students;

        //Output Report
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t\t\t\t\t\tSchool Name: " + school_name);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tTeacher: " + teacher_name);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t  Grade: "+grade);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t   Year: "+year);
        System.out.println("===================================================================================================================================================");
        System.out.println("Student Name\t\t\t\tEnglish\t\tMath\t\tHistory\t\tGeography\tScience\tProgramming\t\tTotal\tRank");
        System.out.println("===================================================================================================================================================");

        for (int i = 0; i < students; i++) {
            System.out.print(studentNames[i] +"  \t\t\t\t");
            for (int j = 0; j < subjects; j++) {
                System.out.print(marks[i][j] +"\t\t");
            }
            System.out.print(totalMarks[i]+" \t"+grades[i] +"\n");
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t\t\t\t");
        for (int j=0; j<subjects; j++) {
            System.out.print(subjectTotals[j]+"\t\t");
        }
        System.out.print(studentTotalsTotal);
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("\t\t\t\t\t\t\t");
        for (int j = 0; j < subjects; j++) {
            System.out.printf("%.2f\t\t", subjectAverages[j]);
        }
        System.out.printf("%.2f", studentTotalsAverage);
        System.out.println();
        System.out.println("===================================================================================================================================================");
        System.out.print("\t\t\t\t\t\t Ranks \t\tA's: "+countA+ "\t\tB's: "+countB+ "\t\tC's: "+countC+ "\t\tD's: "+countD+ "\t\tF's: "+countF);
    }
}
