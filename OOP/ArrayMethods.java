import java.util.Scanner;

public class ArrayMethods {
    //global variable(s)
    int counter;
    int operation;
    
    //global object(s)
    Scanner scan = new Scanner(System.in);
    
    //operations menu
    public void Menu(){
        //header
        String txt = "ARRAY OPERATION MENU";
        System.out.println("=".repeat(txt.length() + 6)); //top border
        System.out.printf("  %s  %n", txt); //centers text
        System.out.println("=".repeat(txt.length() + 6)); //bottom border
        
        //options
        System.out.println("1 - ADD\n2 - SUBTRACT\n3 - DIVIDE\n4 - MULTIPLY\n5 - EXIT");
        System.out.print("\nEnter your choice: ");
        operation = scan.nextInt();
    }
    
    //arrOne
    public void GetArrOne(int[] arrOne){
        System.out.println("Enter 10 numbers for arrOne:");
        for (counter = 0; counter < 10; counter++){
            System.out.print("arrOne[" + counter + "]: ");
            arrOne[counter] = scan.nextInt();
        }
    }
    //arrTwo
    public void GetArrTwo(int[] arrTwo){
        System.out.println("\nEnter 10 numbers for arrTwo:");
        for (counter = 0; counter < 10; counter++){
            System.out.print("arrTwo[" + counter + "]: ");
            arrTwo[counter] = scan.nextInt();
        }
    }
    
    //addition
    public void Addition(int[] arrResult, int[] arrOne, int[] arrTwo){
        for (counter = 0; counter < 10; counter++){ 
            arrResult[counter] = arrOne[counter] + arrTwo[counter];
            System.out.println("arrResult[" + counter + "]: " + arrResult[counter]);
        }
    }
    
    //subtraction
    public void Subtraction(int[] arrResult, int[] arrOne, int[] arrTwo){
        for (counter = 0; counter < 10; counter++){ 
            arrResult[counter] = arrOne[counter] - arrTwo[counter];
            System.out.println("arrResult[" + counter + "]: " + arrResult[counter]);
        }
    }
    
    //multiplication
    public void Multiplication(int[] arrResult, int[] arrOne, int[] arrTwo){
        for (counter = 0; counter < 10; counter++){ 
            arrResult[counter] = arrOne[counter] * arrTwo[counter];
            System.out.println("arrResult[" + counter + "]: " + arrResult[counter]);
        }
    }
    
    //division
    public void Division(int[] arrResult, int[] arrOne, int[] arrTwo){
        for (counter = 0; counter < 10; counter++){ 
            arrResult[counter] = arrOne[counter] / arrTwo[counter];
            System.out.println("arrResult[" + counter + "]: " + arrResult[counter]);
        }
    }
    
    //perform operation
    public void Operations(int[] arrResult, int[] arrOne, int[] arrTwo){
        switch (operation) {
            case 1:
                Addition(arrResult, arrOne, arrTwo);
                break;
            case 2:
                Subtraction(arrResult, arrOne, arrTwo);
                break;
            case 3:
                Multiplication(arrResult, arrOne, arrTwo);
                break;
            case 4:
                Division(arrResult, arrOne, arrTwo);
                break;
            case 5:
                System.out.println("Program has ended.");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    
    public static void main (String [] args){
        //local object(s)
        Array obj = new Array(); 
        int[] arrOne = new int[10];
        int[] arrTwo = new int[10];
        int[] arrResult = new int[10];
        
        //method calling
        obj.GetArrOne(arrOne);
        obj.GetArrTwo(arrTwo);
        obj.Menu();
        obj.Operations(arrResult, arrOne, arrTwo);
    }
}
