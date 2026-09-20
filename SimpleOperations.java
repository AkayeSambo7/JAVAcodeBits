import java.util.Scanner;
public class SimpleOperations {
    
    //print name header
    public static String credits(String name){
        String txt = "WELCOME TO " + name.toUpperCase() + "'S PROGRAM";
        int innerWidth = txt.length() + 4; //creates padding around text
        System.out.printf("||%s||%n", "=".repeat(innerWidth)); //top border
        System.out.printf("|| %-" + (innerWidth - 2) + "s ||%n", txt); //border to fit text
        System.out.printf("||%s||%n", "=".repeat(innerWidth)); //bottom border
        return name;
    }
    //print menu method
    public static void menu(){
        System.out.printf("\n%s%n", "=".repeat(10) + "SELECT OPERATION" + "=".repeat(10)); //header format
        System.out.println("1 - MULTIPLY\n2 - DIVISION\n3 - ADDITION\n4 - SUBTRACTION\n5 - CHECK ODD OR EVEN\n6 - QUIT");
        System.out.printf("%s%n", "=".repeat(36)); //footer decoration
    }
    
    //multiplication method
    public static double multiplication(double a, double b){
        double product = a * b;
        return product;
    }
    
    //division method
    public static double division(double a, double b){
        double quotient = a / b;
        return quotient;
    }
    
    //addition method
    public static double addition(double a, double b){
        double sum = a + b;
        return sum;
    }
    
    //subtraction method
    public static double subtraction(double a, double b){
        double difference = a - b;
        return difference;
    }
    
    //check odd or even method
    public static void oddEven(double a, double b){
        double num1 = a;
        double num2 = b;
        
        /*using an inline if-else to check if there's would be a remainder
        and confirm if it's odd or even - (condition) ? if true : if false*/
        System.out.println("\n" + num1 + " is " + ((num1 % 2 == 0) ? " even" : " odd"));
        System.out.println(num2 + " is " + ((num2 % 2 == 0) ? " even" : " odd"));
    }
    
    //just for decoration
    public static void deco(){
        System.out.printf("%s%n", "~".repeat(36));
    }
    
    //main method
    public static void main (String [] args){
        //create scanner
        Scanner scan = new Scanner (System.in);
        
        //local variables
        char counter = 0;
        
        //looping start
        do{
            //store input on variables
            System.out.print("Program created by: ");
            String nameInput = scan.nextLine();
            credits(nameInput); //pass name to method
            System.out.print("Enter first number: ");
            double a = scan.nextDouble();
            System.out.print("Enter second number(different from first): ");
            double b = scan.nextDouble();
            
            //checks if numbers are the same
            if(a == b){
                System.out.println("Must be different numbers.");
                break;
            }
            
            menu(); //call menu
            
            //get operation to be used
            System.out.print("Enter your choice(1-6): ");
            int choice = scan.nextInt();
            
            //conditioning for operation to be used and print result
            System.out.print("Result: ");
            switch(choice){
                case 1:
                    System.out.println(multiplication(a, b));
                    break;
                case 2:
                    System.out.println(division(a, b));
                    break;
                case 3:
                    System.out.println(addition(a, b));
                    break;
                case 4:
                    System.out.println(subtraction(a, b));
                    break;
                case 5:
                    oddEven(a, b);
                    break;
                case 6:
                    break; //exit out of the loop
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            
            //if case  6
            if(choice ==6){
                break; //stops program altogether
            }
            
            //ask to continue
            System.out.print("\nDo you want to continue? (y/n): ");
            counter = scan.next().charAt(0);
            scan.nextLine(); //avoids line skip
            
            //decoration footer
            deco();
            
        }while(counter == 'y' || counter == 'Y');
        
        //system status
        System.out.println("\nProgram has ended.");
        scan.close();
    }
}
