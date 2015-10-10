package Persion;

import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);
	
	private static String name;
	private static double weight;
	private static String country;
	private static String myclass;
	private static String school;
	private static Student sd1;
	
	public static void main(String[] args) 
	{
		System.out.println("Ten hoc sinh:");
		name = input.nextLine();
		System.out.println("Can nang cua hoc sinh la:");
		weight = Double.parseDouble(input.nextLine());
		System.out.println("Que quan cua hoc sinh:");
		country = input.nextLine();
		System.out.println("Lop cua hoc sinh:");
		myclass = input.nextLine();
		System.out.println("Truong cua hoc sinh la:");
		school = input.nextLine();
		
		sd1 = new  Student(name,weight,country,myclass,school);
		sd1.printStudent();
	}

}
