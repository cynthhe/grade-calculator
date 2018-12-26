import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        // declaration and initialization of variables
        String desFinalGrade, yn, gCurrent = "";
        int wEx1 = 0;
        int wEx2 = 0;
        int wExFin = 0;
        int wLabs = 0;
        int wProj = 0;
        int wAtt = 0;
        int wQiz = 0;
        int wSum = 0;
        int sEx1 = 0;
        int sEx2 = 0;
        int sExFin = 0;
        int sLabs = 0;
        int sProj = 0;
        int sAtt = 0;
        int sQiz = 0;
        int totKnownGradeWeights = 0;
        int finalOverallScore = 0;
        double sCurrent, sumWeightScore, avgToFinalLetterGrade;

        // print grading scale
        System.out.println("Grading Scale: ");
        System.out.println("A \t 90 - 100");
        System.out.println("B \t 80 - 89");
        System.out.println("C \t 70 - 79");
        System.out.println("D \t 60 - 69");
        System.out.println("F \t below 	60");

        // user input - enter letter grade
        Scanner input = new Scanner(System.in);
        System.out.print("What letter grade do you want to achieve for the course? ");
        desFinalGrade = input.nextLine().toUpperCase();

        // prompt user if they entered an invalid grade
        if(desFinalGrade.equals("A") || desFinalGrade.equals("B") || desFinalGrade.equals("C") ||
                desFinalGrade.equals("D") || desFinalGrade.equals("F")) {}
        else {
            System.out.println("Input error");
            System.exit(0);
        }

        // user input - enter percentage weights
        System.out.println("Enter Percentage Weights:");
        System.out.print("Exam 1: \t");
        wEx1 = input.nextInt();
        System.out.print("Exam 2: \t");
        wEx2 = input.nextInt();
        System.out.print("Final Exam: \t");
        wExFin  = input.nextInt();
        System.out.print("Labs: \t\t");
        wLabs = input.nextInt();
        System.out.print("Projects: \t");
        wProj = input.nextInt();
        System.out.print("Attendance: \t");
        wAtt = input.nextInt();
        System.out.print("Quizzes: \t");
        wQiz = input.nextInt();
        wSum = wEx1 + wEx2 + wExFin + wLabs + wProj + wAtt + wQiz;

        // exit if weights don't add up to 100
        if(wSum != 100) {
            System.out.println("Weights don't add up to 100, program exiting...");
            System.exit(0);
        }

        // prompt user to enter scores out of 100
        System.out.println("Enter your scores out of 100:");

        // prompt user to enter exam 1 score
        System.out.print("Do you know your Exam 1 score? ");
        yn = input.next();
        if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
            System.out.print("Score received on exam 1: ");
            sEx1 = input.nextInt();
            totKnownGradeWeights += wEx1;

            // prompt user to enter exam 2 score
            System.out.print("Do you know your Exam 2 score? ");
            yn = input.next();
            if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
                System.out.print("Score received on exam 2: ");
                sEx2 = input.nextInt();
                totKnownGradeWeights += wEx2;

                // prompt user to enter final exam score
                System.out.print("Do you know your Final Exam score? ");
                yn = input.next();
                if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
                    System.out.print("Score received on final exam: ");
                    sExFin = input.nextInt();
                    totKnownGradeWeights += wExFin;
                }
            }
        }

        // prompt user to enter lab average
        System.out.print("Do you know your lab average? ");
        yn = input.next();
        if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
            System.out.print("Average Lab Grade: ");
            sLabs = input.nextInt();
            totKnownGradeWeights += wLabs;
        }

        // prompt user to enter project average
        System.out.print("Do you know your project average? ");
        yn = input.next();
        if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
            System.out.print("Average Project Grade: ");
            sProj = input.nextInt();
            totKnownGradeWeights += wProj;
        }
        System.out.print("Do you know your quiz average? ");
        yn = input.next();
        if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
            System.out.print("Average Quiz Grade: ");
            sQiz = input.nextInt();
            totKnownGradeWeights += wQiz;
        }

        // prompt user to enter attendance average
        System.out.print("Do you know your attendance average? ");
        yn = input.next();
        if(yn.equalsIgnoreCase("y") || yn.equalsIgnoreCase("yes")) {
            System.out.print("Average Attendance Grade: ");
            sAtt = input.nextInt();
            totKnownGradeWeights += wAtt;
        }

        // calculate current score
        sumWeightScore = (double) wEx1*sEx1+wEx2*sEx2+wExFin*sExFin+wLabs*sLabs+wProj*sProj+wAtt*sAtt+wQiz*sQiz;
        sCurrent = sumWeightScore/totKnownGradeWeights;

        // convert to letter grade
        if(sCurrent>=90) {
            gCurrent = "A";
        }
        if(sCurrent>=80 && sCurrent<90) {
            gCurrent = "B";
        }
        if(sCurrent>=70 && sCurrent<80) {
            gCurrent = "C";
        }
        if(sCurrent>=60 && sCurrent<70) {
            gCurrent = "D";
        }
        if(sCurrent<60) {
            gCurrent = "F";
        }

        // determine minimal score necessary for desired grade
        if(desFinalGrade.equals("A")) {
            finalOverallScore = 90;
        }
        if(desFinalGrade.equals("B")) {
            finalOverallScore = 80;
        }
        if(desFinalGrade.equals("C")) {
            finalOverallScore = 70;
        }
        if(desFinalGrade.equals("D")) {
            finalOverallScore = 60;
        }

        // calculate average to final letter grade
        avgToFinalLetterGrade = (100*finalOverallScore-sumWeightScore)/(100-totKnownGradeWeights);

        // print average to final letter grade if achievable
        System.out.printf("Current Grade Score: %.2f \n", sCurrent);
        System.out.println("Your current letter grade is a " + gCurrent);

        // if the user has completed the entire course and got the grade desired
        if(totKnownGradeWeights == 100 && desFinalGrade.equals(gCurrent)) {
            System.out.printf("Congratulations! Your received the %s that you wanted!\n",desFinalGrade);
        }
        // if the user has completed the course but got a grade he/she did not desire
        else if(totKnownGradeWeights == 100) {
            System.out.println("This is your final grade!");
        }
        // the average score the user has to get to receive the desired grade (if still possible)
        if(avgToFinalLetterGrade > 0 && avgToFinalLetterGrade <= 100) {
            System.out.printf("You have to score an average greater than or equal to %.1f in the\nremaining grade items to receive an %s\n",
                    avgToFinalLetterGrade, desFinalGrade);
        }
        // if it is not possible for the user to receive the desired grade (average would have to be >100)
        else if(avgToFinalLetterGrade>=100){
            System.out.printf("Sorry you cannot receive an %s in the course.\n", desFinalGrade);
        }
        // prompt user who does not need any more points to receive the desired grade
        if(avgToFinalLetterGrade <= 0 && totKnownGradeWeights != 100) {
            System.out.println("You will receive at least an " + desFinalGrade + " no matter what");
        }
    }
}
