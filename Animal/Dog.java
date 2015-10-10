package Animal;
import java.util.Scanner;

public class Dog extends Animal
{
	Scanner input = new Scanner(System.in);
	
	public Dog()
	{
		
	}
	
	// Cai nay tao ra de luc nao can gan gia tri luon ham o Main thi su dung
	public Dog(String _name, String _kind, double _weight, double _height )
	{
		setName(_name);
		setKind(_kind);
		setWeight(_weight);
		setHeight(_height);
	}

	public void inputDog()
	{
		System.out.println("Ten Cho :");
		setName(input.nextLine());
		System.out.println("Loai Cho :");
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
		System.out.println("Ten Cho :"+getName());
		System.out.println("Loai Cho :"+getKind());
		System.out.println("Can nang :"+getWeight());
		System.out.println("Chieu cao :"+getHeight());
		System.out.println("-----------------------------------------------------------");
	}

	

	
}
