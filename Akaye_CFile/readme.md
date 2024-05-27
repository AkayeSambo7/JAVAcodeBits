using System;
using System.Collections.Generic;
using System.Linq;
					
public class Program
{
	public static void Main()
	{
		Console.WriteLine("Good Afternoon to the following: "); //salutations
		List<Student> students = new List<Student>();  //creating a list of students for Student
		//var students = new List<Student>();
		students.Add(new Student() 
					 {
						 Name = "Akaye",
						 Age = 17
					 });
		students.Add(new Student() 
					 {
						 Name = "Juz",
						 Age = 19
					 });
		students.Add(new Student() 
					 {
						 Name = "Alez",
						Age = 18
					 });
		students.Add(new Student() 
					 {
						 Name = "Chan",
						 Age = 19
					 });
		students.Add(new Student() 
					 {
						 Name = "Med",
						 Age = 17
					 });
		students.Add(new Student() 
					 {
						 Name = "Cian",
						 Age = 18
					 });
		
		students.ForEach(student => 
						 {
							 Console.WriteLine("- " + student.Name + ", " + student.Age + "."); //For each student applied
						 });
		
		Console.Write("\nOldest age of students: ");
		Console.WriteLine(students.Max(student => student.Age + "\n")); //finding highest vaue
		var studentsBelow18 = students.Where(student => student.Age < 18).Select(student => student.Name).ToList(); //finding students below 18
		studentsBelow18.ForEach(sb18 => 
						 {
							 Console.WriteLine("Student below 18: " + sb18); //For each student below 18 applied
						 });
		
		var studentsAged100 = students.Any(student => student.Age == 100); //finding students aged 100
		Console.WriteLine("\nIs there a student aged 100? " + studentsAged100);
	}
}

public class Student 
{
	public string Name {get; set;}
	public int Age {get; set;}
}
