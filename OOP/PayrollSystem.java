import java.util.*;

//parent class
class Employee {
        double getIncome() {
            return 0;
        }
}

//child class 1
class Boss extends Employee {
     int absences; //stores absences

     //constructor
    Boss(int absences) {
        this.absences = absences;
    }
    
    @Override
    double getIncome() {      
        try {
            //if input is negative
            if (absences < 0) {
                throw new IllegalArgumentException("INVALID NUMBER.");
            }
            
            return 55000 - (absences * 2750); //computes salary after absence
            
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }
}

//child class 2
class CommWorker extends Employee {
    double totalSales; //store total sales
    
    //constructor
    CommWorker(double totalSales) {
        this.totalSales = totalSales;
    }
    
    @Override
    double getIncome() {
        try {
            //if input is negative
            if (totalSales < 0) {
                throw new IllegalArgumentException("INVALID NUMBER.");
            }
            double commission = 0; //ommission is 0 by default
            //comms calculation works if comms is more than 5000
            if (totalSales > 5000) {
                commission = totalSales * 0.20;
            }

            return 25000 + commission; //final calculation of total

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
            return 0;
        }
    }
}

//child class 3
class PcWorker extends Employee {
    int pc; //store pieces produced
    
    //constructor
    PcWorker(int pc) {
        this.pc = pc;
    }

    @Override
    double getIncome() {
         return pc * 35;
    }
}
//child class 4
class HrWorker extends Employee {
    int hrs; //stores hours worked
    
    //constructor
    HrWorker(int hrs) {
        this.hrs = hrs;
    }
    
    @Override
    double getIncome() {
         return hrs * 80;
    }
}


//new class to store the system output
class PrintSystem {
    //objects
    Scanner scan = new Scanner(System.in); 
    
    //variables
    private String name, prDate;
    private int type;
    
    //header method
    void header(){
        System.out.println("====HDC CORPORATION====");
        System.out.println("    Payroll System");
    }
    
    //method to get user input
    void getInfo() {
        System.out.print("\nEnter name: ");
        name = scan.nextLine();
        System.out.print("Enter payroll date: ");
        prDate = scan.nextLine();
    }
    
    //method to display selection as well as prints the output
    void displaySelection() {
        System.out.print("""
                         
                         Select type of employee: 
                         [1] Boss
                         [2] Commission Workers
                         [3] Piece Worker
                         [4] Hourly Worker
                         [5] Exit
                         
                         Enter code ->\s"""); //converted to text block by netbeans
        type = scan.nextInt();
        scan.nextLine(); //consumes leftover line/prevents skipping
        
        /*switch-case for the choice.
        each case has an Employee object in specific places
        for it to be able to read user input properly and
        do the calculations*/
        switch(type) {
            case 1:
                System.out.print("\nNumber of days absent: ");
                int absences = scan.nextInt();
                scan.nextLine();
                
                Employee boss = new Boss(absences);
                
                System.out.println("\n" + name + " payroll " + prDate + 
                                    "\nTOTAL SALARY = " + boss.getIncome());
                break;
            case 2:
                System.out.print("\nTotal sales for " + prDate + " = ");
                double sales = scan.nextDouble();
                scan.nextLine(); //consumes leftover line/prevents skipping
                
                Employee commWorker = new CommWorker(sales);
                
                System.out.println("""
                                   Basic salary = 25000.0
                                   Commission =\s""" + (sales * 0.20) + 
                                    "\nTOTAL SALARY = " + commWorker.getIncome());
                break;
            case 3:
                System.out.print("\nPieces produced(" + prDate + "): ");
                int pcs = scan.nextInt();
                scan.nextLine(); //consumes leftover line/prevents skipping
                
                Employee pcWorker = new PcWorker(pcs);
                
                System.out.println("TOTAL SALARY: " + pcWorker.getIncome());
                break;
            case 4:
                System.out.print("\nHours completed(" + prDate + "): ");
                int hrs = scan.nextInt();
                scan.nextLine(); //consumes leftover line/prevents skipping
                
                Employee hrWorker = new HrWorker(hrs);
                
                System.out.println("TOTAL SALARY: " + hrWorker.getIncome());
                break;
            case 5:
                break;
            default:
                System.out.println("INVALID CODE.");
        }
    }
    
    //sytem print method
    void displaySystem() {
        do {
            header();
            getInfo();
            displaySelection();
            
            //condition to stop the program and exit the loop, if case 5 is true
            if(type == 5) {
                break;
            }
            
            System.out.print("\nDo you want to continue? (y/n): ");
            type = scan.nextLine().charAt(0);
            System.out.println(); //next line
        } while(type == 'y' || type == 'Y');
        
        System.out.println("\nPROGRAM HAS ENDED.");     
        
        scan.close();
    }
}

//main class
public class PayrollSystem extends PrintSystem{
    public static void main (String [] args) {
        //objects
        PrintSystem print = new PrintSystem();
        
        print.displaySystem();
    }
}
