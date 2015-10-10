package Persion;

public class Student extends Persion 
{
	private String  myclass;
	private String schoool;
	
	public Student(String _name, double _weight, String _country, String _myclass, String _school)
	{
		this.name = _name;
		this.weight = _weight;
		this.country = _country;
		this.myclass = _myclass;
		this.schoool = _school;
	}
	
	public Student()
	{
		
	}
	
	public void printStudent()
	{
		System.out.println("Ten hoc sinh:"+name);
		System.out.println("Can nang cua hoc sinh la:"+weight);
		System.out.println("Que quan cua hoc sinh:"+country);
		System.out.println("Lop cua hoc sinh:"+myclass);
		System.out.println("Truong cua hoc sinh la:"+schoool);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String _name)
	{
		this.name = _name;
	}
	
}
