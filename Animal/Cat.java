package Animal;
import java.util.Scanner;
public class Cat extends Animal
{
	Scanner input = new Scanner(System.in);
	public Cat()
	{
		
	}
	public Cat(String _name, String _kind, double _weight, double _height )
	{
		
	}
	
	public void inputCat()
	{
		System.out.println("Ten Meo :");
		setName(input.nextLine());
		System.out.println("Loai Meo :");
		setKind(input.nextLine());
		System.out.println("Can nang :");
		setWeight(Double.parseDouble(input.nextLine()));
		System.out.println("Chieu cao :");
		setHeight(Double.parseDouble(input.nextLine()));
	}
	
	@Override
	public void printAnimal() 
	{
		System.out.println("-----------------------------------------------------------");
		System.out.println("Ten Meo :"+getName());
		System.out.println("Loai Meo :"+getKind());
		System.out.println("Can nang :"+getWeight());
		System.out.println("Chieu cao :"+getHeight());
		System.out.println("-----------------------------------------------------------");
	}
	
}
