import java.util.*;

public class LBS {
    class Student{
        //attributes
        private String name, studID, course;
        
        //constructor
        Student(String name, String studID, String course){
            this.name = name;
            this.studID = studID;
            this.course = course;
        }
        
        //header design
        public String header(String txt) {
            String border = "=".repeat(5);
            System.out.println("\n" + border + txt + border);
            return txt;
        }
        
        //method to read student info
        public void getStudInfo() {
           Scanner scan = new Scanner(System.in);
           
           System.out.print("Name: "); 
           name = scan.nextLine();
           System.out.print("Student ID: ");
           studID = scan.nextLine();
           System.out.print("Course: ");
           course = scan.nextLine();
        }
        
        //print method
        public void displayStudInfo() {
            header("STUDENT INFO");
            System.out.println("Student name: " + name + "\nStudent ID:" + studID + 
                                "\nCourse: " + course);
        }
    }
    
    class Book {
        //attributes
        String title, author;
        boolean isBorrowed;
        int borrowedDays, actualDays;
        double penalty;
        
        //header design
        public String header(String txt) {
            String border = "=".repeat(5);
            System.out.println("\n" + border + txt + border);
            return txt;
        }
        
        //status if the user borrowed a book or is borrowing
        public void borrowBook() {
            Scanner scan = new Scanner(System.in);
            
            if(isBorrowed == true) {         
                System.out.print("\nBorrowed book title: ");
                title = scan.nextLine();
                System.out.print("Book author: ");
                author = scan.nextLine();
                System.out.print("Borrowed for(days): ");
                borrowedDays = scan.nextInt();
                System.out.print("Returned after(days): ");
                actualDays = scan.nextInt(); 
            } else {
                System.out.print("\nBook to borrow: ");
                title = scan.nextLine();
                System.out.print("Book author: ");
                author = scan.nextLine();
                System.out.print("Borrowing for(days): ");
                borrowedDays = scan.nextInt();
            }
        }
        
        //penalty calculation method
        private double returnBook(double penalty) {
            if(actualDays > borrowedDays) {
                penalty = (actualDays - borrowedDays) * 10;
            } else {
                penalty = 0;
            }
            
            return penalty;
        }
        
        //gets user input if borrowing a book or not
        public void getBookInfo(){
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Are you returning a book? (true/false): ");
            isBorrowed = scan.nextBoolean();
            borrowBook();
        }
        
        //print method
        public void displayBookInfo() {
            header("BOOK INFORMATION");
            
            if(isBorrowed == true) {
            System.out.println("Title: " + title + "\nAuthor: " + author + 
                                "\nBorrowed for " + borrowedDays + " days." + 
                                "\nReturned after " + actualDays + " days." +
                                "\nExcess days: " + Math.subtractExact(actualDays, borrowedDays) + 
                                "\nPenalty(+PHP10 per excess day): PHP" + returnBook(penalty));
            } else {
                System.out.println("Title: " + title + "\nAuthor: " + author + 
                                "\nBorrowing for " + borrowedDays + " days.");
            }
        }
        
    }
    
    public static void main (String [] args) {
        //objects
        Scanner scan = new Scanner(System.in);
        LBS lib = new LBS();
        Student stud = lib.new Student("", "", "");
        Book book = lib.new Book();
        Book book2 = lib.new Book();
        
        //attributes
        char cont;
        
        stud.getStudInfo();
        do {    
            book.getBookInfo();
            stud.displayStudInfo();
            book.displayBookInfo();
            System.out.print("Returning or borrowing another book? (y/n): ");
            cont = scan.nextLine().charAt(0);
        } while(cont == 'y' || cont == 'Y');
        
        System.out.print("Good day.");
        
        scan.close();
    }
}
