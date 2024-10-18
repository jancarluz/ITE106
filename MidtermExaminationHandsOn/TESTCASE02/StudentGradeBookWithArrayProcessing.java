import java.util.Scanner;

public class StudentGradeBookWithArrayProcessing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();
        System.out.print("Enter the number of assignments: ");
        int numAssignments = sc.nextInt();

        
        String[] studentNames = new String[numStudents];
        double[][] grades = new double[numStudents][numAssignments];
        double[] averages = new double[numStudents];
        char[] letterGrades = new char[numStudents];

        
        for (int i = 0; i < numStudents; i++) {
            sc.nextLine(); 
             System.out.print("Enter name for student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            double sum = 0;
            for (int j = 0; j < numAssignments; j++) {
                System.out.print("Enter grade for assignment " + (j + 1) + ": ");
                grades[i][j] = sc.nextDouble();
                sum += grades[i][j];
            }

            
            averages[i] = sum / numAssignments;
            letterGrades[i] = getLetterGrade(averages[i]);
        }

      
        System.out.println("\nStudent Grades:");
        System.out.println("Name\t\tAverage\t\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s\t%.2f\t\t%c\n", studentNames[i], averages[i], letterGrades[i]);
        }

        
        double highestAverage = averages[0];
        double lowestAverage = averages[0];
        for (int i = 1; i < numStudents; i++) {
            if (averages[i] > highestAverage) highestAverage = averages[i];
            if (averages[i] < lowestAverage) lowestAverage = averages[i];
        }
        System.out.printf("\nHighest Average: %.2f\n", highestAverage);
        System.out.printf("Lowest Average: %.2f\n", lowestAverage);

       
        sortStudentsByAverage(studentNames, averages, letterGrades);

        
        System.out.println("\nSorted by Average:");
        System.out.println("Name\t\tAverage\t\tGrade");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s\t%.2f\t\t%c\n", studentNames[i], averages[i], letterGrades[i]);
        }
    }

    
    private static char getLetterGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }

    
    private static void sortStudentsByAverage(String[] names, double[] averages, char[] grades) {
        for (int i = 0; i < averages.length - 1; i++) {
            for (int j = i + 1; j < averages.length; j++) {
                if (averages[i] < averages[j]) {
                    
                    double tempAvg = averages[i];
                    averages[i] = averages[j];
                    averages[j] = tempAvg;

                    
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;

                   
                    char tempGrade = grades[i];
                    grades[i] = grades[j];
                    grades[j] = tempGrade;
                }
            }
        }
    }
        }
