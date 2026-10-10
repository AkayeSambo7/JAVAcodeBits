import java.util.*;

public class Grade {
	    //variables
	    int rawGrade;
	    String name;
	    char gradeEquiv;
	    
	    //assign score
    	public void assignScore() {
    	        Scanner scan = new Scanner(System.in);
    	        System.out.print("Enter student's name: ");
    	        name = scan.nextLine();
    	        System.out.print("Enter student's grade: ");
    	        rawGrade = scan.nextInt();
    	        
    	        scan.close();
    	}
    	
    	//assign grade equivalent 
        public void getGradeEquivalent(){
	        if (rawGrade <= 100 && rawGrade >= 90){
	            gradeEquiv = 'A';
	        } else if (rawGrade <= 89 && rawGrade >= 80){
	            gradeEquiv = 'B';
	        } else if (rawGrade <= 79 && rawGrade >= 70){
	            gradeEquiv = 'C';
	        } else if (rawGrade <= 69 && rawGrade >= 60){
	            gradeEquiv = 'D';
	        } else if (rawGrade <= 59 && rawGrade >= 50){
	            gradeEquiv = 'F';
	        } else {
	            System.out.println("Invalid grade.");
	            gradeEquiv = 'N'; //formality
	        }
	    }
	    
	    //result format
	    void displayResult(){
	        System.out.println("\nThe student's computer grade: " + rawGrade);
	        System.out.println(rawGrade + " is equal to = " + gradeEquiv);
	    }
	    
	public static void main(String[] args) {
	    //object
	    Grade studentGrade = new Grade();
	    
	    //calling methods
	    studentGrade.assignScore();
	    studentGrade.getGradeEquivalent();
	    studentGrade.displayResult();
	}
}
