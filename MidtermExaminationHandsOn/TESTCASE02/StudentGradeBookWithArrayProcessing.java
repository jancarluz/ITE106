import java.util.Scanner;

public class StudentGradeBookWithArrayProcessing{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        
        String[] names = new String[numStudents];
        int[][] grades = new int[numStudents][3];
        
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
            
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                grades[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        double[] averageScores = new double[numStudents];
        String[] letterGrades = new String[numStudents];
        
        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += grades[i][j];
            }
            averageScores[i] = total / 3.0;
            letterGrades[i] = assignLetterGrade(averageScores[i]);
        }
        System.out.printf("%-20s %-10s %-10s %-10s %-10s%n", "Student Name", "Score 1", "Score 2", "Score 3", "Average");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s %-10d %-10d %-10d %-10.2f (%s)%n", names[i], grades[i][0], grades[i][1], grades[i][2], averageScores[i], letterGrades[i]);
        }

        double highest = averageScores[0], lowest = averageScores[0];
        for (double score : averageScores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        System.out.println("Highest average score: " + highest);
        System.out.println("Lowest average score: " + lowest);

        for (int i = 0; i < averageScores.length - 1; i++) {
            for (int j = 0; j < averageScores.length - 1 - i; j++) {
                if (averageScores[j] > averageScores[j + 1]) {
                    double tempAvg = averageScores[j];
                    averageScores[j] = averageScores[j + 1];
                    averageScores[j + 1] = tempAvg;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    int[] tempGrades = grades[j];
                    grades[j] = grades[j + 1];
                    grades[j + 1] = tempGrades;
                }
            }
        }

        System.out.println("Sorted by average scores:");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-20s %.2f%n", names[i], averageScores[i]);
        }

        scanner.close();
    }

    private static String assignLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }
}
