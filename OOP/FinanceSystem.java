import java.util.*;

//interface Taxable
interface Taxable{   
    double calculateTax(double taxRate);
    double calculateIncomeTax(double salary);
    double totalTax(double taxRate);
}

//where all data needed is stored
class Info{
    //Employee class with access to interface Taxable
    class Employee implements Taxable{
        private String name;
        private double purchase, salary;

        //constructor
        Employee(String name, double purchase, double salary){
            this.name = name;
            this.purchase = purchase;
            this.salary = salary;
        }
        
        //getters to access private attributes
        String getName() {
            return name;
        }

        double getPurchase() {
            return purchase;
        }
        
        double getSalary() {
            return salary;
        }

        //implement interface Taxable
        @Override
        public double calculateTax(double taxRate){
            taxRate *= purchase; //calculates the tax
            return taxRate; 
        }
        
        //overwrites the user input salary to the calculated income tax
        @Override
        public double calculateIncomeTax(double salary) {
            if(salary > 250000 && salary <= 400000) {
                salary = 0.15 * 250000;
            } else if(salary > 400000 && salary <= 800000) {
                salary = 225000 + (0.20 * 400000);
            } else if (salary > 800000 && salary <= 2000000) {
                salary = 102500 + (0.25 * 800000);
            } else if (salary > 2000000 && salary <= 8000000) {
                salary = 402500 + (0.30 * 2000000);
            } else if (salary > 8000000) {
                salary = 2202500 + (0.35 * 8000000);
            } else {
                return 0; //returns as 0 tax
            }
            return salary;
        }
        
        /*calculates total Tax using a later-initialized taxRate in parameter.
        It uses taxRate as a parameter to be able to access the process of
        calculateTax*/
        @Override
        public double totalTax(double taxRate) {
            taxRate = calculateTax(taxRate) + calculateIncomeTax(salary);
            return taxRate;
        }
    }
}

//class output with access to Info class
class Output extends Info{
    //object to access attributes in class Employee
    private Employee emp;
    
    //getting user input
    void getInfo(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("ENTER NAME: ");
        String name = sc.nextLine();
        System.out.print("ENTER TOTAL PURCHASE: ");
        double purchase = sc.nextDouble();
        System.out.print("ENTER ANNUAL INCOME: ");
        double salary = sc.nextDouble();
        
        //new Employee object so user input can be saved in class Employee
        emp = new Employee(name, purchase, salary);
    }
    
    //header deco
    public void header(){
        String txt = "TAX CALCULATION";
        String border = "=".repeat(5);
        System.out.println("\n" + border + txt + border);
    }
    
    //prints the details
    public void printInfo(){
        System.out.printf("Employee: " + emp.getName() + "\nTotal purchase: " + emp.getPurchase() + 
                "\nPurchase tax: " + String.format("%.2f%n", emp.calculateTax(0.12)) +
                "\n\nAnnual income: " + emp.getSalary() +
                "\nIncome tax: " + String.format("%.2f%n", emp.calculateIncomeTax(emp.getSalary())) + 
                "\nTotal tax: " + String.format("%.2f%n", emp.totalTax(0.12)));
                //string.format limits the double to 2 decimal places
    } 
}

//main class
class FinanceSystem extends Output{
    public static void main (String [] args){
        //objects
        FinanceSystem main = new FinanceSystem();
        Scanner sc = new Scanner(System.in);
        
        //variables
        char cont;
        
        //main loop + output
        do{
            main.getInfo();
            main.header();
            main.printInfo();
            System.out.print("Do you want to continue? (y/n): ");
            cont = sc.next().charAt(0);
            System.out.println(); //line break
        } while (cont == 'y' || cont == 'Y');
        System.out.print("Program has ended.");
        
        sc.close();
    }
}
