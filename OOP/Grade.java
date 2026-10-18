import java.util.*;

public class Grade {
    //variables
    int quiz1, quiz2, midterms, finals;
    double quizTotal, examTotal, computedGrade;
    String name;
    char gradeEquiv;
	    
    //header
    void header() {
        String txt = "STUDENT INFORMATION";
        System.out.println("=".repeat(txt.length() + 6)); //top border
        System.out.printf("  %s  %n", txt); //centers text
        System.out.println("=".repeat(txt.length() + 6)); //bottom border
    }
            
    //assign score
    public void assignScore() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scan.nextLine();
        System.out.print("Enter quiz 1 (0-10): ");
        quiz1 = scan.nextInt();
        //conditions
            if (quiz1 < 0 && quiz1 > 10)
                System.out.println("Invalid score.");
        System.out.print("Enter quiz 2 (0-10): ");
        quiz2 = scan.nextInt();
        //conditions
            if (quiz2 < 0 && quiz2 > 10)
                System.out.println("Invalid score.");
        System.out.print("Enter midterm exam score (0-100): ");
        midterms = scan.nextInt();
            //conditions
            if (midterms < 0 && midterms > 100)
                System.out.println("Invalid score.");
        System.out.print("Enter final exam score (0-100): ");
        finals = scan.nextInt();
            //conditions
            if (finals < 0 && finals > 100)
                System.out.println("Invalid score.");

        scan.close();
    }
    	
    //compute for final grade
    public void finalGrade(){
        //compute for quiz
        quizTotal = quiz1 + quiz2;
        quizTotal /= 20;
        quizTotal *= 100;
        quizTotal *= 0.25;
        
        //compute for exams
        examTotal = midterms * 0.25 + finals * 0.50;
        
        
        //compute total
        computedGrade = quizTotal + examTotal;
    }
    
    //assign grade equivalent 
    public void getGradeEquivalent(){
        //compute for final grade

        if (computedGrade <= 100 && computedGrade >= 90){
            gradeEquiv = 'A';
        } else if (computedGrade <= 89 && computedGrade >= 80){
            gradeEquiv = 'B';
        } else if (computedGrade <= 79 && computedGrade >= 70){
            gradeEquiv = 'C';
        } else if (computedGrade <= 69 && computedGrade >= 60){
            gradeEquiv = 'D';
        } else if (computedGrade <= 59 && computedGrade >= 50){
            gradeEquiv = 'F';
        } else {
            System.out.println("Invalid grade.");
            gradeEquiv = 'N'; //formality
        }
    }
	    
    //result format
    void displayResult(){
        //header
        String txt = "STUDENT REPORT";
        System.out.println("=".repeat(txt.length() + 6)); //top border
        System.out.printf("  %s  %n", txt); //centers text
        System.out.println("=".repeat(txt.length() + 6)); //bottom border
        
        System.out.println("STUDENT NAME: " + name);
        System.out.println("QUIZ 1: " + (double)quiz1 + "/10" +
                            "\nQUIZ 2: " + (double)quiz2 + "/10");
        System.out.println("MIDTERM EXAM: " + (double)midterms + "/100" +
                            "\nFINAL EXAM: " + (double)finals + "/100");
        System.out.println("FINAL GRADE: " + computedGrade +
                            "\nLETTER GRADE: " + gradeEquiv);
    }
	    
	public static void main(String[] args) {
	    //object
	    Grade studentGrade = new Grade();
	    
	    //calling methods
		studentGrade.header();
	    studentGrade.assignScore();
		studentGrade.finalGrade();
	    studentGrade.getGradeEquivalent();
	    studentGrade.displayResult();
	}
}
