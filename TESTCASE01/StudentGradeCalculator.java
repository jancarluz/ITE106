import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); 

        String[] studentNames = new String[numStudents];
        double[][] scores = new double[numStudents][];
        double[] averages = new double[numStudents];
        char[] letterGrades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            System.out.print("Enter the number of assignments for " + studentNames[i] + ": ");
            int numAssignments = sc.nextInt();
            scores[i] = new double[numAssignments];

            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                scores[i][j] = sc.nextDouble();
                sum += scores[i][j];
            }
            averages[i] = sum / numAssignments;

            if (averages[i] >= 90) {
                letterGrades[i] = 'A';
            } else if (averages[i] >= 80) {
                letterGrades[i] = 'B';
            } else if (averages[i] >= 70) {
                letterGrades[i] = 'C';
            } else if (averages[i] >= 60) {
                letterGrades[i] = 'D';
            } else {
                letterGrades[i] = 'F';
            }
            sc.nextLine();
        }

        System.out.println("\nStudent Grade Report:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student: " + studentNames[i]);
            System.out.println("Average Score: " + averages[i]);
            System.out.println("Letter Grade: " + letterGrades[i]);
            System.out.println("---------------------");
        }

        double totalClassScore = 0;
        double highestScore = averages[0];
        double lowestScore = averages[0];

        for (double avg : averages) {
            totalClassScore += avg;
            if (avg > highestScore) {
                highestScore = avg;
            }
            if (avg < lowestScore) {
                lowestScore = avg;
            }
        }

        double classAverage = totalClassScore / numStudents;
        System.out.println("Class Average: " + classAverage);
        System.out.println("Highest Average: " + highestScore);
        System.out.println("Lowest Average: " + lowestScore);
    }
}
